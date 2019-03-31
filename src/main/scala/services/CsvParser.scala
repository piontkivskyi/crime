package services

import java.io.File

import dto.CrimeData

import scala.io.Source
import scala.util.Try

/**
  * CsvParser is used to parse csv
  */
object CsvParser {
  /**
    * Parse csv file and map it into CrimeData dto
    * @param file
    * @return
    */
  def parse(file: File): List[CrimeData] = {
    for {
      line <- Source.fromFile(file).getLines().drop(1).toList
      values = line.split(",").map(_.trim)
    } yield CrimeData(
      values(0),
      values(1),
      values(2),
      values(3),
      // can be empty string - get default value if so
      (Try { values(4).toDouble } getOrElse (0), Try { values(5).toDouble } getOrElse(0)),
      values(6),
      values(7),
      values(8),
      values(9)
    )
  }
}
