package cc.broz.j_cs_refresh;

public class VinceMinHeap2Factory<T extends Comparable<T>> implements MinHeapFactory<T> {
	public MinHeap<T> create() {
        return new VinceMinHeap2<T>();
	}
    public MinHeap<T> create(int initialSize) {
		return new VinceMinHeap2<T>(initialSize);
	}
}
