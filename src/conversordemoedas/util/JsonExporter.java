package conversordemoedas.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import conversordemoedas.model.ExchangeRatesFullResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class JsonExporter {

    public static void salvarJsonCompleto(String nomeArquivo, String moedaBase, Map<String, Double> taxas) {
        ExchangeRatesFullResponse json = new ExchangeRatesFullResponse();
        json.setBase_code(moedaBase);
        json.setTime_last_update_utc(LocalDateTime.now().toString());
        json.setTime_next_update_utc(LocalDateTime.now().plusDays(1).toString());
        json.setConversion_rates(taxas);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            gson.toJson(json, writer);
            System.out.println("✅ JSON completo salvo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar JSON: " + e.getMessage());
        }
    }
}
