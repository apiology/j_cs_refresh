package cc.broz.j_cs_refresh;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;

public class AStarSolver {
    private IVertex start;
    private IVertex target;
    private Map<IVertex, Integer> optimisticEstimatesToTarget;
    private PriorityQueue<EstimatedPath> pq;

    public AStarSolver(IVertex start,
                       IVertex target,
                       Map<IVertex, Integer> optimisticEstimatesToTarget) {
        this.start = start;
        this.target = target;
        this.optimisticEstimatesToTarget = optimisticEstimatesToTarget;
        this.pq = new PriorityQueue<EstimatedPath>();
        this.pq.add(new EstimatedPath(start,
                                      new ArrayList<IVertex>(),
                                      0,
                                      optimisticEstimatesToTarget));
    }

    public List<IVertex> bestPath() {
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
        IVertex waypoint = ep.getWaypoint();
        List<IVertex> pathSofar = ep.getPathSoFar();
        for (Map.Entry<IVertex, Integer> item :
                 waypoint.getNeighborsAndDistances().entrySet()) {
            IVertex neighbor = item.getKey();
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
