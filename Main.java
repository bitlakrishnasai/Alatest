import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("please enter valid phone phoneNumber");
        Map<String, Float> operatorMap;
        long phoneNumber;
        //**list of prefixes for operatorA are entered into the array**//
        int prefixnumber_operatorA[] = {0, 1, 268, 46, 4620, 468, 4631, 4673, 46732};
        //**list of prices for operatorA corresponding to the prefixes are entered in the same order**//
        float price_operatorA[] = {99999f, 0.9f, 5.1f, 0.17f, 0.0f, 0.15f, 0.15f, 0.9f, 1.1f};
        Operator operatorA = new Operator(prefixnumber_operatorA, price_operatorA, "OperatorA");

        //**list of prefixes for operatorB are entered into the array**//
        int prefixnumber_operatorB[] = {0, 1, 44, 46, 467, 48};
        //**list of prices for operatorB corresponding to the prefixes are entered in the same order**//
        float price_operatorB[] = {99999.0f, 0.92f, 0.5f, 0.2f, 1.0f, 1.2f};
        Operator operatorB = new Operator(prefixnumber_operatorB, price_operatorB, "OperatorB");
        try {
            phoneNumber = getInput();

            operatorMap = getOperatorNameAndPrice(operatorA, operatorB, phoneNumber);
            String operatorName = operatorMap.keySet().stream().findFirst().get();
            float price = operatorMap.get(operatorName);

            if(operatorMap.get(operatorName) != -1f){
                System.out.print( operatorName + " is cheapest with price " + price);
            }else if(operatorMap.get(operatorName) == -2f){
                System.out.print("Code Should never end here");
            } else {
                System.out.println("\nPrefix does'not exist with either Operator\n");
            }
        }catch(Exception e){
            System.out.println("Invalid Input");
            System.exit(1);
        }

    }

    public static long getInput() {
        long phoneNumber;
        Scanner sc = new Scanner(System.in);
        //**Scanner is used to take input and the next Long value is considered an the phone phoneNumber that is being dialed**//
        phoneNumber = sc.nextLong();
        return phoneNumber;
    }

    public static Map<String, Float> getOperatorNameAndPrice(Operator operatorA, Operator operatorB, long phoneNumber) {
        Map<String, Float> operator_Price = new HashMap<>();

        float price_for_operatorA = operatorA.price(phoneNumber);

        float price_for_operatorB = operatorB.price(phoneNumber);

        if (price_for_operatorA < price_for_operatorB) {
            operator_Price.put(operatorA.operatorName, price_for_operatorA);
            return operator_Price;
        } else if (price_for_operatorB < price_for_operatorA) {
            operator_Price.put(operatorB.operatorName, price_for_operatorB);
            return operator_Price;
        } else if (price_for_operatorA == price_for_operatorB && price_for_operatorA != 99999f) {
            operator_Price.put("Both", price_for_operatorA);
            return operator_Price;
        } else if (price_for_operatorA == price_for_operatorB && price_for_operatorA == 99999f) {
            operator_Price.put("Prefix does'not exist with either Operator", -1f);
        }
        operator_Price.put("Code Should never end here", -2f);
        return operator_Price;
    }
}
