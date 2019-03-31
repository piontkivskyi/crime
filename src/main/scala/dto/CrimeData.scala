package dto

// Crime ID,
// Month,
// Reported by,
// Falls within,
// Longitude, Latitude,
// Location,
// LSOA code,
// LSOA name,
// Crime type,
// Last outcome category,
// Context
case class CrimeData(
                      crimeId: String,
                      month: String,
                      reportedBy: String,
                      fallsWithin: String,
                      location: (Double, Double),
                      locationName: String,
                      LSOACode: String,
                      LSONName: String,
                      crimeType: String
                    )
