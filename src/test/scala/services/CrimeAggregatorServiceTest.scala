package services

import java.io.File

import dto.CrimeData
import org.scalatest.FlatSpec

class CrimeAggregatorServiceTest extends FlatSpec {
  "CrimeAggregatorService " should "Return list of pairs grouped by coordinates" in {
    val res = CrimesAggregationService.aggregate(CsvParser.parse(new File(getClass.getResource("/mocks/mock.csv").toURI)))

    assert(res.nonEmpty)

    // if length == 1 - items with nullable crimeId is filtered
    assert(res.length == 1)
    assert(res(0)._2.length == 1)
  }

  it should "return 5 items item after aggregation" in {
    val mock = List(
      CrimeData("1", "a", "b", "c", (1.0, 1.0), "d", "e", "f", "g"),
      CrimeData("2", "a", "b", "c", (2.0, 1.0), "d", "e", "f", "g"),
      CrimeData("3", "a", "b", "c", (3.0, 1.0), "d", "e", "f", "g"),
      CrimeData("4", "a", "b", "c", (4.0, 1.0), "d", "e", "f", "g"),
      CrimeData("5", "a", "b", "c", (6.0, 1.0), "d", "e", "f", "g"),
      CrimeData("6", "a", "b", "c", (7.0, 1.0), "d", "e", "f", "g")
    )

    val res = CrimesAggregationService.aggregate(mock)

    assert(res.length == 5)
  }
}
