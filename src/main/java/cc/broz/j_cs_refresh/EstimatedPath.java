package cc.broz.j_cs_refresh;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class EstimatedPath implements Comparable {
    private Vertex waypoint;
    private List<Vertex> pathSoFar;
    private int distanceSoFar;
    private int estimatedTotalDistanceToTarget;
    private Map<Vertex, Integer> optimisticEstimatesToTarget;

    public EstimatedPath(Vertex waypoint,
                         List<Vertex> pathSoFar,
                         int distanceSoFar,
                         Map<Vertex, Integer> optimisticEstimatesToTarget) {
        this.waypoint = waypoint;
        this.pathSoFar = pathSoFar;
        this.distanceSoFar = distanceSoFar;
        this.optimisticEstimatesToTarget = optimisticEstimatesToTarget;
        this.estimatedTotalDistanceToTarget = this.distanceSoFar +
            this.optimisticEstimatesToTarget.get(waypoint);
    }

    public Vertex getWaypoint() {
        return this.waypoint;
    }

    public List<Vertex> getPathSoFar() {
        return pathSoFar;
    }

    public int getEstimatedTotalDistanceToTarget() {
        return this.estimatedTotalDistanceToTarget;
    }

    public EstimatedPath append(Vertex nextWaypoint, int incrementalDistance) {
        ArrayList<Vertex> newPathSoFar =
            new ArrayList<Vertex>(this.pathSoFar);
        newPathSoFar.add(nextWaypoint);
        return new EstimatedPath(nextWaypoint,
                                 newPathSoFar,
                                 this.distanceSoFar + incrementalDistance,
                                 this.optimisticEstimatesToTarget);
    }

    public int compareTo(Object other) {
        EstimatedPath otherEstimatedPath = (EstimatedPath)other;
        Integer thisDistance = getEstimatedTotalDistanceToTarget();
        Integer thatDistance =
            otherEstimatedPath.getEstimatedTotalDistanceToTarget();
        return thisDistance.compareTo(thatDistance);
    }
}
