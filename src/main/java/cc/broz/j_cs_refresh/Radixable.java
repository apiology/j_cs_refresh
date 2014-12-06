package cc.broz.j_cs_refresh;

public interface Radixable {
    public static int MIN_VALUE = 0;

    /**
     * 0 is the least significant digit.
     *
     * @param maxNumberOfDigits the maximum number of digit item that
     *        this item could be compared to.
     */
    public int getDigit(int digitPlace, int maxNumberOfDigits);

    public int getNumberOfDigits();
}
