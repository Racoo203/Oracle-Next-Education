import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isLooping = true;

        CurrencyQuery currencyQuery = new CurrencyQuery();
        currencyQuery.queryAPI();

//        while (isLooping) {
//            System.out.println("-----------------------------------");
//            System.out.println("Conversor de Monedas");
//            System.out.println("Selecciona una opcion:");
//            System.out.println("-----------------------------------");
//            System.out.println("(1) USD -> ARS");
//            System.out.println("(2) ARS -> USD");
//            System.out.println("-----------------------------------");
//            System.out.println("(3) USD -> BOB");
//            System.out.println("(4) BOB -> USD");
//            System.out.println("-----------------------------------");
//            System.out.println("(5) USD -> BRL");
//            System.out.println("(6) BRL -> USD");
//            System.out.println("-----------------------------------");
//            System.out.println("(7) USD -> CLP");
//            System.out.println("(8) CLP -> USD");
//            System.out.println("-----------------------------------");
//            System.out.println("(9) USD -> COP");
//            System.out.println("(10) COP -> USD");
//            System.out.println("-----------------------------------");
//            System.out.println("(*) SALIR");
//            System.out.println("-----------------------------------");
//
//
//            //////////////////////////////////////////////
//
//            Scanner scanner = new Scanner(System.in);
//            String seleccion = scanner.nextLine();
//
//            switch (seleccion) {
//                case("1"):
//                case("2"):
//                case("3"):
//                case("4"):
//                case("5"):
//                case("6"):
//                case("7"):
//                case("8"):
//                case("9"):
//                case("10"):
//                case("*"):
//                    System.out.println("FINALIZADO");
//                    isLooping = false;
//                    break;
//                default:
//                    System.out.println("Input no reconocido");
//            }
//        }
    }
}