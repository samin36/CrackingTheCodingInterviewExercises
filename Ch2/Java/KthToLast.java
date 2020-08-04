public class KthToLast {


    public static Character getKthLastElement(SinglyLinkedList<Character> linkedList, int k) {
        SinglyLinkedList.Node<Character> curr = linkedList.head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        int stopAt = length - k;
        int i = 0;
        curr = linkedList.head;
        while (i != stopAt) {
            i++;
            curr = curr.next;
        }
        return curr.data;
    }

    public static int getKthLastElementHelper(SinglyLinkedList.Node<Character> curr, int k, int count, char[] ans) {
        int totalLength = count;
        if (curr.next != null) {
            totalLength = getKthLastElementHelper(curr.next, k, count + 1, ans);
        }
        if (count + k - 1 == totalLength) {
            ans[0] = curr.data;
        }
        return totalLength;
    }
    
    public static Character getKthLastElementRecursive(SinglyLinkedList<Character> linkedList, int k) {
        char[] ans = new char[1];
        getKthLastElementHelper(linkedList.head, k, 0, ans);
        return ans[0];
    }

    public static void main(String[] args) {
        SinglyLinkedList<Character> linkedList = new SinglyLinkedList();
        for (int i = 65; i < 75; i++) {
            linkedList.addToBack((char) i);
        }
        System.out.printf("Original: %s\n", linkedList);
        for (int k = 1; k <= 10; k++) {
        System.out.printf("%dth to the last element is: %c\n", k, getKthLastElement(linkedList, k));
        System.out.printf("%dth to the last element recursively is: %c\n", k, getKthLastElementRecursive(linkedList, k));
        }
    }
}