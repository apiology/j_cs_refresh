package cc.broz.j_cs_refresh;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class EstimatedPath2 {
    private List<IVertex> path;
    private IVertex midpoint;
    private Map<IVertex,Integer> optimisticEstimatesToTarget;
    private int distanceToMidpoint;

    private EstimatedPath2(IVertex midpoint,
                           int distanceToMidpoint,
                           Map<IVertex,Integer> optimisticEstimatesToTarget,
                           List<IVertex> path) {
        this.midpoint = midpoint;
        this.distanceToMidpoint = distanceToMidpoint;
        this.optimisticEstimatesToTarget = optimisticEstimatesToTarget;
        this.path = path;
    }
    
    public EstimatedPath2(IVertex source,
                          Map<IVertex,Integer> optimisticEstimatesToTarget) {
        this(source, 0, optimisticEstimatesToTarget, new ArrayList<>(0));

    }

    public EstimatedPath2 append(IVertex midpoint, int distanceFromPrevious) {
        List<IVertex> newPath = new ArrayList<>(this.path);
        newPath.add(midpoint);
        return new EstimatedPath2(midpoint,
                                  this.distanceToMidpoint + distanceFromPrevious,
                                  optimisticEstimatesToTarget,
                                  newPath);
    }

    public Integer getOptimisticDistanceEstimate() {
        return this.distanceToMidpoint + optimisticEstimatesToTarget.get(this.midpoint);
    }

    public IVertex getMidpoint() {
        return this.midpoint;
    }

    public List<IVertex> getPath() {
        return this.path;
    }
}
