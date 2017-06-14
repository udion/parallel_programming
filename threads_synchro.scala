/*
Uisng the synchronized block I can force the atomicity on the getuid() method
which does not allow the processing of the same function simultaenously with 2 threads
this is implented using "monitor" at anyinstant only one thread is allowed to have the "monitor"
*/
object sync{
  def main(args: Array[String]){
    val x = new AnyRef{}
    var uid = 0L

    def getuid(): Long = x.synchronized{
      uid = uid + 1
      uid
    }

    def startthread() = {
      val t = new Thread{
        override def run() = {
          val uids = for(i <- 0 until 10) yield getuid()
          println(uids)
        }
      }
      t.start()
    }

    startthread();
    startthread();
  }
}
