package services

import java.io.File

import org.scalatest.FlatSpec

class CrimeAggregatorServiceTest extends FlatSpec {
  "CrimeAggregatorService " should "Return list of pairs grouped by coordinates" in {
    val res = CrimesAggregationService.aggregate(CsvParser.parse(new File(getClass.getResource("/mocks/mock.csv").toURI)))

    assert(res.nonEmpty)

    // if length == 1 - items with nullable crimeId is filtered
    assert(res.length == 1)
    assert(res(0)._2.length == 1)
  }
}
