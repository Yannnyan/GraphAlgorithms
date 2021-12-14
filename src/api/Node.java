package api;

import java.util.HashMap;
import java.util.Iterator;

public interface Node {

    public DataTypes.Node getParent();
    public DataTypes.Node left();
    public DataTypes.Node right();
    public DataTypes.Node copy();
    public Iterator<DataTypes.Node> childrenIterator();
}
