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
		return this.theT.equals(((BoxedType<T>)o).getT());
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
