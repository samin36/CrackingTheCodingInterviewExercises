public class Partition {
    

    public static SinglyLinkedList<Integer> partitionLinkedList(SinglyLinkedList<Integer> linkedList, int x) {
        SinglyLinkedList<Integer> beforeX = new SinglyLinkedList<Integer>();
        SinglyLinkedList<Integer> afterX = new SinglyLinkedList<Integer>();
        SinglyLinkedList.Node<Integer> lastInBeforeX = null;

        SinglyLinkedList.Node<Integer> curr = linkedList.head;
        while (curr != null) {
            if (curr.data < x) {
                lastInBeforeX = new SinglyLinkedList.Node<Integer>(curr.data);
                beforeX.addToBack(lastInBeforeX);
            } else {
                afterX.addToBack(curr.data);
            }
            curr = curr.next;
        }

        if (lastInBeforeX != null) {
            lastInBeforeX.next = afterX.head;
            return beforeX;
        } else {
            return linkedList;
        }
    }


    public static void main(String[] args) {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();

        int x = 0;
        for (int i = 0; i < 8; i++) {
            int val = (int) (Math.random() * 10);
            linkedList.addToBack(val);
            if (Math.random() < 0.5) {
                x = val;
            }
        }

        System.out.printf("Original: %s\n", linkedList);
        System.out.printf("Partitioned at %d: %s\n", x, partitionLinkedList(linkedList, x));
    }
}