package services

import java.io.File

import dto.CrimeData
import org.scalatest.FlatSpec

class CsvParserTest extends FlatSpec {
  "CsvParser" should "parse file and map data into CrimeData" in {

    val result = CsvParser.parse(new File(getClass.getResource("/mocks/mock.csv").toURI))

    assert(result.nonEmpty)
    assert(result.length == 2)

    assert(result(0).isInstanceOf[CrimeData])
    assert(result(0).crimeId.contentEquals("53975fc0e75b47e64d703a7cba08ae8636b3131b0f6c61319ea1f51952aa5692"))

    assert(result(1).crimeId.isEmpty)
  }
}
