import java.util.HashMap;
import java.util.Map;

public class CarServiceStation {
    private Map<String, Map<String, Integer>> servicePrices;

    public CarServiceStation() {
        servicePrices = new HashMap<>();

        Map<String, Integer> hatchbackPrices = new HashMap<>();
        hatchbackPrices.put("BS01", 2000);
        hatchbackPrices.put("EF01", 5000);
        hatchbackPrices.put("CF01", 2000);
        hatchbackPrices.put("BF01", 1000);
        hatchbackPrices.put("GF01", 3000);
        servicePrices.put("Hatchback", hatchbackPrices);

        Map<String, Integer> sedanPrices = new HashMap<>();
        sedanPrices.put("BS01", 4000);
        sedanPrices.put("EF01", 8000);
        sedanPrices.put("CF01", 4000);
        sedanPrices.put("BF01", 1500);
        sedanPrices.put("GF01", 6000);
        servicePrices.put("Sedan", sedanPrices);

        Map<String, Integer> suvPrices = new HashMap<>();
        suvPrices.put("BS01", 5000);
        suvPrices.put("EF01", 10000);
        suvPrices.put("CF01", 6000);
        suvPrices.put("BF01", 2500);
        suvPrices.put("GF01", 8000);
        servicePrices.put("SUV", suvPrices);
    }

        public int calculateTotalBill(String carType, String[] serviceCodes) throws IllegalArgumentException {
            if (!servicePrices.containsKey(carType)) {
                throw new IllegalArgumentException("Invalid car type: " + carType);
            }
            Map<String, Integer> prices = servicePrices.get(carType);
            int totalBill = 0;

            for (String serviceCode : serviceCodes) {
                if (prices.containsKey(serviceCode)) {
                    totalBill += prices.get(serviceCode);
                }
            }

            return totalBill;
        }
    public Map<String, Integer> getServicePrices(String carType) {
        if (!servicePrices.containsKey(carType)) {
            throw new IllegalArgumentException("Invalid car type: " + carType);
        }

        return servicePrices.get(carType);
    }

}
