package cc.broz.j_cs_refresh;

public class BoxedType<T extends Comparable<T>> implements Comparable<BoxedType<T>> {
    public BoxedType(T l) {
        this.theT = l;
    }

    private T theT;
    
    public T getT() {
        return theT;
    }

    @Override
    public int compareTo(BoxedType<T> other) {
        return this.theT.compareTo(other.getT());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BoxedType) {
            // safe as I just checked...
            @SuppressWarnings("unchecked")
            BoxedType<?> bto = (BoxedType<T>)o;
            return this.theT.equals(bto.getT());
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return this.theT.hashCode();
    }

    @Override
    public String toString() {
        return this.theT.toString();
    }

}
