package cc.broz.j_cs_refresh;

import java.util.HashMap;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Vertex2 
    implements IVertex
{

    Map<IVertex, Integer> neighborsAndDistances;

    public Vertex2(String name) {
        this.neighborsAndDistances = new HashMap<>();
    }

    @Override
    public void addBidirectionalEdge(IVertex other, int distance) {
        this.neighborsAndDistances.put(other, distance);
    }

    @Override
    public void addEdge(IVertex other, int distance) {
        throw new IllegalStateException("Implement me!");
    }

    @Override
    public Map<IVertex,Integer> getNeighborsAndDistances() {
        return neighborsAndDistances;
    }

    @Override
    public Collection<IVertex> getNeighbors() {
        return this.neighborsAndDistances.keySet();
    }

    @Override
    public Map<IVertex,Integer> findDistances() {
        Map<IVertex, Integer> distance = new HashMap<>();
        distance.put(this, 0);
        BFS bfs = new BFS();
        bfs.visit(this, (node) -> {
                for (Map.Entry<IVertex, Integer> neighborAndDistance :
                         node.getNeighborsAndDistances().entrySet()) {
                    IVertex neighbor = neighborAndDistance.getKey();
                    int distanceToNeighbor = neighborAndDistance.getValue();
                    int distanceThroughNode = distanceToNeighbor + distance.get(node);
                    if (!distance.containsKey(neighbor) ||
                        distanceThroughNode < distance.get(neighbor)) {
                        distance.put(neighbor, distanceThroughNode);
                    }
                }
            });
        return distance;
    }

    @Override
    public Set<IVertex> findAllVertices() {
        throw new IllegalStateException("Implement me!");
    }

    @Override
    public Map<IVertex,GraphPath> findShortestPaths() {
        throw new IllegalStateException("Implement me!");
    }

    @Override
    public List<IVertex> bestPath(IVertex targetVertex, Map<IVertex,Integer> optimisticEstimatesToTarget) {
        throw new IllegalStateException("Implement me!");
    }
}
