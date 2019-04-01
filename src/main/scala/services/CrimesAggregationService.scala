package services

import dto.CrimeData

/**
  * Used to aggregate given list
  */
object CrimesAggregationService {
  /**
    * Get list of CrimeData instances and remove items where crimeId is not presented, group by location and take first 5 values
    * @param crimes
    * @return
    */
  def aggregate(crimes: List[CrimeData]): List[((Double, Double), List[CrimeData])] = {
    crimes.filter(_.crimeId.nonEmpty)
      .groupBy(_.location)
      .toList.sortBy(_._2.length)(Ordering[Int].reverse)
      .take(5)
  }
}
