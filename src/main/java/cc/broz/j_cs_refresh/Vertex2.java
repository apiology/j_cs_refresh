package cc.broz.j_cs_refresh;

import java.util.HashMap;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Queue;

public class Vertex2 
    implements IVertex
{

    Map<IVertex, Integer> neighborsAndDistances;
    String name;

    public Vertex2(String name) {
        this.neighborsAndDistances = new HashMap<>();
        this.name = name;
    }

    @Override
    public void addBidirectionalEdge(IVertex other, int distance) {
        this.addEdge(other, distance);
        other.addEdge(this, distance);
    }

    @Override
    public void addEdge(IVertex other, int distance) {
        this.neighborsAndDistances.put(other, distance);
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
    public Map<IVertex,Integer> findNumberOfHops() {
        // numberOfHops = {}
        Map<IVertex,Integer> numberOfHops = new HashMap<>();
        // color = {} // :grey == enqueued, but not processed.  :black == processed.
        Set<IVertex> isGrey = new HashSet<>();
        Set<IVertex> isBlack = new HashSet<>();
        // parent = {}
        Map<IVertex,IVertex> parent = new HashMap<>();
        // q = queue.new
        Queue<IVertex> q = new ArrayDeque<>();
        // q.enqueue(this)
        q.add(this);
        isGrey.add(this);
        // numberOfHops[this] = 0
        numberOfHops.put(this, 0);
        // parent[this] = nil
        parent.put(this, null);
        //
        // while u = q.dequeue
        while (!q.isEmpty()) {
            IVertex u = q.remove();
        //  if !color[u] == :black
            if (!isBlack.contains(u)) {
        //      for v : q.siblings
                for (IVertex v : u.getNeighbors()) {
        //          if color[v] == :white
                    if (!isGrey.contains(v) && !isBlack.contains(v)) {
        //              parent[v] = u
                        parent.put(v, u);
        //              numberOfHops[v] = numberOfHops[u] + 1
                        numberOfHops.put(v, numberOfHops.get(u) + 1);
        //              color[v] = :grey
                        isGrey.add(v);
        //              q.eneuque(v)
                        q.add(v);
                    }
                }
            }
            isBlack.add(u);
        //   color[u] = :black
        }
        return numberOfHops;
    }

    public Map<IVertex,Integer> findDistancesBlah() {
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

    @Override
    public String toString() {
        return "V<" + this.name + ">";
    }
}
