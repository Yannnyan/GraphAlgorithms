package DataStructures;

import api.FibonacciHeap;
import api.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class fibonacciHeap implements api.FibonacciHeap {
    /** keyToValues is used to map Nodes to an index inside the fib heap */
    HashMap<Integer,DataTypes.Node> keyToValue;
    /** rootKeyToValue is used to map root Nodes and get their index from the  */
    HashMap<Integer,DataTypes.Node> rootKeyToValue;
    ArrayList<api.Node> rootNodes;
    ArrayList<api.Node> fibHeap;
    private int nextID=0,rootNextID =0, D = 0;
    private Integer minIndex;
    /** Creates empty fibonacciHeap*/
    public fibonacciHeap(){
        minIndex = null;
        keyToValue = new HashMap<>();
        fibHeap = new ArrayList<>();
        rootNodes = new ArrayList<>();

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
        DataTypes.Node treeNodes[] = new DataTypes.Node[D];
        /** for each node check the array, if its null then init the spot in the array
         *  else, check which tree node is the minimal and attach the maximal to the minimal
         * */
        for (int i = 0; i < rootNodes.size(); i++) {
            // P
            DataTypes.Node currentNode = (DataTypes.Node) rootNodes.get(i);
            int curDegree = currentNode.degree;
            if(treeNodes[curDegree] == null){
                treeNodes[curDegree] = currentNode;
            }
            else
            {
                treeNodes[curDegree] = treeNodes[curDegree].key < currentNode.key ?
                        treeNodes[curDegree] : currentNode;
            }
        }
    }

    @Override
    public void insert(DataTypes.Node node) {
        // if the values is null then the heap is empty
        if(minIndex == null)    minIndex = Integer.valueOf(0);
        else if(minIndex > node.key)     minIndex = node.key;
        keyToValue.put(Integer.valueOf(nextID++), node);
        rootKeyToValue.put(Integer.valueOf(rootNextID), node);
        fibHeap.add(node);
        rootNodes.add(node);

    }

    @Override
    public DataTypes.Node deleteMin() {
        if(fibHeap.size() == 1){
            minIndex = null;
        }
        DataTypes.Node minNode = rootKeyToValue.get(minIndex);

        return null;
    }

    @Override
    public void decreaseKey(DataTypes.Node num) {

    }

    @Override
    public String toString() {
        return "fibonacciHeap{}";
    }
}
