package cc.broz.j_cs_refresh;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Vertex {
    private List<Vertex> neighbors;

    public Vertex() {
        this.neighbors = new ArrayList();
    }

    public void addBidirectionalEdge(Vertex other) {
        addEdge(other);
        other.addEdge(this);
    }

    public void addEdge(Vertex other) {
        neighbors.add(other);
    }

    public List<Vertex> getNeighbors() {
        return this.neighbors;
    }

    public Map<Vertex, Integer> findDistances() {
        // use parent for grey, distances for black
        Map<Vertex, Integer> distances = new HashMap<Vertex, Integer>();
        Map<Vertex, Vertex> parent = new HashMap<Vertex, Vertex>();
        // treated as queue
        Deque<Vertex> closest = new ArrayDeque<Vertex>();
        closest.add(this);
        parent.put(this, null);
        while (!closest.isEmpty()) {
            Vertex item = closest.removeFirst();
            if (!distances.containsKey(item)) {
                int distance = 0;
                Vertex p = parent.get(item);
                if (p != null) {
                    distance = distances.get(p) + 1;
                }
                distances.put(item, distance);
                for (Vertex neighbor : item.getNeighbors()) {
                    if (!parent.containsKey(neighbor)) {
                        parent.put(neighbor, item);
                        closest.add(neighbor);
                    }
                }
            }
        }
        return distances;
    }
}
