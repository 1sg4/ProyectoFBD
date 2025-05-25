
@echo off
REM Ruta corregida al SDK de JavaFX
set PATH_TO_FX="C:\Users\trist\Downloads\x64_bin-sdk\javafx-sdk-21.0.7\lib"

REM Compila la clase Java
javac --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml,javafx.media -d out src\interfaz\VtnCartelera.java

REM Ejecuta la clase
java --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml,javafx.media -cp out interfaz.VtnCartelera

pause
