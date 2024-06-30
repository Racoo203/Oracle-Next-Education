import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class Calculator {

    @SerializedName("conversion_rates")
    private HashMap<String, Double> currencyMap;

    public Calculator(HashMap<String, Double> currencyMap) {
        this.currencyMap = currencyMap;
    }

    public HashMap<String, Double> getCurrencyMap() {
        return currencyMap;
    }

    public double convert(double usd, String currency) {
        return usd * currencyMap.get(currency);
    }
}
