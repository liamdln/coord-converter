echo "Compiling..."
find -name "*.java" > sources.txt
javac @sources.txt
cd ./src
java com.liamdp.main.Main