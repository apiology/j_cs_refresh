package cc.broz.j_cs_refresh;

public class MyInteger extends BoxedType<Integer> implements Radixable {
    MyInteger(Integer i) {
        super(i);
    }

    @Override
    public int getNumberOfDigits() {
        return String.valueOf(getT()).length();
    }

    @Override
    public int getDigit(int digitPlace) {
        int i = getT().intValue();
        return (int) ((i / Math.pow(10, digitPlace)) % 10);
    }
}
