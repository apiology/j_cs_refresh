package cc.broz.j_cs_refresh;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.List;

public interface IVertex {
    public void addBidirectionalEdge(IVertex other, int distance);
    public void addEdge(IVertex other, int distance);
    public Map<IVertex, Integer> getNeighborsAndDistances();
    public Collection<IVertex> getNeighbors();
    public Map<IVertex, Integer> findNumberOfHops();
    public Set<IVertex> findAllVertices();
    public Map<IVertex, GraphPath> findShortestPaths();
    public List<IVertex> bestPath(IVertex targetVertex,
                                  Map<IVertex, Integer> optimisticEstimatesToTarget);
    
}
