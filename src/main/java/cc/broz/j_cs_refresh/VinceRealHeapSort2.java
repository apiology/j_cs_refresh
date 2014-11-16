package cc.broz.j_cs_refresh;

import java.util.List;

public class VinceRealHeapSort2 implements ComparableSorter {
    public <I extends Comparable<? super I>> void sort(List<I> arr) {
        log("***** sort(" + arr + ")");
        makeIntoMaxHeap(arr);
        log("checking if " + arr + " is valid max heap...");
        sortHeap(arr);
        log("***** " + arr);        
    }

    private <I extends Comparable<? super I>> void makeIntoMaxHeap(List<I> arr) {
        log("makeIntoMaxHeap(" + arr + ")");
        if (arr.size() > 0) {
            for (int i = parent(lastIndex(arr) + 1); i >= 0; --i) {
                pushDown(arr, i);
            }
        }
    }

    private <I> int lastIndex(List<I> arr) {
        return arr.size() - 1;
    }

    private <I extends Comparable<? super I>> void sortHeap(List<I> arr) {
        log("sortHeap(" + arr + ")");
        for (int i = lastIndex(arr); i > 0; --i) {
            swap(arr, i, 0);
            pushDown(arr.subList(0, i), 0);
        }
    }

    private void log(String s) {
        // System.err.println(s);
    }

    private <I extends Comparable<? super I>> void pushDown(List<I> arr, int idx) {
        log("pushDown(" + arr + ", " + idx + ")");
        assert assertValid(arr, idx);
        int biggestInFamily = largestInFamily(arr, idx);
        log("largestInFamily(" + arr + ", " + idx + ") = " + biggestInFamily);
        while (biggestInFamily != idx) {
            swap(arr, idx, biggestInFamily);
            idx = biggestInFamily;
            biggestInFamily = largestInFamily(arr, idx);
            log("largestInFamily(" + arr + ", " + idx + ") = " + biggestInFamily);
        }
    }

    private <I extends Comparable<? super I>> int largestInFamily (List<I> arr, int idx) {
        I value = arr.get(idx);
        if (valid(arr, left(idx)) && valid(arr, right(idx))) {
            // both valid
            I leftValue = arr.get(left(idx));
            I rightValue = arr.get(right(idx));
            if (leftValue.compareTo(rightValue) > 0) {
                // left value is highest child
                if (value.compareTo(leftValue) > 0) {
                    return idx;
                } else {
                    return left(idx);
                }
            } else {
                // right value is highest child
                if (value.compareTo(rightValue) > 0) {
                    return idx;
                } else {
                    return right(idx);
                }
            }
        } else if (valid(arr, left(idx))) {
            // left is valid, but right is not
            I leftValue = arr.get(left(idx));
            if (value.compareTo(leftValue) > 0) {
                return idx;
            } else {
                return left(idx);
            }           
        } else {
            // neither valid
            return idx;
        }
        
    }

    private <I> void swap(List<I> arr, int first, int second) {
        log("swap(" + arr + "," + first + ", " + second + ");");
        I firstVal = arr.get(first);
        I secondVal = arr.get(second);
        arr.set(first, secondVal);
        arr.set(second, firstVal);
    }

    private <I> boolean assertValid(List<I> arr, int idx) {
        if (!valid(arr, idx)) {
            throw new AssertionError("Index " + idx + " not valid in " + arr);
        }
        return true;
    }
    private <I> boolean valid(List<I> arr, int idx) {
        return idx < arr.size();
    }

    private int left(int idx) {
        return 2*idx + 1;
    }

    private int right(int idx) {
        return 2*idx + 2;
    }

    private int parent(int idx) {
        return (int)idx/2;
    }
}
