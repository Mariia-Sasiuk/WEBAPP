call build.bat
copy ear_mod\target\lab3_WebApp.ear C:\Oracle\Middleware\Oracle_Home\user_projects\domains\base_domain\autodeploy
cd C:\Oracle\Middleware\Oracle_Home\user_projects\domains\base_domain\bin
call startWebLogic.cmd
pause