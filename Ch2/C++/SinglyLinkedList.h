#ifndef SINGLYLINKEDLIST_H
#define SINGLYLINKEDLIST_H

#include <iostream>
#include <sstream>
#include <string>

template <typename T>
class Node {
   public:
    Node* next;
    T data;

    Node(T data);
    ~Node();

    template <typename J>
    friend std::ostream& operator<<(std::ostream& strm, const Node<J>& node);
};

template <typename T>
class SinglyLinkedList {
   public:
    Node<T>* head;
    Node<T>* tail;
    SinglyLinkedList();
    bool isEmpty() const;
    void addToBack(T data);
    void addToBack(Node<T>* newNode);
    void addToFront(T data);
    void addToFront(Node<T>* newNode);
    Node<T>* getNodeAtIndex(int index);

    template <typename J>
    friend std::ostream& operator<<(std::ostream& strm, const SinglyLinkedList<J>& linkedList);
};

template <typename T>
Node<T>::Node(T data) {
    this->data = data;
    this->next = nullptr;
}

template <typename T>
Node<T>::~Node() {
    delete this->next;
}

template <typename T>
std::ostream& operator<<(std::ostream& strm, const Node<T>& node) {
    strm << node.data;
    return strm;
}

template <typename T>
SinglyLinkedList<T>::SinglyLinkedList() {
    head = 0;
    tail = 0;
}

template <typename T>
bool SinglyLinkedList<T>::isEmpty() const {
    return head == 0 && tail == 0;
}

template <typename T>
void SinglyLinkedList<T>::addToBack(T data) {
    Node<T>* newNode = new Node<T>(data);
    addToBack(newNode);
}

template <typename T>
void SinglyLinkedList<T>::addToBack(Node<T>* newNode) {
    if (isEmpty()) {
        head = newNode;
        tail = newNode;
    } else {
        tail->next = newNode;
        tail = newNode;
    }
}

template <typename T>
void SinglyLinkedList<T>::addToFront(T data) {
    Node<T>* newNode = new Node<T>(data);
    addToFront(newNode);
}

template <typename T>
void SinglyLinkedList<T>::addToFront(Node<T>* newNode) {
    if (isEmpty()) {
        head = newNode;
        tail = newNode;
    } else {
        newNode->next = head;
        head = newNode;
    }
}

template <typename T>
Node<T>* SinglyLinkedList<T>::getNodeAtIndex(int index) {
    Node<T>* curr = head;
    int i = 0;
    while (i != index) {
        i++;
        curr = curr->next;
    }
    return curr;
}

template <typename T>
std::ostream& operator<<(std::ostream& strm, const SinglyLinkedList<T>& linkedList) {
    std::stringstream ss;
    Node<T>* curr = linkedList.head;
    while (curr != nullptr) {
        ss << curr->data << (curr->next == nullptr ? "" : " -> ");
        curr = curr->next;
    }
    strm << ss.str();
    return strm;
}

#endif