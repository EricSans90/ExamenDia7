import java.io.*;
import java.util.Scanner;

/*Realiza un programa en JAVA en el que muestres un menú que te permita 3 opciones:
1. Creación de un fichero binario (con el nombre que tu quieras) en el que indiques en cada
linea: Tu Nombre, tu edad y tu ciudad de nacimiento.
2. Mostrar por pantalla el contenido del fichero binario creado.
3. Salir del Programa.
Por simplicidad, si añades un nuevo nombre, edad y ciudad de nacimiento se perderá el
introducido con anterioridad*/
public class Exercici4 implements Serializable {
    public String nombre;
    public int edad;
    public String ciudadNacimiento;

    Exercici4(String nombre, int edad, String ciudadNacimiento){
        this.nombre = nombre;
        this.edad = edad;
        this.ciudadNacimiento = ciudadNacimiento;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + ", Edad: " + edad + ", Ciudad natal: " + ciudadNacimiento;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner((System.in));
        String fichero = "miFichero.bin";

        while(true){
            System.out.println("1. Crear fichero binario");
            System.out.println("2. Leer fichero binario");
            System.out.println("3. Salir");
            System.out.print("Introduce una opción:");
            int opcion = entrada.nextInt();

            switch (opcion){
                case 1:
                    entrada.nextLine();
                    System.out.println("Introduce nombre: ");
                    String nombre = entrada.nextLine();
                    System.out.println("Introduce edad: ");
                    int edad = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Introduce ciudad natal: ");
                    String ciudadNacimiento = entrada.nextLine();

                    Exercici4 persona = new Exercici4(nombre,edad,ciudadNacimiento);

                    try (ObjectOutputStream salidaOut = new ObjectOutputStream(new FileOutputStream(fichero))) {
                        salidaOut.writeObject(persona);
                        System.out.println("Fichero creado correctamente");
                    } catch (IOException e) {
                        System.out.println("Error al crear el fichero");
                    }
                    break;

                case 2:
                    try (ObjectInputStream entradaIn = new ObjectInputStream(new FileInputStream(fichero))) {
                        Exercici4 personaLeida = (Exercici4) entradaIn.readObject();
                        System.out.println("Datos en fichero:");
                        System.out.println(personaLeida);
                    }catch (IOException | ClassNotFoundException e) {
                        System.out.println("Error al leer el fichero");
                    }
                    break;

                case 3:
                    System.out.println("Salimos del programa");
                    entrada.close();
                    return;

                default:
                    System.out.println("Has introducido una opción no válida");

            }
        }
    }
}

