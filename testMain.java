import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class testMain {

    @Test
    public void verify_lowest_price_prefix_exits_in_operatorA(){
        Map<String, Float> actualOutput;
        int prefixnumber_operatorA[] = {0, 1, 268, 46, 4620, 468, 4631, 4673, 46732};
        float price_operatorA[] = {99999f, 0.9f, 5.1f, 0.17f, 0.0f, 0.15f, 0.15f, 0.9f, 1.1f};
        Operator operatorA = new Operator(prefixnumber_operatorA, price_operatorA, "OperatorA");

        int prefixnumber_operatorB[] = {0, 1, 44, 46, 467, 48};
        float price_operatorB[] = {99999.0f, 0.92f, 0.5f, 0.2f, 1.0f, 1.2f};
        Operator operatorB = new Operator(prefixnumber_operatorB, price_operatorB, "OperatorB");
        actualOutput = Main.getOperatorNameAndPrice(operatorA, operatorB,46);
        String operatorName = actualOutput.keySet().stream().findFirst().get();
        float price = actualOutput.get(operatorName);
        Assert.assertEquals("OperatorA", operatorName);
        Assert.assertEquals(0.17f, price, 0.0f);
    }

    @Test
    public void verify_lowest_price_prefix_exits_in_operatorB(){
        Map<String, Float> actualOutput;
        int prefixnumber_operatorA[] = {0, 1, 268, 46, 4620, 468, 4631, 4673, 46732, 22};
        float price_operatorA[] = {99999f, 0.9f, 5.1f, 0.17f, 0.0f, 0.15f, 0.15f, 0.9f, 1.1f, 5.5f};
        Operator operatorA = new Operator(prefixnumber_operatorA, price_operatorA, "OperatorA");

        int prefixnumber_operatorB[] = {0, 1, 44, 46, 467, 48, 22};
        float price_operatorB[] = {99999.0f, 0.92f, 0.5f, 0.2f, 1.0f, 1.2f, 4.3f};
        Operator operatorB = new Operator(prefixnumber_operatorB, price_operatorB, "OperatorB");
        actualOutput = Main.getOperatorNameAndPrice(operatorA, operatorB,22);
        String operatorName = actualOutput.keySet().stream().findFirst().get();
        float price = actualOutput.get(operatorName);
        Assert.assertEquals("OperatorB", operatorName);
        Assert.assertEquals(4.3f, price, 0.0f);
    }

    @Test
    public void verify_prefix_does_not_exist_in_operator(){
        int prefixnumber_operator[] = {0, 1, 268, 46, 4620, 468, 4631, 4673, 46732};
        float price_operator[] = {99999f, 0.9f, 5.1f, 0.17f, 0.0f, 0.15f, 0.15f, 0.9f, 1.1f};
        Operator operator = new Operator(prefixnumber_operator, price_operator, "OperatorA");
        Assert.assertEquals(99999f, operator.price(48L), 0.0f);
    }

    @Test
    public void verify_phoneNumber_does_not_exist_in_both_operators(){
        Map<String, Float> actualOutput;
        int prefixnumber_operatorA[] = {0, 1, 268, 46, 4620, 468, 4631, 4673, 46732};
        float price_operatorA[] = {99999f, 0.9f, 5.1f, 0.17f, 0.0f, 0.15f, 0.15f, 0.9f, 1.1f};
        Operator operatorA = new Operator(prefixnumber_operatorA, price_operatorA, "OperatorA");

        int prefixnumber_operatorB[] = {0, 1, 44, 46, 467, 48};
        float price_operatorB[] = {99999.0f, 0.92f, 0.5f, 0.2f, 1.0f, 1.2f};
        Operator operatorB = new Operator(prefixnumber_operatorB, price_operatorB, "OperatorB");

        actualOutput = Main.getOperatorNameAndPrice(operatorA,operatorB,999999);
        String operatorName = actualOutput.keySet().stream().findFirst().get();
        float price = actualOutput.get(operatorName);

        Assert.assertEquals(-1f, price,0.0f);
        Assert.assertEquals("Prefix does'not exist with either Operator", operatorName);
    }

    @Test
    public void verify_phoneNumber_exist_in_both_operators_with_same_price(){
        Map<String, Float> actualOutput;
        int prefixnumber_operatorA[] = {0, 1, 268, 46, 4620, 468, 4631, 4673, 46732, 22};
        float price_operatorA[] = {99999f, 0.9f, 5.1f, 0.17f, 0.0f, 0.15f, 0.15f, 0.9f, 1.1f, 5.8f};
        Operator operatorA = new Operator(prefixnumber_operatorA, price_operatorA, "OperatorA");

        int prefixnumber_operatorB[] = {0, 1, 44, 46, 467, 48, 22};
        float price_operatorB[] = {99999.0f, 0.92f, 0.5f, 0.2f, 1.0f, 1.2f, 5.8f};
        Operator operatorB = new Operator(prefixnumber_operatorB, price_operatorB, "OperatorB");
        actualOutput = Main.getOperatorNameAndPrice(operatorA,operatorB,22);
        String operatorName = actualOutput.keySet().stream().findFirst().get();
        float price = actualOutput.get(operatorName);
        Assert.assertEquals(5.8f, price,0.0f);
        Assert.assertEquals("Both", operatorName);
    }

}
