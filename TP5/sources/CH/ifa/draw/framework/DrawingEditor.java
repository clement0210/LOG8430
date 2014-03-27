/*
 * @(#)DrawingEditor.java 5.1
 *
 */

package CH.ifa.draw.framework;

import java.awt.*;

/**
 * DrawingEditor defines the interface for coordinating
 * the different objects that participate in a drawing editor.
 */
public interface DrawingEditor {

    /**
     * Gets the editor's drawing view.
     */
    DrawingView view();

    /**
     * Gets the editor's drawing.
     */
    Drawing     drawing();

    /**
     * Gets the editor's current tool.
     */
    Tool        tool();

    /**
     * Informs the editor that a tool has done its interaction.
     * This method can be used to switch back to the default tool.
     */
    void        toolDone();

    /**
     * Informs that the current selection has changed.
     * Override this method to handle selection changes.
     */
    void        selectionChanged(DrawingView view);

    /**
     * Shows a status message in the editor's user interface
     */
    void        showStatus(String string);

}
