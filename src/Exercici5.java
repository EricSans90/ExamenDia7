import java.util.*;

public class Exercici5 {
    public static void main(String[] args) {
        // • Crea una lista que contenga los días de la semana(listaUno)
        List<String> listaUno = new ArrayList<>(Arrays.asList("Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"));

        // • Inserta en la posición 4 el elemento «Juernes».
        listaUno.add(4, "Juernes");

        // • Copia esa lista a otra llamada listaDos.
        List<String> listaDos = new ArrayList<>(listaUno);

        // • Añade a listaUno el contenido de listaDos.
        listaUno.addAll(listaDos);

        // • Muestra el contenido de las posiciones 3 y 4 de la lista original.
        System.out.println("Posición 3: " + listaUno.get(3));
        System.out.println("Posición 4: " + listaUno.get(4));

        // • Muestra el primer elemento y el último de la lista original.
        System.out.println("Primer elemento: " + listaUno.get(0));
        System.out.println("Último elemento: " + listaUno.get(listaUno.size()-1));

        // • Elimina el elemento que contenga «Juernes» de la lista y comprueba si elimina algo o no.
        boolean eliminado = listaUno.remove("Juernes");
        if (eliminado){
            System.out.println("Juernes eliminado con éxito");
        } else {
            System.out.println("No se ha podido eliminar Juernes");
        }

        // • Crea un iterador y muestra uno a uno los valores de la lista original.
        Iterator<String> iterador = listaUno.iterator();
        while (iterador.hasNext()){
            System.out.println(iterador.next());
        }

        // • Busca si existe en la lista un elemento que se denomine «Lunes».
        if (listaUno.contains("Lunes")){
            System.out.println("La lista contiene Lunes");
        } else {
            System.out.println("La lista no contiene Lunes");
        }

        // • Busca si existe en la lista un elemento que se denomine «Lunes». No importa si está en
        //mayúscula o minúscula.
        boolean contieneLunes = false;
        for(String dia : listaUno){
            if(dia.equalsIgnoreCase("Lunes")){
                contieneLunes = true;
                System.out.println("La lista contiene Lunes o lunes.");
                break;
            }
        }

        // • Ordena la lista y muestra su contenido.
        Collections.sort(listaUno);
        System.out.println("Lista ordenada: " + listaUno);

        // • Borra todos los elementos de la lista
        listaUno.clear();
    }
}

