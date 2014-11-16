package cc.broz.j_cs_refresh;

public class MyInteger implements Radixable, Comparable<MyInteger> {
	public MyInteger(Integer l) {
		this.theInteger = l;
	}

	private Integer theInteger;
	
	public Integer getInteger() {
		return theInteger;
	}

	@Override
	public int compareTo(MyInteger other) {
		return this.theInteger.compareTo(other.getInteger());
	}

	@Override
	public boolean equals(Object o) {
		return this.theInteger.equals(((MyInteger)o).getInteger());
	}

	@Override
	public int hashCode() {
		return this.theInteger.hashCode();
	}

	@Override
	public String toString() {
		return this.theInteger.toString();
	}
}
