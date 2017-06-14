/**this code doesnot have syncronisation block and hence
the exectution of 2 threads can be interleaved, and this may lead to problem
such as one thread updates the uid(the commmon private variable) but before it
is written in the memory the other thread also calls getuid and gets the same
updated value as first one and then both write the same value in the memory heap
*/
object unsync {
  private var uid = 0L
  def main(args: Array[String]){

    def getuid(): Long = {
      uid = uid+1;
      uid
    }

    def startthread() = {
      val t = new Thread {
        override def run() = {
          val uids = for (i <- 0 until 10) yield getuid()
          println(uids)
        }
      }
      t.start()
    }

    startthread()
    startthread()
  }
}
