import java.awt.desktop.ScreenSleepEvent;
import java.util.Scanner;

public class Lectura {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el nombre de tu pelicula favorita.");
        String pelicula = teclado.nextLine();
        System.out.println("Escribe el año de lanzamiento.");
        int fecha = teclado.nextInt();
        System.out.println("Dinos que nota le darías a esta pelicula.");
        double nota = teclado.nextDouble();

        System.out.println(pelicula);
        System.out.println(fecha);
        System.out.println(nota);
    }

}
