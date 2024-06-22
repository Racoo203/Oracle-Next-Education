import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double nota = 0;
        double media = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Escribe la nota que la daría a la pelicula Matrix");
            nota = scanner.nextDouble();
            media += nota;
        }

        System.out.println(media/10);
    }
}
