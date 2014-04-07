package CH.ifa.draw.framework;

import java.util.Collection;

public interface Subject {

	public void addToContainer(FigureChangeListener c);
    public void removeFromContainer(FigureChangeListener c);
    public FigureChangeListener listener();
    public void addFigureChangeListener(FigureChangeListener l);
    public void removeFigureChangeListener(FigureChangeListener l);

}
