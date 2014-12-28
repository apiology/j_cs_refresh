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

class Vertex implements IVertex {
    private Map<IVertex, Integer> neighbors;
    private String name;

    public Vertex(String name) {
        this.name = name;
        this.neighbors = new HashMap<IVertex, Integer>();
    }

    @Override
    public void addBidirectionalEdge(IVertex other, int distance) {
        addEdge(other, distance);
        other.addEdge(this, distance);
    }

    @Override
    public void addEdge(IVertex other, int distance) {
        this.neighbors.put(other, distance);
    }

    @Override
    public Collection<IVertex> getNeighbors() {
        return this.neighbors.keySet();
    }

    @Override
    public Map<IVertex, Integer> getNeighborsAndDistances() {
        return this.neighbors;
    }

    @Override
    public Map<IVertex, Integer> findNumberOfHops() {
        // use parent for grey, distances for black
        Map<IVertex, Integer> distances = new HashMap<>();
        Map<IVertex, IVertex> parent = new HashMap<>();
        // treated as queue
        Deque<IVertex> closest = new ArrayDeque<>();
        closest.add(this);
        parent.put(this, null);
        while (!closest.isEmpty()) {
            IVertex item = closest.removeFirst();
            if (!distances.containsKey(item)) {
                int distance = 0;
                IVertex p = parent.get(item);
                if (p != null) {
                    distance = distances.get(p) + 1;
                }
                distances.put(item, distance);
                for (IVertex neighbor : item.getNeighbors()) {
                    if (!parent.containsKey(neighbor)) {
                        parent.put(neighbor, item);
                        closest.add(neighbor);
                    }
                }
            }
        }
        return distances;
    }

    @Override
    public Set<IVertex> findAllVertices() {
        Set<IVertex> allVertices = new HashSet<>();
        Set<IVertex> allEdgesAdded = new HashSet<>();
        Deque<IVertex> itemsToExplore = new ArrayDeque<>();
        itemsToExplore.add(this);
        while (!itemsToExplore.isEmpty()) {
            IVertex item = itemsToExplore.pop();
            allVertices.add(item);
            for (IVertex neighbor : item.getNeighbors()) {
                if (!allEdgesAdded.contains(neighbor)) {
                    allEdgesAdded.add(neighbor);
                    itemsToExplore.add(neighbor);
                }
            }
        }
        return allVertices;
    }

    @Override
    public Map<IVertex, GraphPath> findShortestPaths() {
        DijkstraSolver ds = new DijkstraSolver(this);
        return ds.findShortestPaths();
    }

    @Override
    public List<IVertex> bestPath(IVertex targetVertex,
                                  Map<IVertex, Integer> optimisticEstimatesToTarget) {
        AStarSolver as = new AStarSolver(this, targetVertex,
                                         optimisticEstimatesToTarget);
        return as.bestPath();
    }

    @Override
    public String toString() {
        return "V<" + this.name + ">";
    }
}
