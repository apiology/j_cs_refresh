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

    private IVertex target;
    private int distance;
    private List<IVertex> path;

    /**
     * Does not change existing object; returns new one.
     */
    public GraphPath append(IVertex v, int additionalDistance) {
        int newTotalDistance = this.distance + additionalDistance;
        ArrayList<IVertex> newPath = new ArrayList<IVertex>(this.path);
        newPath.add(this.target);
        return new GraphPath(v, newTotalDistance, newPath);
    }

    public IVertex getTarget() {
        return target;
    }

    public int getDistance() {
        return distance;
    }

    public List<IVertex> getPath() {
        return path;
    }

    public GraphPath(IVertex target, int distance, Collection<IVertex> path) {
        this.target = target;
        this.distance = distance;
        this.path = new ArrayList<IVertex>(path);
    }

    public GraphPath(IVertex target, int distance, IVertex... path) {
        this.target = target;
        this.distance = distance;
        this.path = new ArrayList<IVertex>(Arrays.asList(path));
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
