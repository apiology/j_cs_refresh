package cc.broz.j_cs_refresh;

public class MyLong implements Radixable, Comparable<MyLong> {
	public MyLong(Long l) {
		this.theLong = l;
	}

	private Long theLong;
	
	public Long getLong() {
		return theLong;
	}

	@Override
	public int compareTo(MyLong other) {
		return this.theLong.compareTo(other.getLong());
	}

	@Override
	public boolean equals(Object o) {
		return this.theLong.equals(((MyLong)o).getLong());
	}

	@Override
	public int hashCode() {
		return this.theLong.hashCode();
	}

	@Override
	public String toString() {
		return this.theLong.toString();
	}
}