package cc.broz.j_cs_refresh;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Vertex {
    private Map<Vertex, Integer> neighbors;
    private String name;

    public Vertex(String name) {
        this.name = name;
        this.neighbors = new HashMap<Vertex, Integer>();
    }

    public void addBidirectionalEdge(Vertex other, int distance) {
        addEdge(other, distance);
        other.addEdge(this, distance);
    }

    public void addEdge(Vertex other, int distance) {
        this.neighbors.put(other, distance);
    }

    public Collection<Vertex> getNeighbors() {
        return this.neighbors.keySet();
    }

    public Map<Vertex, Integer> getNeighborsAndDistances() {
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

    public Set<Vertex> findAllVertices() {
        Set<Vertex> allVertices = new HashSet<Vertex>();
        Set<Vertex> allEdgesAdded = new HashSet<Vertex>();
        Deque<Vertex> itemsToExplore = new ArrayDeque<Vertex>();
        itemsToExplore.add(this);
        while (!itemsToExplore.isEmpty()) {
            Vertex item = itemsToExplore.pop();
            allVertices.add(item);
            for (Vertex neighbor : item.getNeighbors()) {
                if (!allEdgesAdded.contains(neighbor)) {
                    allEdgesAdded.add(neighbor);
                    itemsToExplore.add(neighbor);
                }
            }
        }
        return allVertices;
    }

    public Map<Vertex, GraphPath> findShortestPaths() {
        DijkstraSolver ds = new DijkstraSolver(this);
        return ds.findShortestPaths();
    }

    public String toString() {
        return "V<" + this.name + ">";
    }
}
