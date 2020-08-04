import java.util.HashSet;
public class RemoveDuplicates {

    //Temporary Buffer Allowed
    public static void removeDuplicates(SinglyLinkedList<Character> linkedList) {
        HashSet<Character> seen = new HashSet<Character>(); //Could use char array as well
        SinglyLinkedList.Node<Character> curr = linkedList.head;
        seen.add(curr.data);
        while (curr != null && curr.next != null) {
            if (seen.contains(curr.next.data)) {
                curr.next = curr.next.next;
                continue;
            }
            seen.add(curr.next.data);
            curr = curr.next;
        }

    }

    //Temporary Buffer NOT Allowed
    public static void removeDuplicatesNoBuffer(SinglyLinkedList<Character> linkedList) {
        SinglyLinkedList.Node<Character> p1 = linkedList.head, p2;
        while (p1 != null) {
            p2 = p1;
            while (p2.next != null) {
                if (p2.next.data == p1.data) {
                    p2.next = p2.next.next;
                    continue;
                }
                p2 = p2.next;
            }
            p1 = p1.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList<Character> linkedList = new SinglyLinkedList();
        SinglyLinkedList<Character> linkedList2 = new SinglyLinkedList();
        for (int i = 0; i < 10; i++) {
            char c = (char) (Math.random() * 11 + 65);
            linkedList.addToBack(c);
            linkedList2.addToBack(c);
        }
        System.out.printf("Original: %s\n", linkedList);
        removeDuplicatesNoBuffer(linkedList);
        System.out.printf("No Buffer: %s\n", linkedList);
        removeDuplicates(linkedList2);
        System.out.printf("Buffer: %s\n", linkedList2);
    }




}