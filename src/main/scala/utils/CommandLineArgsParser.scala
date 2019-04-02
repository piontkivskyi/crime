package utils

/**
  * Helper for parsing command line args
  *
  * Parse -d <folder_path> to List(("-d", "<folder_path>"))
  */
object CommandLineArgsParser {
  /**
    * Get Array of args and parse it to List of Tuple2 (pairs)
    *
    * @param args
    * @return
    */
  def parse(args: Array[String]): List[(String, String)] = {
    args.iterator
      .sliding(2, 2)
      .withPartial(false).toList
      .map { case List(a, b) => (a,b) }
  }
}
