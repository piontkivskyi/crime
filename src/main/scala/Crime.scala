package crime

import services.CrimesAggregationService
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
      case Some(path) => CrimesAggregationService.aggregate(
          IOUtils.getFilesListFromDirectory(path).flatMap(parse)
        )

      case None => throw new Exception("Something went wrong")
    }

    result.foreach(item => {
      println(s"${item._1} : ${item._2.length}")
      println("Thefts:")
      item._2.filter(_.crimeType.contains("Theft")).foreach(crime => println(crime.crimeType))
      println("--------------------")
    })
  }
}