package cc.broz.j_cs_refresh;

public class MyLong implements Radixable, Comparable<MyLong> {
	public MyLong(Long l) {
		this.theLong = l;
	}

	private Long theLong;
	
	public Long getLong() {
		return theLong;
	}
	
	public int compareTo(MyLong other) {
		return this.theLong.compareTo(other.getLong());
	}

	public String toString() {
		return this.theLong.toString();
	}
}
