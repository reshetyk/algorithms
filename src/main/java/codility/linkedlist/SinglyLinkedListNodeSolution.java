package codility.linkedlist;

public class SinglyLinkedListNodeSolution {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }


    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.println(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                System.out.println(sep);
            }
        }
    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        if (head == null)
            return new SinglyLinkedListNode(data);

        SinglyLinkedListNode node = head;
        while(node.next != null) {
            node = node.next;
        }
        node.next = new SinglyLinkedListNode(data);

        return head;

    }
}
