import java.io.*;

public class Exercici2 {
    public static void main(String[] args) {
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingresa la ruta del fichero:");
            String rutaFichero = in.readLine();
            System.out.println("Ingresa el nombre del fichero:");
            String nombreFichero = in.readLine();
            File archivo = new File(rutaFichero, nombreFichero);

            if(archivo.exists()){
                System.out.println("El fichero sí existe.");
                try {
                    BufferedReader lecturaFichero = new BufferedReader(new FileReader(archivo));
                    String linea;
                    int contarPalabras = 0;
                    while ((linea = lecturaFichero.readLine()) != null) {
                        String[] palabras = linea.split("\\s+");
                        contarPalabras += palabras.length;
                    }
                    System.out.println("El fichero contiene " + contarPalabras + " palabras.");
                    lecturaFichero.close();
                } catch (FileNotFoundException e) {
                    System.out.println("El fichero no se pudo abrir");
                } catch (IOException e) {
                    System.out.println("Error al leer el fichero.");
                }
            } else {
                System.out.println("El fichero no existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer la entrada.");
        }
    }
}
