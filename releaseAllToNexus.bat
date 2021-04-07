REM stupid SBT runs out of mem on my dev lappie
REM sbt sackfixmessagesfixt11/compile
REM sbt sackfixmessagesfixt11/publish-local
REM
REM sbt is a .bat, so stick call infront of it
set JAVA_OPTS=-Xmx1024M -Xss2M

call sbt "project sackfixmessages40" sonatypeRelease

call sbt "project sackfixmessages41" sonatypeRelease

call sbt "project sackfixmessages42" sonatypeRelease

call sbt "project sackfixmessages43" sonatypeRelease

call sbt "project sackfixmessages44" sonatypeRelease

call sbt "project sackfixmessages44modified" sonatypeRelease

call sbt "project sackfixmessagesfixt11" sonatypeRelease

call sbt "project sackfixmessages50" sonatypeRelease

call sbt "project sackfixmessages50sp1" sonatypeRelease

call sbt "project sackfixmessages50sp1modified" sonatypeRelease

call sbt "project sackfixmessages50sp2" sonatypeRelease

call sbt "project sackfixmessages50sp2modified" sonatypeRelease
