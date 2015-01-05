package cc.broz.j_cs_refresh;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class DijkstraSolver2 {
    IVertex start;
    public DijkstraSolver2(IVertex start) {
        this.start = start;
    }

    public Map<IVertex,GraphPath> findShortestPaths() {
        int assumedSize = 11;
        PriorityQueue<GraphPath> pq =
            new PriorityQueue<GraphPath>(assumedSize,
                                          (a, b) -> new Integer(a.getDistance())
                                                 .compareTo(new Integer(b.getDistance())));
        Map<IVertex, GraphPath> shortestPaths = new HashMap<>(assumedSize);
        Set<IVertex> fullyVisited = new HashSet<IVertex>(assumedSize);
        Map<IVertex, Integer> shortestKnownDistance = new HashMap<>(assumedSize);
        List<IVertex> emptyPath = new ArrayList<IVertex>(0);
        pq.add(new GraphPath(start, 0, emptyPath));
        while (!pq.isEmpty()) {
            GraphPath currentPath = pq.poll();
            IVertex current = currentPath.getTarget();
            if (!fullyVisited.contains(current)) {
                // this is the final shortest path for 'current'
                fullyVisited.add(current);
                shortestPaths.put(current, currentPath);
                int currentDistance = currentPath.getDistance();
                for (Map.Entry<IVertex, Integer> neighborAndDistance :
                         current.getNeighborsAndDistances().entrySet()) {
                    IVertex neighbor = neighborAndDistance.getKey();
                    int neighborDistance = neighborAndDistance.getValue();
                    if (!fullyVisited.contains(neighbor)) {
                        int proposedNewDistance = neighborDistance + currentDistance;
                        Integer existingNeighborDistance = shortestKnownDistance.get(neighbor);
                        if (existingNeighborDistance == null ||
                            proposedNewDistance < existingNeighborDistance) {
                            shortestKnownDistance.put(neighbor, proposedNewDistance);
                            List<IVertex> currentPathList = currentPath.getPath();
                            GraphPath neighborPath = currentPath.append(neighbor,
                                                                        neighborDistance);
                            pq.add(neighborPath);
                        }
                    }
                }
            }
        }
        
        return shortestPaths;
    }
}
