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
    public int getDigit(int digitPlace, int lengthToCompare) {
        String s = getT();
        int stringIndex = lengthToCompare - digitPlace - 1;
        if (stringIndex >= s.length()) {
            return Radixable.MIN_VALUE;
        } else {
            return Radixable.MIN_VALUE +
                (getT().charAt(stringIndex) - 'a' + 1);
        }
    }
}
