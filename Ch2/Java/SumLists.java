public class SumLists {



    public static SinglyLinkedList<Integer> sumListsBackwards(SinglyLinkedList<Integer> num1, SinglyLinkedList<Integer> num2) {
        int num1Val = getNumBackwards(num1.head, 0), num2Val = getNumBackwards(num2.head, 0);
        return constructSumList(num1Val + num2Val, true);   
    }

    public static SinglyLinkedList<Integer> sumListsForwards(SinglyLinkedList<Integer> num1, SinglyLinkedList<Integer> num2) {
        int num1Val = getNumForwards(num1.head), num2Val = getNumForwards(num2.head);
        return constructSumList(num1Val + num2Val, false);
    }

    public static int getNumForwards(SinglyLinkedList.Node<Integer> node) {
        int num = 0;
        while (node != null) {
            num *= 10;
            num += node.data;
            node = node.next;
        }
        return num;
    }

    public static int getNumBackwards(SinglyLinkedList.Node<Integer> node, int exponent) {
        int currVal = (int) (node.data * Math.pow(10, exponent));
        if (node.next != null) {
            return currVal + getNumBackwards(node.next, exponent + 1);
        } else {
            return currVal;
        }
    }
    
    public static SinglyLinkedList<Integer> constructSumList(int sum, boolean backwards) {
        SinglyLinkedList<Integer> sumList = new SinglyLinkedList<Integer>();
        while (sum > 0) {
            if (backwards) {
                sumList.addToBack(sum % 10);
            } else {
                sumList.addToFront(sum % 10);
            }
            sum /= 10;
        }
        return sumList;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> num1 = new SinglyLinkedList<Integer>();
        num1.addToBack(1);
        num1.addToBack(2);
        num1.addToBack(3);
        num1.addToBack(4);
        SinglyLinkedList<Integer> num2 = new SinglyLinkedList<Integer>();
        num2.addToBack(5);
        num2.addToBack(6);
        num2.addToBack(7);

        System.out.printf("Num1: %s\n", num1);
        System.out.printf("Num2: %s\n", num2);
        System.out.printf("Num1 + Num2: %s\n", sumListsBackwards(num1, num2));
        System.out.println();
        System.out.printf("Num1: %s\n", num1);
        System.out.printf("Num2: %s\n", num2);
        System.out.printf("Num1 + Num2: %s\n", sumListsForwards(num1, num2));
    }
}