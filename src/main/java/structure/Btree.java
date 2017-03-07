package structure;

/**
 * Created by Reshetuyk on 07.08.2016.
 */
public class Btree<T extends Comparable> {
    private Node<T> root;

    public Btree add(T val) {
        if (root == null) {
            root = new Node("root");
            root.val = val;
            return this;
        }
        Node node = findNodeToAdd(val);
        node.val = val;
        return this;
    }

    public Node getRoot() {
        return root;
    }

    private Node findNodeToAdd(T val) {
        boolean isFound = false;
        Node node = root;
        while (!isFound) {
            if (val.compareTo(node.val) > 0) {
                if (node.bigger == null) {
                    node.bigger = new Node(node.path + "/bigger");
                    isFound = true;
                }
                node = node.bigger;
            } else {
                if (node.lower == null) {
                    node.lower = new Node(node.path + "/lower");
                    isFound = true;
                }
                node = node.lower;
            }
        }
        return node;
    }

    public Node<T> findNode(T val) {
        Node node = root;
        while (node != null) {
            if (val.compareTo(node.val) > 0) {
                node = node.bigger;
            } else if (val.compareTo(node.val) < 0) {
                node = node.lower;
            } else {
                return node;
            }
        }
        return null;
    }

    public void remove(T val) {
        Node<T> node = findNode(val);
        if (node == null) throw new RuntimeException("not found [" + val + "]");
        if (node.bigger == null && node.lower == null)
            node = null;
        Node<T> nodeCopy = node.bigger;
        if (node.bigger != null) {
            node = nodeCopy;
        }
        nodeCopy = null;
    }

//    @Override
//    public String toString() {
//        Node<T> node = root;
//        while (node != null) {
//            Node<T> first = node;
//            while (true) {
//                System.out.println(node.path);
//                if (node.lower != null) {
//                    node = node.lower;
//                }
//            }
//        }
//
//    }
}

class Node<T> {
    String path;
    T val;
    Node lower;
    Node bigger;

    Node(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
