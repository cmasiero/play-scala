name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.sorm-framework" % "sorm" % "0.3.20",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)



fork in run := true