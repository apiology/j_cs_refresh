package cc.broz.j_cs_refresh;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Graph2Test
    extends BaseGraphTest
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Graph2Test(String testName)
    {
        super(testName);
    }

    @Override
    protected void initVertices() {
        r = new Vertex2("r");
        s = new Vertex2("s");
        t = new Vertex2("t");
        u = new Vertex2("u");
        v = new Vertex2("v");
        w = new Vertex2("w");
        x = new Vertex2("x");
        y = new Vertex2("y");
        z = new Vertex2("z");
    }
}
