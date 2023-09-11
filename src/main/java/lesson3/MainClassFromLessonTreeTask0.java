package lesson3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class MainClassFromLessonTreeTask0 {
    public static void main(String[] args) {

    }

    private static void rwLine(Path pathRead, Path pathWrite) {
        try (
                BufferedReader in = Files.newBufferedReader(pathRead);
                BufferedWriter out = Files.newBufferedWriter(pathWrite)
        ){
            out.write(in.readLine());

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
