package CH.ifa.draw.framework;

public interface Observer {

    public void figureChanged(FigureChangeEvent e);
    public void figureRemoved(FigureChangeEvent e);
    public void figureRequestRemove(FigureChangeEvent e);
    public void figureRequestUpdate(FigureChangeEvent e);
}
