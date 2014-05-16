package cc.broz.j_cs_refresh;

import junit.framework.TestCase;

import java.util.Map;
import java.util.HashMap;

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
        r = new Vertex();
        s = new Vertex();
        t = new Vertex();
        u = new Vertex();
        v = new Vertex();
        w = new Vertex();
        x = new Vertex();
        y = new Vertex();
        z = new Vertex();

        v.addBidirectionalEdge(r);
        r.addBidirectionalEdge(s);
        s.addBidirectionalEdge(w);
        w.addBidirectionalEdge(t);
        w.addBidirectionalEdge(x);
        t.addBidirectionalEdge(x);
        t.addBidirectionalEdge(u);
        x.addBidirectionalEdge(y);
        y.addBidirectionalEdge(u);
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

}
