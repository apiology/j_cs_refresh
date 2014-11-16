package cc.broz.j_cs_refresh;

import java.util.ArrayList;

public class VinceMinHeap<T extends Comparable<T>>
    implements MinHeap<T> {

    ArrayList<T> arr;

    public VinceMinHeap() {
        this.arr = new ArrayList<T>();
    }

    public VinceMinHeap(int size) {
        this.arr = new ArrayList<T>(size);
    }

    public void push(T elementToPush) {
        int initialSize = arr.size();
        arr.add(elementToPush);
        bubbleUp(lastElementIndex());
        assert arr.size() == initialSize + 1;
    }

    public void bubbleUp(int index) {
        if (isTop(index)) {
            return;
        }

        int parentIndex = parent(index);
        assert parentIndex < index;

        T currentItem = arr.get(index);
        T parentItem = arr.get(parentIndex);

        if (currentItem.compareTo(parentItem) < 0) {
            swap(parentIndex, index);
            bubbleUp(parentIndex);
        } else {
            // we're done here--this is now in the right place.
            return;
        }
    }

    public T pop() {
        int initialSize = arr.size();
        assert initialSize > 0;
        swap(firstElementIndex(), lastElementIndex());
        T element = arr.remove(lastElementIndex());
        if (arr.size() > 0) {
            pushDown(firstElementIndex());
        }
        assert arr.size() == initialSize - 1;
        return element;
    }

    private T firstElement() {
        return arr.get(firstElementIndex());
    }

    private void pushDown(int index) {
        assert index >= 0;
        assert isValid(index);
        int right = right(index);
        assert right > index;
        int left = left(index);
        assert left > index;

        if (isValid(right) && isValid(left)) {
            pushDownToEitherChild(index);
        } else if (isValid(left)) {
            pushDownToLeftChild(index);
        } else {
            assert !isValid(right);
            // done
            return;
        }
    }

    private void pushDownToEitherChild(int index) {
        T element = arr.get(index);
        int right = right(index);
        int left = left(index);
        T rightElement = arr.get(right);
        T leftElement = arr.get(left);
        if (rightElement.compareTo(leftElement) < 0) {
            pushDownToRightChild(index);
        } else {
            pushDownToLeftChild(index);
        }
    }

    private void pushDownToRightChild(int index) {
        T element = arr.get(index);
        int right = right(index);
        T rightElement = arr.get(right);
        // right is smaller
        if (element.compareTo(rightElement) < 0) {
            // element is smaller than both children and thus is
            // now in right place.
            return;
        } else {
            // right is smaller
            swap(index, right);
            pushDown(right);
        }
    }

    private void pushDownToLeftChild(int index) {
        T element = arr.get(index);
        int left = left(index);
        T leftElement = arr.get(left);
        // left is smaller, or same
        if (element.compareTo(leftElement) < 0) {
            // element is smaller than both children and thus is
            // now in right place.
            return;
        } else {
            // left is smaller
            swap(index, left);
            pushDown(left);
        }
    }


    public boolean isEmpty() {
        return arr.size() == 0;
    }

    private boolean isTop(int index) {
        return index == 0;
    }

    private int firstElementIndex() {
        return 0;
    }

    private int lastElementIndex() {
        return arr.size() - 1;
    }

    private int parent(int index) {
        return (int)((index-1)/2);
    }

    private int right(int index) {
        return index*2 + 2;
    }

    private int left(int index) {
        return index*2 + 1;
    }

    private boolean isValid(int index) {
        return index < arr.size();
    }

    private void swap(int index1, int index2) {
        assert index1 >= 0;
        assert index2 >= 0;
        assert index1 < arr.size();
        assert index2 < arr.size();
        T temp = arr.get(index1);
        arr.set(index1, arr.get(index2));
        arr.set(index2, temp);
    }
}
