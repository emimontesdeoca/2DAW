package stringbufferhtml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    public static void createFile(String path, String text) {
        /// Metodo de creacion de archivo por el documento
        File file = new File(path);
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(text);
            fw.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
