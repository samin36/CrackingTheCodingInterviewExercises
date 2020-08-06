public class Palindrome {

    static class DummyNode {
        SinglyLinkedList.Node<Character> node;
        DummyNode(SinglyLinkedList.Node<Character> node_) {
            node = node_;
        }
    }

    public static boolean isPalindrome(SinglyLinkedList<Character> linkedList) {
        SinglyLinkedList.Node<Character> slowPointer = linkedList.head, fastPointer = linkedList.head;
        while (fastPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next == null ? null : fastPointer.next.next;
        }
        //Now, slowPointer is at the middle node
        return slowPointer == null ? true : isPalindromeHelper(new DummyNode(linkedList.head), slowPointer);
    }

    public static boolean isPalindromeHelper(DummyNode start, SinglyLinkedList.Node<Character> mid) {
        boolean res;
        if (mid.next != null) {
            res = isPalindromeHelper(start, mid.next) && start.node.data == mid.data;    
        } else {
            res = start.node.data == mid.data;
        }
        start.node = start.node.next;
        return res; 
    }

    public static void main(String[] args) {
        SinglyLinkedList<Character> linkedList;
        String[] testWords = {"madam", "racecar","108012", "ll", "1805081", "hello"};
        for (String word : testWords) {
            linkedList = new SinglyLinkedList();
            for (char c  : word.toCharArray()) {
                linkedList.addToBack(c);
            }
            System.out.printf("%s is%sa palindrome\n", word, isPalindrome(linkedList) ? " " : " NOT ");
        }
    }

}   