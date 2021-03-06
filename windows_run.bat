echo "Compiling..."
dir /s /B *.java > sources.txt
javac @sources.txt
cd ./src
java com.liamdp.main.Main
cd ..
pause