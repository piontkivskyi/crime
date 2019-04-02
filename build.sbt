version := "1.0"
scalaVersion := "2.12.1"

lazy val crime = (project in file("."))
  .settings(
    name := "crime",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test
  )