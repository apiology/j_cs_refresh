package cc.broz.j_cs_refresh;

import java.util.function.Consumer;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.ArrayDeque;

import java.util.function.Consumer;

public class BFS {
    public void visit(IVertex start,
                      Consumer<IVertex> consumer) {
        Set<IVertex> seen = new HashSet<>();
        Queue<IVertex> toLookAtNext = new ArrayDeque<>();
        toLookAtNext.add(start);
        IVertex current;
        while ((current = toLookAtNext.poll()) != null) {
                for (IVertex neighbor : current.getNeighbors()) {
                    if (!seen.contains(neighbor)) {
                        toLookAtNext.add(neighbor);
                    }
                }
                seen.add(current);
                consumer.accept(current);
            }
    }
}

