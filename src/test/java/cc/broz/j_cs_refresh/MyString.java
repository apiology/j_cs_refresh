package cc.broz.j_cs_refresh;

public class MyString extends BoxedType<String> implements Radixable {
    public MyString(String s) {
        super(s);
    }

    public int getDigit(int digitPlace) {
        return getT().charAt(digitPlace) - 'a';
    }
}
