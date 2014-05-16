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
        // black items have been added 'distances'
        Set<Vertex> black = new HashSet<Vertex>();
        // grey items have been added to 'closest'
        Set<Vertex> grey = new HashSet<Vertex>();
        // treated as queue
        Deque<Vertex> closest = new ArrayDeque<Vertex>();
        closest.add(this);
        grey.add(this);
        while (!closest.isEmpty()) {
            Vertex item = closest.removeFirst();
            if (!black.contains(item)) {
                black.add(item);
                int distance = 0;
                Vertex p = parent.get(item);
                if (p != null) {
                    distance = distances.get(p) + 1;
                }
                distances.put(item, distance);
                for (Vertex neighbor : item.getNeighbors()) {
                    if (!grey.contains(neighbor)) {
                        grey.add(neighbor);
                        parent.put(neighbor, item);
                        closest.add(neighbor);
                    }
                }
            }
        }
        return distances;
    }
}
