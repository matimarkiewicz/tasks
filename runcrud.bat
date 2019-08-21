gradlew build
if "%ERRORLEVEL%" == "0" goto rename
echo.
echo gradlew build has errors - breaking work
goto fail

:rename
del build\libs\crud.war
ren build\libs\tasks-0.0.1-SNAPSHOT.war crud.war
if "%ERRORLEVEL%" == "0" goto stoptomcat
echo Cannot rename file
goto fail

:stoptomcat
echo.
call %CATALINA_HOME%\BIN\shutdown.bat

:copyfile
copy build\libs\crud.war %CATALINA_HOME%\webapps
if "%ERRORLEVEL%" == "0" goto runtomcat
echo Cannot copy file
goto fail

:runtomcat
call %CATALINA_HOME%\BIN\startup.bat
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.