/*
 * @(#)PointConstrainer.java 5.1
 *
 */

package CH.ifa.draw.framework;

import java.awt.*;

/**
 * Interface to constrain a Point. This can be used to implement
 * different kinds of grids.
 */


public interface PointConstrainer {
    /**
     * Constrains the given point.
     * @return constrained point.
     */
    public Point constrainPoint(Point p);

    /**
     * Gets the x offset to move an object.
     */
    public int getStepX();

    /**
     * Gets the y offset to move an object.
     */
    public int getStepY();

}
