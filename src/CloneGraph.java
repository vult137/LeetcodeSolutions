import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// 133. Clone Graph
public class CloneGraph {

    HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return copy(node);
    }

    public Node copy(Node node) {
        if (map.containsKey(node.val))
            return map.get(node.val);
        Node copy = new Node(node.val);
        map.put(copy.val, copy);
        for (Node neighbor: node.neighbors) {
            copy.neighbors.add(copy(neighbor));
        }
        return copy;
    }
}
