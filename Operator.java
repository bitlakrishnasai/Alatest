public class Operator {
    public int prefix[];
    public float price[];
    public String operatorName;

    public Operator(int[] prefix, float[] price, String operatorName) {
        this.prefix = prefix;
        this.price = price;
        this.operatorName = operatorName;
    }

    public float price(Long phoneNumber) { //Array value with index 0 is set to a price which will not generally used.

        int prefixIndex = 0;            //**Variable "prefixIndex" represents the location of the prefix in the array list**//
        {
            for (Long phonenumber = phoneNumber; phonenumber > 0; phonenumber = phonenumber / 10) {
                for (prefixIndex = 0; prefixIndex < prefix.length; prefixIndex++) {
                    if (phonenumber == prefix[prefixIndex]) {
//                        System.out.println(price[prefixIndex]);
                        phonenumber = 0L;
                        break;

                    }

                }

            }


        }


        if (prefixIndex < prefix.length) {
            return price[prefixIndex];

        } else {
            System.out.println("The price for the prefix does not exist in " + operatorName + " list");
            return price[0];
        }
    }
}
