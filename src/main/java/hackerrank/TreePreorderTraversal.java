package hackerrank;

import java.util.Stack;

/**
 * Created by Reshetuyk on 23.03.2017.
 */
public class TreePreorderTraversal {

    static class Node {

        Node(String data) {
            this.data = data;
        }

        String data;
        Node left;
        Node right;
    }

    void preOrder1(Node root) {
        Node pre;
        if (root == null)
            return;
        Node curr = root;
        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null && pre.right != curr)
                    pre = pre.right;
                if (pre.right == null) {
                    pre.right = curr;
                    System.out.print(curr.data + " ");
                    curr = curr.left;
                } else {
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
    }

    private int count;

    int preOrder2(Node root) {
        if(root == null){
            return count;
        }
        System.out.print(root.data + "; ");
        preOrder2 (root.left);
        preOrder2 (root.right);
        return ++count;
    }

    static class TraverseNode {
        Node node;
        boolean isLeftChecked;
        boolean isRightChecked;

        public TraverseNode(Node node) {
            this.node = node;
        }

        public TraverseNode(Node node, boolean isLeftChecked, boolean isRightChecked) {
            this.node = node;
            this.isLeftChecked = isLeftChecked;
            this.isRightChecked = isRightChecked;
        }
    }

    void preOrder3(Node root) {
        Stack<TraverseNode> stack = new Stack<>();
        stack.push(new TraverseNode(root));
        while (!stack.isEmpty()) {
            TraverseNode tCurNode = stack.peek();
            if (!tCurNode.isLeftChecked && !tCurNode.isRightChecked)
                System.out.print(tCurNode.node.data + " ");

            if (!tCurNode.isLeftChecked && tCurNode.node.left != null) {
                tCurNode.isLeftChecked = true;
                stack.push(new TraverseNode(tCurNode.node.left));
            } else if (!tCurNode.isRightChecked && tCurNode.node.right != null) {
                tCurNode.isRightChecked = true;
                stack.push(new TraverseNode(tCurNode.node.right));
            } else {
                stack.pop();
            }


        }
    }
}

