package cc.broz.j_cs_refresh;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;

public class DijkstraSolver
{
    private Vertex root;
    private Map<Vertex, GraphPath> shortestPaths;
    private Set<Vertex> finalized;
    private PriorityQueue<GraphPath> pq;

    public DijkstraSolver(Vertex root) {
        this.root = root;
        this.shortestPaths = new HashMap<Vertex, GraphPath>();
        this.finalized = new HashSet<Vertex>();
        this.pq = new PriorityQueue<GraphPath>();
        GraphPath rootPath = new GraphPath(root, 0);
        pq.add(rootPath);
        shortestPaths.put(root, rootPath);
    }

    public Map<Vertex, GraphPath> findShortestPaths() {
        while (!pq.isEmpty()) {
            processNextShortestPath();
        }
        return shortestPaths;
    }

    public void processNextShortestPath() {
        GraphPath vPath = pq.poll();
        Vertex v = vPath.getTarget();
        if (!finalized.contains(v)) {
            finalized.add(v);
            addNeighborsToPriorityQueue(v, vPath);
        }
    }

    public void addNeighborsToPriorityQueue(Vertex v, GraphPath vPath) {
        for (Map.Entry<Vertex, Integer> neighborAndDistance
                 : v.getNeighborsAndDistances().entrySet()) {
            Vertex neighbor = neighborAndDistance.getKey();
            int distance = neighborAndDistance.getValue();
            GraphPath newNeighborPath = vPath.append(neighbor, distance);
            checkSingleNeighbor(v, vPath,
                                neighbor, newNeighborPath);
        }
    }

    public void checkSingleNeighbor(Vertex parent, GraphPath parentPath,
                                    Vertex child, GraphPath childPath) {
        if (!shortestPaths.containsKey(child) ||
            (childPath.getDistance() <
             shortestPaths.get(child).getDistance())) {
            shortestPaths.put(child, childPath);
            pq.add(childPath);
        }
    }
}
