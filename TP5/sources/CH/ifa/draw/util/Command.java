/*
 * @(#)Command.java 5.1
 *
 */

package CH.ifa.draw.util;

import java.awt.*;
import java.util.*;

/**
 * Commands encapsulate an action to be executed. Commands have
 * a name and can be used in conjunction with <i>Command enabled</i>
 * ui components.
 */
public abstract class Command {

    private String  fName;

    /**
     * Constructs a command with the given name.
     */
    public Command(String name) {
        fName = name;
    }

    /**
     * Executes the command.
     */
    public abstract void execute();

    /**
     * Tests if the command can be executed.
     */
    public boolean isExecutable() {
        return true;
    }

    /**
     * Gets the command name.
     */
    public String name() {
        return fName;
    }
}
