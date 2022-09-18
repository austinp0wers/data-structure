package dataStructure.core.list;

public class LinkedList {
    private SinglyLinkedNode head;

    public int get(int index){
        if(head == null){
            return -1;
        }
        int count = 0;
        SinglyLinkedNode temp = head;
        for(int i = 0; i < index; i++){
            if(temp.next == null){
                return -1;
            }
            temp = temp.next;
        }
//        while(temp.next != null){
//            if(count == index) {
//                return temp.value;
//            }
//            count += 1;
//            temp = temp.next;
//        }
        return temp.value;
    }

    public void addAtHead(int value){
        if(head == null){
            head = new SinglyLinkedNode(value);
            return;
        }
        SinglyLinkedNode newHead = new SinglyLinkedNode(value);
        newHead.next = head;
        head = newHead;
    }

    public void addAtTail(int value){
        if(head == null){
            head = new SinglyLinkedNode(value);
            return;
        }
        SinglyLinkedNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new SinglyLinkedNode(value);
    }

    public void addAtIndex(int index, int value){
        SinglyLinkedNode temp = head;
        for(int i = 0; i < index; i++){
            if(temp.next == null) {
                return;
            }
            temp = temp.next;
        }
        SinglyLinkedNode change = temp.next;
        SinglyLinkedNode newNode = new SinglyLinkedNode(value);
        temp.next = newNode;
        newNode.next = change;
    }

    public void deleteAtIndex(int index){
        SinglyLinkedNode temp = head;
        for(int i = 0; i < index; i++){
            if(temp.next == null){
                return;
            }
            temp = temp.next;
        }

        SinglyLinkedNode prev = head;
        for(int j = 0; j < index-1; j++){
            prev = prev.next;
        }
        prev.next = temp.next;
    }
}
