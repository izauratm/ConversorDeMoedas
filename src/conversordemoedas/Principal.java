package conversordemoedas;

import conversordemoedas.service.CurrencyService;
import conversordemoedas.util.Menu;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("********************************************");
        System.out.print("Informe sua chave da API ExchangeRate: ");
        String apiKey = scanner.nextLine();
        System.out.println("********************************************");

        CurrencyService service = new CurrencyService(apiKey);
        Menu menu = new Menu(service);
        menu.exibir();
    }
}


