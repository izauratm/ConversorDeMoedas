package conversordemoedas.util;

import conversordemoedas.service.CurrencyService;
import java.time.LocalDateTime;
import java.util.*;

public class Menu {
    private final CurrencyService service;
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> historico = new ArrayList<>();

    public Menu(CurrencyService service) {
        this.service = service;
    }

    public void exibir() {
        int opcao = -1;

        while (opcao != 10) {
            System.out.println("\n********************************************");
            System.out.println("🪙 Seja bem-vindo(a) ao Conversor de Moedas 🪙");
            System.out.println("1) Real brasileiro => Dólar");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Real brasileiro => Euro");
            System.out.println("4) Peso mexicano => Dólar");
            System.out.println("5) Dólar => Euro");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Ver histórico de conversões");
            System.out.println("8) Converter entre moedas personalizadas");
            System.out.println("9) Limpar histórico");
            System.out.println("10) Sair");
            System.out.print("Escolha uma opção válida: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1 -> converter("BRL", "USD");
                case 2 -> converter("ARS", "USD");
                case 3 -> converter("BRL", "EUR");
                case 4 -> converter("MXN", "USD");
                case 5 -> converter("USD", "EUR");
                case 6 -> converter("COP", "USD");
                case 7 -> exibirHistorico();
                case 8 -> conversaoPersonalizada();
                case 9 -> limparHistorico();
                case 10 -> System.out.println("✅ Programa Encerrado com Sucesso!");
                default -> System.out.println("❌ Opção inválida. Tente novamente.");
            }
        }
    }

    private void converter(String moedaOrigem, String moedaDestino) {
        Map<String, Double> taxas = service.obterTaxas(moedaOrigem);
        if (taxas != null && taxas.containsKey(moedaDestino)) {
            double valor = taxas.get(moedaDestino);
            System.out.printf("1 %s equivale a %.4f %s\n", moedaOrigem, valor, moedaDestino);

            LocalDateTime agora = LocalDateTime.now();
            String registro = String.format("[%s] 1 %s => %.4f %s", agora, moedaOrigem, valor, moedaDestino);
            historico.add(registro);

            System.out.print("Deseja salvar essas taxas em um arquivo JSON completo? (s/n): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                JsonExporter.salvarJsonCompleto("completo_" + moedaOrigem + ".json", moedaOrigem, taxas);
            }
        } else {
            System.out.println("❌ Não foi possível obter a taxa de câmbio.");
        }
    }

    private void conversaoPersonalizada() {
        System.out.print("Digite a moeda de origem (ex: BRL): ");
        String origem = scanner.nextLine().toUpperCase();
        System.out.print("Digite a moeda de destino (ex: EUR): ");
        String destino = scanner.nextLine().toUpperCase();
        converter(origem, destino);
    }

    private void exibirHistorico() {
        System.out.println("\n📜 Histórico de Conversões:");
        if (historico.isEmpty()) {
            System.out.println("Nenhuma conversão realizada ainda.");
        } else {
            historico.forEach(System.out::println);
        }
    }

    private void limparHistorico() {
        historico.clear();
        System.out.println("✅ Histórico de conversões limpo com sucesso.");
    }
}
