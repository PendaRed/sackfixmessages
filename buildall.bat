REM stupid SBT runs out of mem on my dev lappie
REM sbt sackfixmessagesfixt11/compile
REM sbt sackfixmessagesfixt11/publishLocal
REM
REM sbt is a .bat, so stick call infront of it
set JAVA_OPTS=-Xmx1024M -Xss2M

call sbt "project sackfixmessages40" clean compile test
call sbt "project sackfixmessages40" publishLocal

call sbt "project sackfixmessages41" clean compile test
call sbt "project sackfixmessages41" publishLocal

call sbt "project sackfixmessages42" clean compile test
call sbt "project sackfixmessages42" publishLocal

call sbt "project sackfixmessages43" clean compile test
call sbt "project sackfixmessages43" publishLocal

call sbt "project sackfixmessages44" clean compile test
call sbt "project sackfixmessages44" publishLocal

call sbt "project sackfixmessages44modified" clean compile test
call sbt "project sackfixmessages44modified" publishLocal

call sbt "project sackfixmessagesfixt11" clean compile test
call sbt "project sackfixmessagesfixt11" publishLocal

call sbt "project sackfixmessages50" clean compile test
call sbt "project sackfixmessages50" publishLocal

call sbt "project sackfixmessages50sp1" clean compile test
call sbt "project sackfixmessages50sp1" publishLocal

call sbt "project sackfixmessages50sp1modified" clean compile test
call sbt "project sackfixmessages50sp1modified" publishLocal

call sbt "project sackfixmessages50sp2" clean compile test
call sbt "project sackfixmessages50sp2" publishLocal

call sbt "project sackfixmessages50sp2modified" clean compile test
call sbt "project sackfixmessages50sp2modified" publishLocal
