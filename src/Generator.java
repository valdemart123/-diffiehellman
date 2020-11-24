import java.math.BigInteger;
import java.util.Random;

public class Generator {
    public BigInteger getA (int q) {
       return BigInteger.valueOf((int) Math.sqrt(q));
    }

    public int getPrivateNumber (int q) {
        Random random = new Random();
        int result = random.nextInt(q);
        return result;
    }
}
