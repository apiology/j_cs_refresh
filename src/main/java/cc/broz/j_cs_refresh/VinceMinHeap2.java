package cc.broz.j_cs_refresh;

import java.util.ArrayList;

public class VinceMinHeap2<T extends Comparable<? super T>> implements MinHeap<T> {
    private ArrayList<T> arr;

    public VinceMinHeap2() {
        this.arr = new ArrayList<T>();
    }

    public VinceMinHeap2(int initialSize) {
        this.arr = new ArrayList<T>(initialSize);
    }

    private static int left(int i) {
        assert i >= 0;
        return 2*i;
    }

    private static int right(int i) {
        assert i >= 0;
        return 2*i + 1;
    }

    private static int parent(int i) {
        assert i > 0;
        return (int)i/2;
    }
    
    public void push(T t) {
        int idx = arr.size();
        arr.add(t);
        bubbleUp(idx);
    }

    private void bubbleUp(int idx) {
        if (idx != 0) {
            T currentValue = arr.get(idx);
            T parentValue = arr.get(parent(idx));
            if (currentValue.compareTo(parentValue) < 0) {
                swapWithParent(idx);
                bubbleUp(parent(idx));
            }
        }
    }

    private void swapWithParent(int idx) {
        T val = arr.get(idx);
        T parentVal = arr.get(parent(idx));
        arr.set(idx, parentVal);
        arr.set(parent(idx), val);
    }

    private void swapWithLeft(int idx) {
        T val = arr.get(idx);
        T leftVal = arr.get(left(idx));
        arr.set(idx, leftVal);
        arr.set(left(idx), val);
    }

    private void swapWithRight(int idx) {
        T val = arr.get(idx);
        T rightVal = arr.get(right(idx));
        arr.set(idx, rightVal);
        arr.set(right(idx), val);
    }
    
    public T pop() {
        if (arr.size() == 0) {
            throw new IllegalStateException("Underflow");
        } else {
            T topValue = arr.get(0);
            int end = arr.size() - 1;
            T endValue = arr.get(end);
            arr.set(0, endValue);
            arr.remove(end);
            if (arr.size() > 0) {
                pushDown(0);
            }
            return topValue;
        }
    }

    private void pushDown(int idx) {
        assert arr.size() > 0;
        assert idx < arr.size();
        int end = arr.size() - 1;
        T val = arr.get(idx);
        if (left(idx) <= end) {
            // there's a left...try to swap with it
            T leftVal = arr.get(left(idx));
            if (val.compareTo(leftVal) > 0) {
                swapWithLeft(idx);
                pushDown(left(idx));
                return;
            }
        }
        if (right(idx) <= end) {
            // there's a right...try to swap with it
            T rightVal = arr.get(right(idx));
            if (val.compareTo(rightVal) > 0) {
                swapWithRight(idx);
                pushDown(right(idx));
                return;
            }
        }
    }

    public boolean isEmpty() {
        return arr.size() == 0;
    }
}
