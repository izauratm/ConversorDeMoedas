package conversordemoedas.model;

import java.util.Map;

public class ExchangeRatesFullResponse {
    private String result = "success";
    private String documentation = "https://www.exchangerate-api.com/docs";
    private String terms_of_use = "https://www.exchangerate-api.com/terms";
    private String time_last_update_utc;
    private String time_next_update_utc;
    private String base_code;
    private Map<String, Double> conversion_rates;


    public void setTime_last_update_utc(String time) {
        this.time_last_update_utc = time;
    }

    public void setTime_next_update_utc(String time) {
        this.time_next_update_utc = time;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public void setConversion_rates(Map<String, Double> rates) {
        this.conversion_rates = rates;
    }
}
