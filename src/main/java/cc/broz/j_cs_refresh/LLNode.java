package cc.broz.j_cs_refresh;

public class LLNode<T> {
    private T content;
    private LLNode<T> next;

    public LLNode(T content,
                  LLNode<T> next) {
        this.content = content;
        this.next = next;
    }
        
    public T getContent() {
        return content;
    }

    public LLNode<T> getNext() {
        return next;
    }
}
