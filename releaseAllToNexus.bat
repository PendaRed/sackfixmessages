REM stupid SBT runs out of mem on my dev lappie
REM sbt sackfixmessagesfixt11/compile
REM sbt sackfixmessagesfixt11/publish-local
REM
REM sbt is a .bat, so stick call infront of it
set JAVA_OPTS=-Xmx1024M -Xss2M

call sbt "project sackfixmessages40" publishSigned

call sbt "project sackfixmessages41" publishSigned

call sbt "project sackfixmessages42" publishSigned

call sbt "project sackfixmessages43" publishSigned

call sbt "project sackfixmessages44" publishSigned

call sbt "project sackfixmessages44modified" publishSigned

call sbt "project sackfixmessagesfixt11" publishSigned

call sbt "project sackfixmessages50" publishSigned

call sbt "project sackfixmessages50sp1" publishSigned

call sbt "project sackfixmessages50sp1modified" publishSigned

call sbt "project sackfixmessages50sp2" publishSigned

call sbt "project sackfixmessages50sp2modified" publishSigned
