#include <iostream>

#include "SinglyLinkedList.h"

void deleteNode(Node<char>* toRemove) {
    while (toRemove->next->next != NULL) {
        toRemove->data = toRemove->next->data;
        toRemove = toRemove->next;
    }
    toRemove->data = toRemove->next->data;
    toRemove->next = NULL;
}

int main() {
    SinglyLinkedList<char>* linkedList = new SinglyLinkedList<char>();
    for (int i = 65; i < 72; i++) {
        linkedList->addToBack(i);
    }

    std::cout << "Original: " << *linkedList << std::endl;
    int i = 4;
    Node<char>* toRemove = linkedList->getNodeAtIndex(i);
    std::cout << "After deleting " << *toRemove;
    deleteNode(toRemove);
    std::cout << ": " << *linkedList << std::endl;

    return 0;
}