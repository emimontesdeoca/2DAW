package inputmain;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InputMain {

    public static void main(String[] args) {
        /// Carpeta TEMP
        String tempFolder = System.getenv("TEMP");
        /// Nombre de fichero
        String fileName = "\\hola.html";
        
        /// Preguntar por valores
        String title = askString("Titulo de la pagina: ");
        String name = askString("Introduce nombre: ");
        
        /// Crear archivo
        createFile(tempFolder + fileName, createHtml(title,name));
    }

    public static String askString(String text){
        /// Muestra texto
        System.out.printf(text);
        /// Devuelve respuesta
        return new Scanner(System.in).next();
    }
    
    public static String createHtml(String title, String name) {
        /// Objecto StringBuffer
        StringBuffer sb = new StringBuffer();
        /// Creando el Html
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>" + title + "</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h1>" + "Hola: " + name + "</h1>");
        sb.append("</body>");
        sb.append("</html>");
        /// Retornar el string
        return sb.toString();
    }

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
