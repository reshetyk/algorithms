package structure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BtreeTest {

    @Test
    public void testAdd() throws Exception {
        Btree<Integer> btree = new Btree();
        btree.add(30);
        Node root = btree.getRoot();
        assertEquals(30, root.val);
        btree.add(5);
        assertEquals(5, root.lower.val);
        btree.add(40);
        assertEquals(40, root.bigger.val);
        btree.add(34);
        assertEquals(34, root.bigger.lower.val);
        btree.add(100);
        assertEquals(100, root.bigger.bigger.val);
        btree.add(60);
        assertEquals(60, root.bigger.bigger.lower.val);
        btree.add(80);
        assertEquals(80, root.bigger.bigger.lower.bigger.val);
//        System.out.println(root.path);

        assertEquals("root/bigger/bigger/lower", btree.findNode(60).path);

        btree.remove(40);
        System.out.println();
    }
}