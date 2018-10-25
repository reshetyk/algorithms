package hackerrank;

import org.junit.Test;

import static hackerrank.TreePreorderTraversal.Node;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TreePreorderTraversalTest {

    @Test
    public void testPreOrder2() throws Exception {
        TreePreorderTraversal treePreorderTraversal = new TreePreorderTraversal();

        Node root = new Node("1");
        root.left = new Node("1.1");
        root.right = new Node("1.2");
        root.left.left = new Node("1.1.1");
        root.left.right = new Node("1.1.2");
        root.right.left = new Node("1.2.1");

        assertThat(treePreorderTraversal.preOrder2(root), is(6));
    }
}