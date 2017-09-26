/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringbufferhtml;

import java.util.Scanner;

/**
 *
 * @author emont
 */
public class StringBufferHtml {
public static void main(String[] args) {
        /// Carpeta TEMP
        String tempFolder = System.getenv("TEMP");
        /// Nombre de fichero
        String fileName = "\\hola.html";
        
        /// Preguntar por valores
        String title = askString("Titulo de la pagina: ");
        String name = askString("Introduce nombre: ");
        
        /// Crear archivo
        FileCreator.createFile(tempFolder + fileName, createHtml(title,name));
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
     
    }