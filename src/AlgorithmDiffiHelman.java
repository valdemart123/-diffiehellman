import java.math.BigInteger;

public class AlgorithmDiffiHelman {

    private BigInteger q;
    /**
     * генератор
     */
    private BigInteger a;
    /**
     * приватное число пользователя
     */
    private int privateNumber;

    /**
     * Конструкор
     */
    public AlgorithmDiffiHelman(){
        q=null;
        a=null;
        privateNumber = 0;
    }


    public AlgorithmDiffiHelman(BigInteger q, BigInteger a, int privateNumber){
        this.q = q;
        this.a = a;
        this.privateNumber = privateNumber;
    }

    public BigInteger calculatePublicKey(){
        BigInteger publicKey;
        publicKey= a.pow(privateNumber);
        publicKey = publicKey.mod(q);
        return publicKey;
    }

    public BigInteger calculatePrivateKey(BigInteger publicKey){
        BigInteger privateKey;
        privateKey = publicKey.pow(privateNumber);
        privateKey = privateKey.mod(q);
        return privateKey;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getA() {
        return a;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public void setA(BigInteger a) {
        this.a = a;
    }

    public void setPrivateNumber(int privateNumber) {
        this.privateNumber = privateNumber;
    }
}
