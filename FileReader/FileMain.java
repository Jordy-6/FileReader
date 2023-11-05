package FileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileMain {
    public static void main(String[] args) throws IOException {
        File f = new File("C:/Users/jper2/OneDrive/Documents/Licence pro/Java/Java test/src/FileReader/file.txt");
        NormalFile file = new NormalFile(f);
        File json = new File("C:/Users/jper2/OneDrive/Documents/Licence pro/Java/Java test/src/FileReader/Untitled-1.json");
        JsonFile file2 = new JsonFile(json);
        file.normalAffiche();
        System.out.println("\n");
        file.reverseAffiche();
        System.out.println("\n");
        file.palindromiqueAffiche();
        System.out.println("\n");
        file2.normalAffiche();
        System.out.println("\n");
        file2.reverseAffiche();
        System.out.println("\n");
        file2.palindromiqueAffiche();
        System.out.println("\n");
        file2.diff(file);
    }
}

