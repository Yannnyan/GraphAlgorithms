package api;

/** This FibonaciHeap data structure should implement the famous FibonacciHeap
 * Description:
 * - Contains two pointer for each node with the same parent left, right from one to another, circular.
 * - Each child node has bigger value than its parent
 * - For each parent node, cannot remove two of its children
 * - each node holds 3 values int or generic comparable key, int degree, boolean marked
 * -
 *
 *
 *  pros:
 *  running time complexity efficient
 *  improves binary heap
 *  iterative implementation
 *
 *  cons:
 *  complex structure
 *
 *  questions rising from the Fibonacci heap:
 *  what are the differences between running times for large scale graphs for fibonacci heap compared to binary heap
 *
 * */
public interface FibonacciHeap<Node extends DataTypes.Node > {
    /** This function inserts with theta(1) time complexity
     *  inserts a new node as a root
     *
     * */
    public void insert(Node newNode);
    /** This function deletes the minimum node with theta(log(n)) time complexity
     *  Delete the minimum node, and make its children root nodes.
     *  then call Consolidate()
     *
     *
     * */
    public Node deleteMin();
    /** This function decreases the key of a certain number with theta(1)
     *  Decrease the Nodes key, if it does not violate the heap property then do nothing
     *  else detach this node with its children and make it a root
     *
     * */
    public void decreaseKey(Node node);
    /** This function merges two root nodes with the same degree with theta(log(n)) time complexity
     *  Suppose the maximum degree of the graph is D, then keep an array of length D.
     *  Go through its pointers with a pointer p
     *  Define the degree of current root as currDegree
     *  if array[currDegree] == null then array[currDegree] = current root
     *  else then decide who is the minimal value and attach the bigger one to the smaller one with its children
     *  do this for each root node
     *  This function is called after deleteMin()
     * */
    public void consolidate();
}
