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
	libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.3.12"
)

lazy val sackfixmessages40 = (project in file("./sackfix-messages-fix40")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix40"
	)
lazy val sackfixmessages41 = (project in file("./sackfix-messages-fix41")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix41"
	)
lazy val sackfixmessages42 = (project in file("./sackfix-messages-fix42")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix42"
	)
lazy val sackfixmessages43 = (project in file("./sackfix-messages-fix43")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix43"
	)
lazy val sackfixmessages44 = (project in file("./sackfix-messages-fix44")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix44"
	)
lazy val sackfixmessages44modified = (project in file("./sackfix-messages-fix44modified")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix44modified"
	)
lazy val sackfixmessages50 = (project in file("./sackfix-messages-fix50")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix50"
	)
lazy val sackfixmessagesfixt11 = (project in file("./sackfix-messages-fixt11")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fixt11"
	)
lazy val sackfixmessages50sp1 = (project in file("./sackfix-messages-fix50sp1")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix50sp1"
	)
lazy val sackfixmessages50sp1modified = (project in file("./sackfix-messages-fix50sp1modified")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix50sp1modified"
	)
lazy val sackfixmessages50sp2 = (project in file("./sackfix-messages-fix50sp2")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix50sp2"
	)
lazy val sackfixmessages50sp2modified = (project in file("./sackfix-messages-fix50sp2modified")).
	settings(commonSettings: _*).
	settings(
		name := "sackfix-messages-fix50sp2modified"
	)

lazy val sackfixmessages = (project in file(".")).aggregate(sackfixmessages40, sackfixmessages41, sackfixmessages42,
    sackfixmessages43, sackfixmessages44,sackfixmessages44modified, sackfixmessagesfixt11, sackfixmessages50, sackfixmessages50sp1,
	sackfixmessages50sp1modified, sackfixmessages50sp2, sackfixmessages50sp2modified)
