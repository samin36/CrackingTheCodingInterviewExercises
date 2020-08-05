public class DeleteMiddleNode {

    public static void deleteNode(SinglyLinkedList.Node<Character> toRemove) {
        while (toRemove.next.next != null) {
            toRemove.data = toRemove.next.data;
            toRemove = toRemove.next;
        }
        toRemove.data = toRemove.next.data;
        toRemove.next = null;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Character> linkedList = new SinglyLinkedList();
        linkedList.addToBack('A');
        linkedList.addToBack('B');
        linkedList.addToBack('C');
        linkedList.addToBack('D');
        linkedList.addToBack('E');
        linkedList.addToBack('F');
        System.out.printf("Original: %s\n", linkedList);
        int i = 4;
        SinglyLinkedList.Node<Character> toRemove = linkedList.getNodeAtIndex(i);
        System.out.printf("After deleting %s: ", toRemove);
        deleteNode(toRemove);
        System.out.printf("%s\n", linkedList);
    }



}