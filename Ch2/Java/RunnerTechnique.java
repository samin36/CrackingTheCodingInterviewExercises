public class RunnerTechnique {

    public static void alternateLinkedList(SinglyLinkedList<String> linkedList) {
        SinglyLinkedList.Node<String> fastPointer = linkedList.head, slowPointer = linkedList.head;
        while (fastPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        //Now, slowPointer is pointing to the node in the middle
        
        fastPointer = linkedList.head; //Reset fastPointer to the head


        SinglyLinkedList.Node<String> p1, p2;
        while (slowPointer != null) {
            p1 = fastPointer;
            p2 = slowPointer;
            fastPointer = p1.next;
            slowPointer = p2.next;
            p1.next = p2;
            p2.next = slowPointer == null ? null : fastPointer;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList();
        linkedList.addToBack("a1");
        linkedList.addToBack("a2");
        linkedList.addToBack("a3");
        linkedList.addToBack("b1");
        linkedList.addToBack("b2");
        linkedList.addToBack("b3");
        System.out.println(linkedList);
        alternateLinkedList(linkedList); //Should change it to: a1 -> b1 -> a2 -> b2 -> a3 -> b3
        System.out.println(linkedList);
    }

}