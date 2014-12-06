package cc.broz.j_cs_refresh;

public class MyLong extends BoxedType<Long> implements Radixable {
    public MyLong(Long l) {
        super(l);
    }

    public int getDigit(int digitPlace) {
        long l = getT().intValue();
        return (int) ((l / Math.pow(10, digitPlace)) % 10);
    }
}
