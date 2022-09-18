package dataStructure.core.list;

public class DoublyLinkedList {
    private DoublyLinkedNode head = null;
    private DoublyLinkedNode tail = null;
    private int size = 0;

    public DoublyLinkedList(int size){
        this.size = size;
    }
    public void addAtHead(int value){
        if(head == null){
            DoublyLinkedNode newHead = new DoublyLinkedNode(value);
            head = newHead;
            tail = newHead;
            size ++;
            return;
        }
        DoublyLinkedNode newHead = new DoublyLinkedNode(value);
        newHead.prev = head.prev;
        newHead.next = head;
        head.prev = newHead;
        tail.next = newHead;
        head = newHead;
        size ++;
    }

    public void addAtTail(int value){
        if(head == null){
            DoublyLinkedNode cur = new DoublyLinkedNode(value);
            head = cur;
            tail = cur;
            size ++;
            return;
        }
        DoublyLinkedNode cur = new DoublyLinkedNode(value);
        cur.prev = tail;
        cur.next = tail.next;
        tail.next = cur;
        head.prev = cur;
        tail = cur;
        size ++;
    }

    public void addAtIndex(int index, int value){
        if(head == null){
            DoublyLinkedNode cur = new DoublyLinkedNode(value);
            head = cur;
            tail = cur;
            size ++;
            return;
        }
        DoublyLinkedNode pointer = head;
        for(int i = 0; i < size; i++){
            if( i == index){
                DoublyLinkedNode cur = new DoublyLinkedNode(value);
                cur.next = pointer.next;
                cur.prev = pointer;
                pointer.next = cur;
                size ++;
                return;
            }
            pointer = pointer.next;
        }
    }

    public int printNode(int index){
        DoublyLinkedNode pointer = head;
        for(int i = 0; i < size; i++){
            if(i == index){
                return pointer.current;
            }
            pointer = pointer.next;
        }
        return -1;
    }

    public void deleteNode(int index){
        if(size == 0 ){
            return;
        }
        DoublyLinkedNode pointer = head;
        for(int i = 0; i < size; i++){
            if(i == index){
                pointer.next.prev = pointer.prev;
                pointer.prev.next = pointer.next;
                pointer.next = null;
                pointer.prev = null;
                size --;
                return;
            }
            pointer = pointer.next;
        }
    }

    public int getSize(){
        return this.size;
    }
}
