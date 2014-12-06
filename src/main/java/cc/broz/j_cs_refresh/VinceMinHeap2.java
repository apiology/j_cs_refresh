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
        return 2*i + 1;
    }

    private static int right(int i) {
        assert i >= 0;
        return 2*i + 2;
    }

    private static int parent(int i) {
        assert i > 0;
        return (int)(i - 1)/2;
    }
    
    public void push(T t) {
        int idx = arr.size();
        arr.add(t);
        bubbleUp(idx);
        assert validateHeap();
    }

    private boolean validateHeap() {
        for (int i = 0; i < arr.size(); i++) {
            validateHeapIndex(i);
        }
        return true; // or an assertion will be raised anyway
    }

    private void validateHeapIndex(int i) {
        int left = left(i);
        int right = right(i);
        if (left < arr.size()) {
            assert arr.get(i).compareTo(arr.get(left)) <= 0;
        }
        if (right < arr.size()) {
            assert arr.get(i).compareTo(arr.get(right)) <= 0;
        }
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

    private void swap(int idx1, int idx2) {
        T val1 = arr.get(idx1);
        T val2 = arr.get(idx2);
        arr.set(idx1, val2);
        arr.set(idx2, val1);
    }

    private void swapWithParent(int idx) {
        swap(idx, parent(idx));
    }

    private void swapWithLeft(int idx) {
        swap(idx, left(idx));
    }

    private void swapWithRight(int idx) {
        swap(idx, right(idx));
    }
    
    public T pop() {
        if (arr.size() == 0) {
            throw new IllegalStateException("Underflow");
        } else {
            assert validateHeap();
            T topValue = arr.get(0);
            int end = arr.size() - 1;
            T endValue = arr.get(end);
            arr.set(0, endValue);
            arr.remove(end);
            if (arr.size() > 0) {
                pushDown(0);
            }
            assert validateHeap();
            return topValue;
        }
    }

    private void pushDownRightOrLeft(int idx) {
        int right = right(idx);
        T rightVal = arr.get(right);
        int left = left(idx);
        T leftVal = arr.get(left);
        T val = arr.get(idx);

        int indexOfSmallest = indexOfSmallest(idx, left, right);

        if (indexOfSmallest == idx) {
            return;
        } else if (indexOfSmallest == right) {
            pushDownRight(idx);
        } else {
            pushDownLeft(idx);
        }
    }

    private int indexOfSmallest(int a, int b, int c) {
        return indexOfSmallest(indexOfSmallest(a, b), c);
    }

    private int indexOfSmallest(int a, int b) {
        if (arr.get(a).compareTo(arr.get(b)) < 0) {
            return a;
        } else {
            return b;
        }
    }

    private void pushDownRight(int idx) {    
        int right = right(idx);
        T val = arr.get(idx);
        // there's a right...try to swap with it
        T rightVal = arr.get(right);
        if (val.compareTo(rightVal) > 0) {
            swapWithRight(idx);
            pushDown(right);
            assert arr.get(idx).compareTo(arr.get(right)) <= 0;
            return;
        }
    }

    private void pushDownLeft(int idx) {
        int left = left(idx);
        T val = arr.get(idx);
        // there's a left...try to swap with it
        T leftVal = arr.get(left);
        if (val.compareTo(leftVal) > 0) {
            swapWithLeft(idx);
            pushDown(left);
            assert arr.get(idx).compareTo(arr.get(left)) <= 0;
            return;
        }
    }

    private void pushDown(int idx) {
        assert arr.size() > 0;
        assert idx < arr.size();
        assert idx >= 0;
        int right = right(idx);
        assert right > idx;
        int left = left(idx);
        assert left > idx;

        int end = arr.size() - 1;
        T val = arr.get(idx);
        if (right <= end) {
            pushDownRightOrLeft(idx);
        } else if (left <= end) {
            pushDownLeft(idx);
        }
    }

    public boolean isEmpty() {
        return arr.size() == 0;
    }
}
