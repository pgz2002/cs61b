package proj1a;

public class LinkedListDeque<type> {
    private int size;
    private Node sentinel;
    public class Node{
        type item;
        Node prev;
        Node next;
        public Node(type i,Node p,Node n){
            item = i;
            prev = p;
            next = n;
        }
    }
    public LinkedListDeque(){
        sentinel = new Node(null,null,null);
        size = 0;
    }
    public LinkedListDeque(type x){
        sentinel = new Node(null,null,null);
        sentinel.next = new Node(x,null,null);
        sentinel.prev = new Node(x,null,null);
        size = 2;
    }

    public void addfirst(type x){
        Node p = new Node(x,null,null);
        p.next = sentinel.next;
        p.prev = sentinel;
        if(sentinel.next != null){
            sentinel.next.prev = p;
        }
        sentinel.next = p;
        size += 1;
    }

    public void addlast(type x){
        Node p = new Node(x,null,null);
        p.prev = sentinel.prev;
        p.next = sentinel;
        if(sentinel.prev != null){
            sentinel.prev.next = p;
        }
        sentinel.prev = p;
        size += 1;
    }

    public boolean isEmpty(){
        return sentinel.next == null;}

    public type removefirst() {
        if(sentinel.next == null){
            return null;
        }
        Node a = sentinel.next;
        sentinel.next = a.next;
        size -= 1;
        return a.item;
    }
    public type removelast(){
        if(sentinel.prev == null){
            return null;
        }
        Node b = sentinel.prev;
        sentinel.prev = b.prev;
        size -= 1;
        return b.item;
    }

    public void printDeque(){
        if(sentinel.next == null){
            System.out.print("null");
            return;
        }
        Node p = sentinel.next;
        int m = 0;
        while(p != null && size >= 1){
            System.out.print("get(m)" + " ");
            m++;
            size--;
            p = p.next;
        }
    }

    public type getfirst(){
        return sentinel.next.item;
    }

    public type getlast(){
        return sentinel.prev.item;
    }

    public type get(int index){
        if(index == 0){
            return sentinel.next.item;
        }
        Node p = sentinel.next.next;
        while(index > 1 && p.next != null){
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    public type getRecursive(int index){

    }

    public int size(){
        return size;
    }
}


