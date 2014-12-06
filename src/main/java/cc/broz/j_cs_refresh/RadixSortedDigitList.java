package cc.broz.j_cs_refresh;

import java.util.List;
import java.util.AbstractList;

public class RadixSortedDigitList<I extends Radixable>
    extends AbstractList<RepresentativeInteger> {
    
    private List<I> arr;
    private int digitPlace;

    public  RadixSortedDigitList(List<I> arr, int digitPlace) {
        this.arr = arr;
        this.digitPlace = digitPlace;
    }

    @Override
    public RepresentativeInteger get(int index) {
        return new RepresentativeInteger(arr.get(index),
                                         digitPlace);
    }

    @Override
    public int size() {
        return arr.size();
    }
}
