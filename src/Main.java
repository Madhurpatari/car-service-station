import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarServiceStation serviceStation = new CarServiceStation();

        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************************");
        System.out.println("*  WELCOME TO THE CAR SERVICE BILL GENERATOR  *");
        System.out.println("*            SOFTWARE BY MADHUR               *");
        System.out.println("***********************************************");
        System.out.println();

        System.out.print("Enter the car type (Hatchback, Sedan, SUV): ");
        String carType = scanner.nextLine();

        Map<String, Integer> prices = serviceStation.getServicePrices(carType);
        System.out.println("\nAvailable Service Codes:");
        for (String serviceCode : prices.keySet()) {
            System.out.println(serviceCode);
        }

        System.out.print("Enter the service codes (comma-separated): ");
        String serviceCodesInput = scanner.nextLine();
        String[] serviceCodes = serviceCodesInput.split(",");

        scanner.close();

        try {
            int totalBill = serviceStation.calculateTotalBill(carType, serviceCodes);

            System.out.println("\nGenerating Bill...");
            System.out.println("Type of Car: " + carType);
            System.out.println("Service Codes: " + String.join(", ", serviceCodes));
            System.out.println("Total Bill: ₹ " + totalBill);

            if (totalBill > 10000) {
                System.out.println("Complimentary cleaning provided.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}