package cc.broz.j_cs_refresh;

import java.util.List;
import java.util.AbstractList;

public class RadixSortedDigitList<I extends Radixable>
    extends AbstractList<RepresentativeInteger<I>> {
    
    private List<I> arr;
    private int digitPlace;
    private int maxNumberOfDigits;

    public  RadixSortedDigitList(List<I> arr, int digitPlace, int maxNumberOfDigits) {
        this.arr = arr;
        this.digitPlace = digitPlace;
        this.maxNumberOfDigits = maxNumberOfDigits;
    }

    @Override
    public RepresentativeInteger<I> get(int index) {
        return new RepresentativeInteger<I>(arr.get(index),
                                            digitPlace,
                                            this.maxNumberOfDigits);
    }

    @Override
    public int size() {
        return arr.size();
    }

    @Override
    public RepresentativeInteger<I> set(int index, RepresentativeInteger<I> item) {
        return new RepresentativeInteger<I>(arr.set(index, item.getItem()),
                                            digitPlace,
                                            this.maxNumberOfDigits);
                                                    
    }
}
