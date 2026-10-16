@echo off
rem Build the LinkBox0 Windows binary and the Inno Setup installer.
rem Requires Go and Inno Setup 6 (ISCC.exe) on PATH or in the default
rem per-user install location.

setlocal
set GOEXE=go
set ISCC="%LOCALAPPDATA%\Programs\Inno Setup 6\ISCC.exe"

echo Building linkbox0.exe ...
%GOEXE% run build.go -version v0.1.0 build || exit /b 1

echo Building installer ...
%ISCC% "%~dp0linkbox0.iss" || exit /b 1

echo.
echo Done. Installer is in .\dist
endlocal
