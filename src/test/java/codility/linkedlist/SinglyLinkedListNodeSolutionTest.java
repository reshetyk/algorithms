package codility.linkedlist;

import org.junit.Test;

public class SinglyLinkedListNodeSolutionTest {

    @Test
    public void insertNodeAtTailTest() {
        SinglyLinkedListNodeSolution.SinglyLinkedListNode head = SinglyLinkedListNodeSolution.insertNodeAtTail(null, 5);
        head = SinglyLinkedListNodeSolution.insertNodeAtTail(head, 4);
        head = SinglyLinkedListNodeSolution.insertNodeAtTail(head, 3);
        //5 -> null
        //5 -> 4 -> null
        //5 -> 4 -> 3 -> null

        SinglyLinkedListNodeSolution.printSinglyLinkedList(head, "->");

    }
}