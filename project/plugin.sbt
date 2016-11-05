addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.0")
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "1.1")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.0.0")
addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-M14-7")
//addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.3.5")
//addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.1.0")
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.8.0")
addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-M14")
scalacOptions ++= Seq("-deprecation", "-feature")
