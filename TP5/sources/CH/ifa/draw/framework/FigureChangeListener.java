/*
 * @(#)FigureChangeListener.java 5.1
 *
 */

package CH.ifa.draw.framework;

import java.awt.Rectangle;
import java.util.EventListener;

/**
 * Listener interested in Figure changes.
 *
 */
public interface FigureChangeListener extends EventListener, Observer {

    /**
     *  Sent when an area is invalid
     */
    public void figureInvalidated(FigureChangeEvent e);


}
