public class SinglyLinkedList<T> {
    Node<T> head;
    Node<T> tail;

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void addToBack(T data) {
        Node<T> newNode = new Node(data);
        addToBack(newNode);
    }

    public void addToBack(Node<T> newNode) {
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addToFront(T data) {
        Node<T> newNode = new Node(data);
        addToFront(newNode);
    }

    public void addToFront(Node<T> newNode) {
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public Node<T> getNodeAtIndex(int index) {
        Node<T> curr = head;
        int i = 0;
        while (i != index) {
            i++;
            curr = curr.next;
        }
        return curr;
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
            next = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }

        public void setNext(Node<T> nextNode) {
            next = nextNode;
        }
    }


}