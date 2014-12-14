package cc.broz.j_cs_refresh;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class EstimatedPath implements Comparable {
    private IVertex waypoint;
    private List<IVertex> pathSoFar;
    private int distanceSoFar;
    private int estimatedTotalDistanceToTarget;
    private Map<IVertex, Integer> optimisticEstimatesToTarget;

    public EstimatedPath(IVertex waypoint,
                         List<IVertex> pathSoFar,
                         int distanceSoFar,
                         Map<IVertex, Integer> optimisticEstimatesToTarget) {
        this.waypoint = waypoint;
        this.pathSoFar = pathSoFar;
        this.distanceSoFar = distanceSoFar;
        this.optimisticEstimatesToTarget = optimisticEstimatesToTarget;
        this.estimatedTotalDistanceToTarget = this.distanceSoFar +
            this.optimisticEstimatesToTarget.get(waypoint);
    }

    public IVertex getWaypoint() {
        return this.waypoint;
    }

    public List<IVertex> getPathSoFar() {
        return pathSoFar;
    }

    public int getEstimatedTotalDistanceToTarget() {
        return this.estimatedTotalDistanceToTarget;
    }

    public EstimatedPath append(IVertex nextWaypoint, int incrementalDistance) {
        ArrayList<IVertex> newPathSoFar =
            new ArrayList<IVertex>(this.pathSoFar);
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
