
@echo off
REM Ruta al SDK de JavaFX
set PATH_TO_FX="C:\Users\trist\Downloads\openjfx-21.0.7_windows-x64_bin-sdk\lib"

REM Compila la clase Java (ajusta si está en otra carpeta)
javac --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml,javafx.media -d out src\interfaz\VtnCartelera.java

REM Ejecuta la clase
java --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml,javafx.media -cp out interfaz.VtnCartelera

pause
