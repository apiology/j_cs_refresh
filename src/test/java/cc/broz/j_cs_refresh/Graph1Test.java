package cc.broz.j_cs_refresh;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Graph1Test
    extends BaseGraphTest
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Graph1Test(String testName)
    {
        super(testName);
    }

    @Override
    protected void initVertices() {
        r = new Vertex("r");
        s = new Vertex("s");
        t = new Vertex("t");
        u = new Vertex("u");
        v = new Vertex("v");
        w = new Vertex("w");
        x = new Vertex("x");
        y = new Vertex("y");
        z = new Vertex("z");
    }
}
