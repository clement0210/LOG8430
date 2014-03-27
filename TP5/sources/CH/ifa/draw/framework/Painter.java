/*
 * @(#)Painter.java 5.1
 *
 */

package CH.ifa.draw.framework;

import java.awt.*;
import java.io.Serializable;

/**
 * Painter defines the interface for drawing a layer
 * into a DrawingView.<p>
 */

public interface Painter extends Serializable {

    /**
     * Draws into the given DrawingView.
     */
    public void draw(Graphics g, DrawingView view);

}
