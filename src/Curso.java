import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Curso {
    private String titulo;
    private float duracion; //Expresada en horas
    private int videos; //cantidad de vídeos
    private int alumnos; //Cantidad de alumnos
    public Curso(String titulo, float duracion, int videos, int alumnos) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.videos = videos;
        this.alumnos = alumnos;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public float getDuracion() {
        return duracion;
    }
    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }
    public int getVideos() {
        return videos;
    }
    public void setVideos(int videos) {
        this.videos = videos;
    }
    public int getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(int alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString(){
        return "Título: " + titulo + ", Duración: " + duracion + ", Vídeos: " + videos + ", alumnos: " + alumnos;
    }

    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
        cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
        cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
        cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
        cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300 ));


    // • Obtener la cantidad de cursos con una duración mayor a 5 horas.
    long cantidadMayor5Horas = cursos.stream().filter(curso -> curso.getDuracion() > 5).count();
    System.out.println("Cantidad de cursos con duración mayor a 5 horas: " + cantidadMayor5Horas);

    // • Obtener la cantidad de cursos con una duración menor a 2 horas.
    long cantidadMenor2Horas = cursos.stream().filter(curso -> curso.getDuracion() < 2).count();
    System.out.println("Cantidad de cursos con duración mayor a 5 horas: " + cantidadMenor2Horas);

    // • Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.
    List<String> titulosCursosVideosMayor50 = cursos.stream().filter(curso -> curso.getVideos() > 50).map(Curso::getTitulo).collect(Collectors.toList());
    System.out.println("Cursos con más de 50 vídeos: " + titulosCursosVideosMayor50);

    // • Mostrar en consola la duración total de todos los cursos.
    float duracionTotalCursos = (float) cursos.stream().mapToDouble(Curso::getDuracion).sum();
    System.out.println("Duración total de todos los cursos: " + duracionTotalCursos);

    // • Mostrar en consola todos aquellos cursos que superen el promedio en cuanto a duración se refiere.


    // • Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.
    List<Float> duracionCursosMenos500Alumnos = cursos.stream().filter(curso -> curso.getAlumnos() < 500).map(Curso::getDuracion).collect(Collectors.toList());
    System.out.println("Duración de cursos con menos de 500 alumnos: " + duracionCursosMenos500Alumnos);

    // • Obtener el curso con mayor duración.
    Curso cursoMayorDuracion = cursos.stream().max(Comparator.comparing(Curso::getDuracion)).orElse(null);
    System.out.println("Curso con mayor duración: " + cursoMayorDuracion);

    }
}