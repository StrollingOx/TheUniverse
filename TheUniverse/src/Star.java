import java.math.BigInteger;

public class Star {
    private String name; //unique
    private BigInteger age;

    public BigInteger getAge() {
        return age;
    }

    public Star(String name, BigInteger age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}
