package cc.broz.j_cs_refresh;

import java.util.List;

public interface Sorter<Base> {
    public <I extends Base> void sort(List<I> arr);
}
