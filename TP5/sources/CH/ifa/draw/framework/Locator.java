/*
 * @(#)Locator.java 5.1
 *
 */

package CH.ifa.draw.framework;

import CH.ifa.draw.util.Storable;
import java.awt.*;
import java.io.Serializable;

/**
 * Locators can be used to locate a position on a figure.<p>
 */

public interface Locator extends Storable, Serializable, Cloneable {

    /**
     * Locates a position on the passed figure.
     * @return a point on the figure.
     */
    public Point locate(Figure owner);
}

