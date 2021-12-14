package DataStructures;

import api.FibonacciHeap;
import api.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class fibonacciHeap implements api.FibonacciHeap {
    /** keyToValues is used to map Nodes to an index inside the fib heap */
    HashMap<Integer,DataTypes.Node> keyToValue;
    ArrayList<api.Node> fibHeap;
    private int nextID=0;
    private Integer minIndex;
    /** Creates empty fibonacciHeap*/
    public fibonacciHeap(){
        minIndex = null;
        keyToValue = new HashMap<>();
        fibHeap = new ArrayList<>();
    }
    /** Initializes fibonnaciHeap from iterable collection of nodes */
    public fibonacciHeap(Iterable<DataTypes.Node> collection){
        minIndex = null;
        keyToValue = new HashMap<>();
        fibHeap = new ArrayList<>();
        Iterator<DataTypes.Node> iterator = collection.iterator();
        while(iterator.hasNext()) {
            DataTypes.Node node = iterator.next();
            insert(node);
        }
    }
    @Override
    public void consolidate() {

    }

    @Override
    public void insert(DataTypes.Node node) {
        // if the values is null then the heap is empty
        if(minIndex == null)    minIndex = Integer.valueOf(0);
        else if(minIndex > node.key)     minIndex = node.key;
        keyToValue.put(Integer.valueOf(nextID++), node);
        fibHeap.add(node);
    }

    @Override
    public DataTypes.Node deleteMin() {
        if(fibHeap.size() == 1){
            minIndex = null;
        }

        return null;
    }

    @Override
    public void decreaseKey(DataTypes.Node num) {

    }
}
