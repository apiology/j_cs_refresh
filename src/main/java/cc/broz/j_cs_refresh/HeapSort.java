package cc.broz.j_cs_refresh;

import java.util.List;
import java.lang.Comparable;

public class HeapSort implements Sorter<Comparable> {

    MinHeapFactory mhf;

    public HeapSort(MinHeapFactory mhf) {
        this.mhf = mhf;
    }

    public <I extends Comparable> void sort(List<I> arr) {
        MinHeap<I> mh = mhf.create();
        for (I t : arr) {
            mh.push(t);
        }
		int i = 0;
        while (!mh.isEmpty()) {
			assert i < arr.size();
            arr.set(i, mh.pop());
			i++;
        }
    }
}
