package cc.broz.j_cs_refresh;

import junit.framework.TestCase;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public abstract class BaseGraphTest extends TestCase {
    IVertex r;
    IVertex s;
    IVertex t;
    IVertex u;
    IVertex v;
    IVertex w;
    IVertex x;
    IVertex y;
    IVertex z;

    public BaseGraphTest(String testName)
    {
        super(testName);
        initVertices();
        v.addBidirectionalEdge(r, 3);
        r.addBidirectionalEdge(s, 2);
        s.addBidirectionalEdge(w, 5);
        w.addBidirectionalEdge(t, 1);
        w.addBidirectionalEdge(x, 9);
        t.addBidirectionalEdge(x, 2);
        t.addBidirectionalEdge(u, 7);
        x.addBidirectionalEdge(y, 1);
        y.addBidirectionalEdge(u, 3);
    }

    protected abstract void initVertices();

    public void testBFS() {
        Map<IVertex, Integer> expectedDistancesFromS =
            new HashMap<IVertex, Integer>(10);
        expectedDistancesFromS.put(s, 0);
        expectedDistancesFromS.put(r, 1);
        expectedDistancesFromS.put(v, 2);
        expectedDistancesFromS.put(r, 1);
        expectedDistancesFromS.put(s, 0);
        expectedDistancesFromS.put(w, 1);
        expectedDistancesFromS.put(t, 2);
        expectedDistancesFromS.put(x, 2);
        expectedDistancesFromS.put(u, 3);
        expectedDistancesFromS.put(y, 3);

        assertEquals(expectedDistancesFromS,
                     s.findNumberOfHops());
    }

     public void testDFS() {
        Set<IVertex> allNodes = new HashSet<IVertex>();
        allNodes.add(r);
        allNodes.add(s);
        allNodes.add(t);
        allNodes.add(u);
        allNodes.add(v);
        allNodes.add(w);
        allNodes.add(x);
        allNodes.add(y);
        assertEquals(s.findAllVertices(), allNodes);
    }

    public GraphPath path(IVertex target, int distance, IVertex... path) {
        return new GraphPath(target, distance, path);
    }

    public void testDjisktrasAlgorithm() {
        Map<IVertex, GraphPath> bestPaths = new HashMap<IVertex, GraphPath>();
        bestPaths.put(r, path(r, 2, s));
        bestPaths.put(s, path(s, 0));
        bestPaths.put(t, path(t, 6, s, w));
        bestPaths.put(u, path(u, 12, s, w, t, x, y));
        bestPaths.put(v, path(v, 5, s, r));
        bestPaths.put(w, path(w, 5, s));
        bestPaths.put(x, path(x, 8, s, w, t));
        bestPaths.put(y, path(y, 9, s, w, t, x));
        assertEquals(bestPaths, s.findShortestPaths());
    }

    @SafeVarargs
    public static <T> List<T> list(T... t) {
        return Arrays.asList(t);
    }

    public void testBestPath() {
        Map<IVertex,Integer> optimisticEstimatesToY =
            new HashMap<IVertex, Integer>();
        optimisticEstimatesToY.put(v, 3);
        optimisticEstimatesToY.put(r, 2);
        optimisticEstimatesToY.put(s, 2);
        optimisticEstimatesToY.put(w, 2);
        optimisticEstimatesToY.put(t, 1);
        optimisticEstimatesToY.put(x, 1);
        optimisticEstimatesToY.put(u, 1);
        optimisticEstimatesToY.put(y, 0);

        List<IVertex> actualPath = list(w, t, x, y);
        List<IVertex> calculatedPath = s.bestPath(y, optimisticEstimatesToY);
        assertEquals(actualPath, calculatedPath);
    }
}
