package cc.broz.j_cs_refresh;

import junit.framework.TestCase;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class GraphTest
    extends TestCase
{
    Vertex r;
    Vertex s;
    Vertex t;
    Vertex u;
    Vertex v;
    Vertex w;
    Vertex x;
    Vertex y;
    Vertex z;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GraphTest(String testName)
    {
        super(testName);
        r = new Vertex("r");
        s = new Vertex("s");
        t = new Vertex("t");
        u = new Vertex("u");
        v = new Vertex("v");
        w = new Vertex("w");
        x = new Vertex("x");
        y = new Vertex("y");
        z = new Vertex("z");

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

    public void testBFS() {
        Map<Vertex, Integer> expectedDistancesFromS =
            new HashMap<Vertex, Integer>(10);
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
                     s.findDistances());
    }

     public void testDFS() {
        Set<Vertex> allNodes = new HashSet();
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

    public GraphPath path(Vertex target, int distance, Vertex... path) {
        return new GraphPath(target, distance, path);
    }

    public void testDjisktrasAlgorithm() {
        Map<Vertex, GraphPath> bestPaths = new HashMap<Vertex, GraphPath>();
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
}
