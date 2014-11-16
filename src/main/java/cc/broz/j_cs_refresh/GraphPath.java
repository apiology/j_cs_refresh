package cc.broz.j_cs_refresh;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Immutable path from an implicit source to the target 'target',
 * taking up a total distance of 'distance', whose intermediate
 * vertices are listed as 'path'.
 */
public class GraphPath implements Comparable {

    private Vertex target;
    private int distance;
    private List<Vertex> path;

    /**
     * Does not change existing object; returns new one.
     */
    public GraphPath append(Vertex v, int additionalDistance) {
        int newTotalDistance = this.distance + additionalDistance;
        ArrayList<Vertex> newPath = new ArrayList<Vertex>(this.path);
        newPath.add(this.target);
        return new GraphPath(v, newTotalDistance, newPath);
    }

    public Vertex getTarget() {
        return target;
    }

    public int getDistance() {
        return distance;
    }

    public List<Vertex> getPath() {
        return path;
    }

    public GraphPath(Vertex target, int distance, Collection<Vertex> path) {
        this.target = target;
        this.distance = distance;
        this.path = new ArrayList<Vertex>(path);
    }

    public GraphPath(Vertex target, int distance, Vertex... path) {
        this.target = target;
        this.distance = distance;
        this.path = new ArrayList<Vertex>(Arrays.asList(path));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (this.getClass() != other.getClass()) {
            return false;
        } else {
            GraphPath otherGraphPath = (GraphPath)other;
            return
                this.target == otherGraphPath.target &&
                this.distance == otherGraphPath.distance &&
                this.path.equals(otherGraphPath.path);
        }
    }

    public int compareTo(Object other) {
        GraphPath otherGraphPath = (GraphPath)other;
        return new Integer(this.distance)
            .compareTo(new Integer(otherGraphPath.distance));
    }

    public String toString() {
        return "P<" + this.distance + "," + this.path + ">";
    }
}
