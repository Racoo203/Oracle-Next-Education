public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido(a) a Screen Match");
        System.out.println("Película: Matrix");

        int fechaDeLanzamiento = 1999;
        boolean incluidoEnPlan = true;
        double notaDeLaPelicula = 8.2;

        double media = (8.2 + 6.0 + 9.0) / 3;
        System.out.println(media);

        String sinopsis = """
                Matrix es una paradoja. 
                La mejor pelicula del fin del milenio
                Fue lanzada en:
                """ + fechaDeLanzamiento;

        System.out.println(sinopsis);

        int classificacion = (int) media / 2;
        System.out.println(classificacion);
    }
}