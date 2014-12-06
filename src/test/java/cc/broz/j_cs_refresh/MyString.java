package cc.broz.j_cs_refresh;

public class MyString extends BoxedType<String> implements Radixable {
    public MyString(String s) {
        super(s);
    }

    @Override
    public int getNumberOfDigits() {
        return getT().length();
    }

    @Override
    public int getDigit(int digitPlace) {
        String s = getT();
        if (digitPlace >= s.length()) {
            return 0;
        } else {
            return getT().charAt(digitPlace) - 'a';
        }
    }
}
