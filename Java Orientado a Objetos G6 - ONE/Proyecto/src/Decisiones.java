public class Decisiones {

    public static void main(String[] args) {
        int fechaDeLanzamiento = 1999;
        boolean incluidoEnPlan = true;
        double notaDeLaPelicula = 8.2;

        String plan = "True";

        if (fechaDeLanzamiento >= 2022) {
            System.out.println("Peliculas más populares");
        } else {
            System.out.println("Pelicula retro que aun vale la pena ver.");
        }

        if (incluidoEnPlan && plan.equals("plus")) {
            System.out.println("Disfrute su pelicula");
        } else {
            System.out.println("Pelicula no disponible para su plan actual");
        }
    }
}
