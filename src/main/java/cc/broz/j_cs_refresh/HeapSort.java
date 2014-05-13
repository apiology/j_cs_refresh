package cc.broz.j_cs_refresh;

import java.util.ArrayList;
import java.lang.Comparable;

public class HeapSort implements Sorter {

    MinHeapFactory mhf;

    public HeapSort(MinHeapFactory mhf) {
        this.mhf = mhf;
    }

    public <I extends Comparable> ArrayList<I> sort(ArrayList<I> arr) {
        MinHeap<I> mh = mhf.create();
        for (I t : arr) {
            mh.push(t);
        }
        ArrayList<I> out = new ArrayList<I>(arr.size());
        while (!mh.isEmpty()) {
            out.add(mh.pop());
        }
        return out;
    }
}
