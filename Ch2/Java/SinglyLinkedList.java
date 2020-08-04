public class SinglyLinkedList<T> {
    Node<T> head;
    Node<T> tail;

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void addToBack(T data) {
        Node<T> newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> curr = head;
        while (curr != null) {
            sb.append(curr.data).append(curr.next == null ? "" : " -> ");
            curr = curr.next;
        }
        return sb.toString();
    }
    
    static class Node<T> {
        Node<T> next;
        T data;
        
        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }


}