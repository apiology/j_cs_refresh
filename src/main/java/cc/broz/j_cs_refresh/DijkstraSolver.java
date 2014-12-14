package cc.broz.j_cs_refresh;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;

public class DijkstraSolver
{
    private IVertex root;
    private Map<IVertex, GraphPath> shortestPaths;
    private Set<IVertex> finalized;
    private PriorityQueue<GraphPath> pq;

    public DijkstraSolver(IVertex root) {
        this.root = root;
        this.shortestPaths = new HashMap<IVertex, GraphPath>();
        this.finalized = new HashSet<IVertex>();
        this.pq = new PriorityQueue<GraphPath>();
        GraphPath rootPath = new GraphPath(root, 0);
        pq.add(rootPath);
        shortestPaths.put(root, rootPath);
    }

    public Map<IVertex, GraphPath> findShortestPaths() {
        while (!pq.isEmpty()) {
            processNextShortestPath();
        }
        return shortestPaths;
    }

    public void processNextShortestPath() {
        GraphPath vPath = pq.poll();
        IVertex v = vPath.getTarget();
        if (!finalized.contains(v)) {
            finalized.add(v);
            addNeighborsToPriorityQueue(v, vPath);
        }
    }

    public void addNeighborsToPriorityQueue(IVertex v, GraphPath vPath) {
        for (Map.Entry<IVertex, Integer> neighborAndDistance
                 : v.getNeighborsAndDistances().entrySet()) {
            IVertex neighbor = neighborAndDistance.getKey();
            int distance = neighborAndDistance.getValue();
            GraphPath newNeighborPath = vPath.append(neighbor, distance);
            checkSingleNeighbor(v, vPath,
                                neighbor, newNeighborPath);
        }
    }

    public void checkSingleNeighbor(IVertex parent, GraphPath parentPath,
                                    IVertex child, GraphPath childPath) {
        if (!shortestPaths.containsKey(child) ||
            (childPath.getDistance() <
             shortestPaths.get(child).getDistance())) {
            shortestPaths.put(child, childPath);
            pq.add(childPath);
        }
    }
}
