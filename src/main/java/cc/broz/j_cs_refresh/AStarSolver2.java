package cc.broz.j_cs_refresh;

import java.util.Map;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;

public class AStarSolver2 {
    private IVertex source;
    private IVertex target;
    private Map<IVertex,Integer> optimisticEstimatesToTarget;
    
    public AStarSolver2(IVertex source,
                        IVertex target,
                        Map<IVertex,Integer> optimisticEstimatesToTarget) {
        this.source = source;
        this.target = target;
        this.optimisticEstimatesToTarget = optimisticEstimatesToTarget;
    }
    public List<IVertex> bestPath() {
        return bestPath(10);
    }
    
    public List<IVertex> bestPath(int estimatedGraphSize) {
        PriorityQueue<EstimatedPath2> pq =
            new PriorityQueue<>(estimatedGraphSize,
                                (a, b) -> Integer.valueOf(a.getOptimisticDistanceEstimate()).compareTo(Integer.valueOf(b.getOptimisticDistanceEstimate())));
        pq.add(new EstimatedPath2(source,
                                  this.optimisticEstimatesToTarget));
        Set<IVertex> visited = new HashSet<>(estimatedGraphSize);
        while (!pq.isEmpty()) {
            EstimatedPath2 currentPath = pq.poll();
            IVertex current = currentPath.getMidpoint();
            for (Map.Entry<IVertex, Integer> entry :
                     current.getNeighborsAndDistances().entrySet()) {
                IVertex neighbor = entry.getKey();
                int distanceFromCurrentToNeighbor = entry.getValue();
                EstimatedPath2 neighborPath =
                    currentPath.append(neighbor, distanceFromCurrentToNeighbor);
                if (neighbor.equals(target)) {
                    return neighborPath.getPath();
                } else {
                    pq.add(neighborPath);
                }
            }
        }
        throw new IllegalStateException("Couldn't find neighbor!");
    }

}
