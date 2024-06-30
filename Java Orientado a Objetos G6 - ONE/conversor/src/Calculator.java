import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class Calculator {

    @SerializedName("conversion_rates")
    private HashMap<String, Double> currencyMap;

    public Calculator(HashMap<String, Double> currencyMap) {
        this.currencyMap = currencyMap;
    }

    public double convert(double amount, String toCurrency) {
        return amount * currencyMap.get(toCurrency);
    }
}
