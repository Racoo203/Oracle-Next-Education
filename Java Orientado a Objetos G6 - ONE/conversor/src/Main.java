import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isEnd = false;
        boolean isSkip = false;
        int currentTransaction = 0;
        List<String> convertionHistory = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (!isEnd) {
            String fromCurrency = "";
            String toCurrency = "";
            String seleccion = "";
            double amount = -1;

//            System.out.println(fromCurrency + toCurrency + seleccion + String.valueOf(amount));

            System.out.println("-----------------------------------");
            System.out.println("Conversor de Monedas");
            System.out.println("Selecciona una opcion:");
            System.out.println("-----------------------------------");
            System.out.println("(1) USD -> ARS");
            System.out.println("(2) ARS -> USD");
            System.out.println("-----------------------------------");
            System.out.println("(3) USD -> BOB");
            System.out.println("(4) BOB -> USD");
            System.out.println("-----------------------------------");
            System.out.println("(5) USD -> BRL");
            System.out.println("(6) BRL -> USD");
            System.out.println("-----------------------------------");
            System.out.println("(7) USD -> CLP");
            System.out.println("(8) CLP -> USD");
            System.out.println("-----------------------------------");
            System.out.println("(9) USD -> COP");
            System.out.println("(10) COP -> USD");
            System.out.println("-----------------------------------");
            System.out.println("(H) Historial");
            System.out.println("(*) SALIR");
            System.out.println("-----------------------------------");

            //////////////////////////////////////////////

            seleccion = scanner.nextLine();

            switch (seleccion) {
                case ("1"):
                    fromCurrency = "USD";
                    toCurrency = "ARS";
                    break;
                case ("2"):
                    fromCurrency = "ARS";
                    toCurrency = "USD";
                    break;
                case ("3"):
                    fromCurrency = "USD";
                    toCurrency = "BOB";
                    break;
                case ("4"):
                    fromCurrency = "BOB";
                    toCurrency = "USD";
                    break;
                case ("5"):
                    fromCurrency = "USD";
                    toCurrency = "BRL";
                    break;
                case ("6"):
                    fromCurrency = "BRL";
                    toCurrency = "USD";
                    break;
                case ("7"):
                    fromCurrency = "USD";
                    toCurrency = "CLP";
                    break;
                case ("8"):
                    fromCurrency = "CLP";
                    toCurrency = "USD";
                    break;
                case ("9"):
                    fromCurrency = "USD";
                    toCurrency = "COP";
                    break;
                case ("10"):
                    fromCurrency = "COP";
                    toCurrency = "USD";
                    break;
                case ("H"):
                    int counter = 0;
                    for (String element : convertionHistory) {
                        counter++;
                        System.out.println(counter + ") " + element);
                    }
                    isSkip = true;
                    break;
                case ("*"):
                    System.out.println("FINALIZADO");
                    isEnd = true;
                    break;
                default:
                    System.out.println("Input no reconocido");
                    isSkip = true;
                    break;
            }

            if (!(isSkip | isEnd)) {
                currentTransaction ++;

                System.out.println("Ingresa el monto de la moneda desde la cual se quiere convertir.");
                amount = Integer.parseInt(scanner.nextLine());
                CurrencyQuery currencyQuery = new CurrencyQuery();
                Calculator calculator = currencyQuery.queryAPI(fromCurrency);
                double mto = calculator.convert(amount, toCurrency);
                String output = String.format("%s : %f === %s : %f", fromCurrency, amount, toCurrency, mto);
                System.out.println(currentTransaction + ") " + output);
                convertionHistory.add(output);
            }

            isSkip = false;

        }

        scanner.close();
    }
}