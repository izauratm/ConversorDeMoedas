package conversordemoedas.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import conversordemoedas.model.ExchangeRatesResponse;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class CurrencyService {
    private final String apiKey;
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public CurrencyService(String apiKey) {
        this.apiKey = apiKey;
    }
    public Map<String, Double> obterTaxas(String moedaBase) {
        try {
            String url = BASE_URL + apiKey + "/latest/" + moedaBase;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject objetoRaiz = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject taxasJson = objetoRaiz.getAsJsonObject("conversion_rates");

            // Converte JSON para Map usando Gson
            Gson gson = new Gson();
            return gson.fromJson(taxasJson, Map.class);

        } catch (Exception e) {
            System.out.println("Erro ao obter taxas: " + e.getMessage());
            return null;
        }
    }
}