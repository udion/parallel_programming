object HelloThread{
  def main(args: Array[String]){
    class HelloThread extends Thread{
      override def run() {
        println("greetings from")
        println("udion!")
      }
    }

    /**
    Instansiating 2 threads and running them together
    will not guarantee of them executing in parallel
    unless explicitly synchronisation is called
    to observe this run it several time to see different output
    */

    val t = new HelloThread
    val s = new HelloThread
    t.start()
    s.start()
    t.join()
    s.join()
  }
}
