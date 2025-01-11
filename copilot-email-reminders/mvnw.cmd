@echo off
setlocal

set MAVEN_HOME=%~dp0\.mvn\wrapper
set MAVEN_OPTS=-Xmx1024m -XX:MaxPermSize=256m

if exist "%MAVEN_HOME%\mvnw.cmd" (
    call "%MAVEN_HOME%\mvnw.cmd" %*
) else (
    echo "Maven wrapper not found. Please ensure you have the correct files."
)

endlocal