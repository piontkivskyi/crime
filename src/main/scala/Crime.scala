package crime

import services.CsvParser.parse
import utils.{CommandLineArgsParser, IOUtils}
import validators.ArgsValidator

/**
  * Program entry point
  *
  */
object Crime extends App {
  /**
    * Entry point
    * @param args
    */
  override def main(args: Array[String]): Unit = {
    val parsedArgs = CommandLineArgsParser.parse(args)

    if (!ArgsValidator.validate(parsedArgs)) {
      throw new IllegalArgumentException("Crimes folder should be specified")
    }

    val result = parsedArgs.find(_._1 == "-d").map(_._2) match {
      case Some(path) => IOUtils.getFilesListFromDirectory(path)
        .flatMap(parse)
        .filter(_.crimeId.nonEmpty)
        .groupBy(_.location)
        .toList.sortBy(_._2.length)(Ordering[Int].reverse).take(5)
      case None => throw new Exception("Something went wrong")
    }

    result.take(1).foreach(item => println(s"${item._1} : ${item._2.length} \n Threfs: \n ${item._2.map(crime => s"${crime.crimeType} \n")}"))
  }
}