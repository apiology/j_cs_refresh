package cc.broz.j_cs_refresh;

import java.util.List;
import java.util.AbstractList;

public class RadixSortedDigitList<I extends Radixable>
    extends AbstractList<RepresentativeInteger<I>> {
    
    private List<I> arr;
    private int digitPlace;

    public  RadixSortedDigitList(List<I> arr, int digitPlace) {
        this.arr = arr;
        this.digitPlace = digitPlace;
    }

    @Override
    public RepresentativeInteger<I> get(int index) {
        return new RepresentativeInteger<I>(arr.get(index),
                                            digitPlace);
    }

    @Override
    public int size() {
        return arr.size();
    }

    @Override
    public RepresentativeInteger<I> set(int index, RepresentativeInteger<I> item) {
        return new RepresentativeInteger<I>(arr.set(index, item.getItem()),
                                            digitPlace);
                                                    
    }
}
