import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaPelicula consulta = new ConsultaPelicula();

        System.out.println("Escribir el numero de pelicula a consultar");
        try {
            int numero = Integer.parseInt(scanner.nextLine());
            Pelicula pelicula = consulta.buscaPelicula(numero);
//            System.out.println(pelicula);
            GeneradorDeArchivo generadorDeArchivo = new GeneradorDeArchivo();
            generadorDeArchivo.guardarJson(pelicula);
        } catch (NumberFormatException e) {
            System.out.println("Numero no encontrado " + e.getMessage());
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando la Aplicacion");
        }

    }
}