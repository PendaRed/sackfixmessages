import sbt.Keys._

// Multi project build file.  For val xxx = project, xxx is the name of the project and base dir
lazy val commonSettings = Seq(
	organization := "org.sackfix",
	version := "0.1.0",
	scalaVersion := "2.11.7",
	libraryDependencies += "org.sackfix" %% "sackfix-common" % "0.1.0",
	libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test",
    libraryDependencies += "org.mockito" % "mockito-all" % "1.10.19"  % "test",
	libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3",
	libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3" % "runtime", // without %runtime did not work in intellij
	libraryDependencies += "com.typesafe" % "config" % "1.3.0",
	libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.2",
	libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.3.12",
	// Configuring publish to Sonartype, http://www.scala-sbt.org/release/docs/Using-Sonatype.html
	useGpg := true,
	pomIncludeRepository := { _ => false },
	licenses := Seq("MIT License" -> url("http://www.opensource.org/licenses/mit-license.php")),
	homepage := Some(url("http://www.sackfix.org/")),
	developers := List(
		Developer(id = "PendaRed",
			name  = "Jonathan Gibbons",
			email = "Jonathan@sackfix.org",
			url = url("http://www.sackfix.org"))
	),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/PendaRed/sackfixmessages.git"),
      "scm:git@github.com:PendaRed/sackfixmessages.git"
    )
  ),
	publishMavenStyle := true,
	publishTo := {
		val nexus = "https://oss.sonatype.org/"
		if (isSnapshot.value)
			Some("snapshots" at nexus + "content/repositories/snapshots")
		else
			Some("releases"  at nexus + "service/local/staging/deploy/maven2")
	},
	publishArtifact in Test := false
)

lazy val sackfixmessages40 = (project in file("./sackfix-messages-fix40")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix40",
    // Configuring publish to Sonartype, http://www.scala-sbt.org/release/docs/Using-Sonatype.html
    description :="All Fix 4.0 strongly typed messages, purely generated code, do not edit."
	)
lazy val sackfixmessages41 = (project in file("./sackfix-messages-fix41")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix41",
    // Configuring publish to Sonartype, http://www.scala-sbt.org/release/docs/Using-Sonatype.html
    description :="All Fix 4.1 strongly typed messages, purely generated code, do not edit."

  )
lazy val sackfixmessages42 = (project in file("./sackfix-messages-fix42")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix42",
    // Configuring publish to Sonartype, http://www.scala-sbt.org/release/docs/Using-Sonatype.html
    description :="All Fix 4.2 strongly typed messages, purely generated code, do not edit."
  )
lazy val sackfixmessages43 = (project in file("./sackfix-messages-fix43")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix43",
    // Configuring publish to Sonartype, http://www.scala-sbt.org/release/docs/Using-Sonatype.html
    description :="All Fix 4.3 strongly typed messages, purely generated code, do not edit."
  )
lazy val sackfixmessages44 = (project in file("./sackfix-messages-fix44")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix44",
    // Configuring publish to Sonartype, http://www.scala-sbt.org/release/docs/Using-Sonatype.html
    description :="All Fix 4.4 strongly typed messages, purely generated code, do not edit."
  )
lazy val sackfixmessages44modified = (project in file("./sackfix-messages-fix44modified")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix44modified",
    // Configuring publish to Sonartype, http://www.scala-sbt.org/release/docs/Using-Sonatype.html
    description :="All Fix 4.4modified strongly typed messages, purely generated code, do not edit."
  )
lazy val sackfixmessages50 = (project in file("./sackfix-messages-fix50")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix50",
    // Configuring publish to Sonartype, http://www.scala-sbt.org/release/docs/Using-Sonatype.html
    description :="All Fix 5.0 strongly typed messages, purely generated code, do not edit."
  )
lazy val sackfixmessagesfixt11 = (project in file("./sackfix-messages-fixt11")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fixt11",
    // Configuring publish to Sonartype, http://www.scala-sbt.org/release/docs/Using-Sonatype.html
    description :="All Fixt1.1 strongly typed session messages, purely generated code, do not edit."
  )
lazy val sackfixmessages50sp1 = (project in file("./sackfix-messages-fix50sp1")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix50sp1",
    // Configuring publish to Sonartype, http://www.scala-sbt.org/release/docs/Using-Sonatype.html
    description :="All Fix 5.0sp1 strongly typed messages, purely generated code, do not edit."
  )
lazy val sackfixmessages50sp1modified = (project in file("./sackfix-messages-fix50sp1modified")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix50sp1modified",
    // Configuring publish to Sonartype, http://www.scala-sbt.org/release/docs/Using-Sonatype.html
    description :="All Fix 5.0sp1modified strongly typed messages, purely generated code, do not edit."
  )
lazy val sackfixmessages50sp2 = (project in file("./sackfix-messages-fix50sp2")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix50sp2",
    // Configuring publish to Sonartype, http://www.scala-sbt.org/release/docs/Using-Sonatype.html
    description :="All Fix 5.0sp2 strongly typed messages, purely generated code, do not edit."
  )
lazy val sackfixmessages50sp2modified = (project in file("./sackfix-messages-fix50sp2modified")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix50sp2modified",
    // Configuring publish to Sonartype, http://www.scala-sbt.org/release/docs/Using-Sonatype.html
    description :="All Fix 5.0sp2modified strongly typed messages, purely generated code, do not edit."
  )

lazy val sackfixmessages = (project in file(".")).aggregate(sackfixmessages40, sackfixmessages41, sackfixmessages42,
    sackfixmessages43, sackfixmessages44,sackfixmessages44modified, sackfixmessagesfixt11, sackfixmessages50, sackfixmessages50sp1,
	sackfixmessages50sp1modified, sackfixmessages50sp2, sackfixmessages50sp2modified)
