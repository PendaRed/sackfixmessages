REM stupid SBT runs out of mem on my dev lappie
REM sbt sackfixmessagesfixt11/compile
REM sbt sackfixmessagesfixt11/publish-local
REM
REM sbt is a .bat, so stick call infront of it
set JAVA_OPTS=-Xmx1024M -Xss2M

call sbt "project sackfixmessages40" clean compile test
call sbt "project sackfixmessages40" publish-local

call sbt "project sackfixmessages41" clean compile test
call sbt "project sackfixmessages41" publish-local

call sbt "project sackfixmessages42" clean compile test
call sbt "project sackfixmessages42" publish-local

call sbt "project sackfixmessages43" clean compile test
call sbt "project sackfixmessages43" publish-local

call sbt "project sackfixmessages44" clean compile test
call sbt "project sackfixmessages44" publish-local

call sbt "project sackfixmessages44modified" clean compile test
call sbt "project sackfixmessages44modified" publish-local

call sbt "project sackfixmessagesfixt11" clean compile test
call sbt "project sackfixmessagesfixt11" publish-local

call sbt "project sackfixmessages50" clean compile test
call sbt "project sackfixmessages50" publish-local

call sbt "project sackfixmessages50sp1" clean compile test
call sbt "project sackfixmessages50sp1" publish-local

call sbt "project sackfixmessages50sp1modified" clean compile test
call sbt "project sackfixmessages50sp1modified" publish-local

call sbt "project sackfixmessages50sp2" clean compile test
call sbt "project sackfixmessages50sp2" publish-local

call sbt "project sackfixmessages50sp2modified" clean compile test
call sbt "project sackfixmessages50sp2modified" publish-local
