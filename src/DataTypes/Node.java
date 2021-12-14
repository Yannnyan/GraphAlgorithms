package DataTypes;

import java.util.ArrayList;
import java.util.Iterator;

public class Node implements api.Node {
    public Integer key = 0;
    public int degree = 0;
    public boolean marked = false;
    private Node left,right,parent;
    private ArrayList<Node> childrenNodes;
    public Node(){
        this.left = null;this.right = null;this.parent = null;childrenNodes = new ArrayList<>();
    }

    @Override
    public Node getParent() {
        return this.parent;
    }

    @Override
    public Node left() {
        return this.left;
    }

    @Override
    public Node right() {
        return this.right;
    }

    @Override
    public Node copy() {
        Node nodeCopy = new Node();
        return null;
    }

    @Override
    public Iterator<Node> childrenIterator() {
        return this.childrenNodes.iterator();
    }
}
