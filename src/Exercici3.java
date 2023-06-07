public class Exercici3 implements Estadisticas{
    private double[] numeros;

    public Exercici3(double[] numeros){
        this.numeros = numeros;
    }

    @Override
    public double minimo() {
        double min = numeros[0];
        for (double num : numeros) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    @Override
    public double maximo() {
        double max = numeros[0];
        for (double num : numeros) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    @Override
    public double sumatorio() {
        double sumaTotal = 0;
        for (double num : numeros) {
            sumaTotal += num;
            }
        return sumaTotal;
    }

    public static void main(String[] args) {
        double[] arrayNumeros = {1.2, 2.3, 3.4, 4.5, 5.6};
        Exercici3 test = new Exercici3(arrayNumeros);
        System.out.println("Mínimo es: " + test.minimo());
        System.out.println("Máximo es: " + test.maximo());
        System.out.println("Sumatorio es: " + test.sumatorio());
    }
}
