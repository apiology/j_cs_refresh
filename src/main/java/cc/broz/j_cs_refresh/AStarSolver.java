package cc.broz.j_cs_refresh;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;

public class AStarSolver {
    private Vertex start;
    private Vertex target;
    private Map<Vertex, Integer> optimisticEstimatesToTarget;
    private PriorityQueue<EstimatedPath> pq;

    public AStarSolver(Vertex start,
                       Vertex target,
                       Map<Vertex, Integer> optimisticEstimatesToTarget) {
        this.start = start;
        this.target = target;
        this.optimisticEstimatesToTarget = optimisticEstimatesToTarget;
        this.pq = new PriorityQueue<EstimatedPath>();
        this.pq.add(new EstimatedPath(start,
                                      new ArrayList<Vertex>(),
                                      0,
                                      optimisticEstimatesToTarget));
    }

    public List<Vertex> bestPath() {
        while (!pq.isEmpty()) {
            EstimatedPath ep = pq.poll();
            EstimatedPath result = processCurrentBestEstimated(ep);
            if (result != null) {
                return result.getPathSoFar();
            }
        }
        return null;
    }


    private EstimatedPath processCurrentBestEstimated(EstimatedPath ep) {
        Vertex waypoint = ep.getWaypoint();
        List<Vertex> pathSofar = ep.getPathSoFar();
        for (Map.Entry<Vertex, Integer> item :
                 waypoint.getNeighborsAndDistances().entrySet()) {
            Vertex neighbor = item.getKey();
            int incrementalDistance = item.getValue();
            EstimatedPath pathThroughNeighbor =
                ep.append(neighbor, incrementalDistance);
            if (neighbor == this.target) {
                return pathThroughNeighbor;
            } else {
                this.pq.add(pathThroughNeighbor);
            }
        }
        return null;
    }
}
