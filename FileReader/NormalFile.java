package FileReader;

import java.io.File;
import java.io.FileInputStream;

public class NormalFile implements FileReader{
    private char[] buffer = new char[85];
    private File file;
    public NormalFile(File file) {
        this.file = file;
    }



    public void normalAffiche(){
        try {
            FileInputStream in = new FileInputStream(this.file);
            int i = in.read();
            while (i != -1) {
                System.out.print((char) i);
                i = in.read();
            }
            in.close();
        }
        catch (Exception e){
            e.getStackTrace();
        }
    }

    @Override
    public void reverseAffiche() {
            int index = 0;
            try {
                FileInputStream in = new FileInputStream(this.file);
                StringBuilder contenu = new StringBuilder(); // Utilisez StringBuilder pour stocker le contenu du fichier

                int i = in.read();
                while (i != -1) {
                    contenu.append((char) i); // Ajoutez chaque caractère au contenu
                    i = in.read();
                }
                in.close();

                String[] lignes = contenu.toString().split("\n"); // Divise le contenu en lignes


                // Inverse l'ordre des lignes
                StringBuilder contenuInverse = new StringBuilder();
                for (int j = lignes.length - 1; j >= 0; j--) {
                    contenuInverse.append(lignes[j]);
                    if (j > 0) {
                        contenuInverse.append('\n'); // Ajoute un saut de ligne entre les lignes
                    }
                }
                // Affiche le contenu à l'envers en termes de lignes
                System.out.print(contenuInverse);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    @Override
    public void palindromiqueAffiche() {
        int index = 0;
        try {
            FileInputStream in = new FileInputStream(this.file);
            int i = in.read();
            while (i != -1) {
                buffer[index] = (char) i;
                i = in.read();
                index++;
            }
            in.close();
        }
        catch (Exception e){
            e.getStackTrace();
        }

        for(int j = buffer.length-1; j >= 0; j--){
            System.out.print(buffer[j]);
        }
    }

    public void diff(NormalFile file2) {
        int diff = 0;
        try {
            FileInputStream file = new FileInputStream(this.file);
            FileInputStream another_file = new FileInputStream(file2.file);
            int i = file.read();
            int j = another_file.read();
            while (i != -1 && j != -1) {
                System.out.print((char) i);
                while (i != -1 && j != -1) {
                    if ((char) i != (char) j) {
                        diff++;
                    }
                    i = file.read();
                    j = another_file.read();
                }
            }
            file.close();
            another_file.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println("Il y'a " + diff + " différences entres les 2 fichiers");
    }
}
