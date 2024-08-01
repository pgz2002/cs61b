package proj1a;

public class SLList3<type> {
    private Node sentinel;
    private int size;

    public class Node {
        type item;
        Node next;

        public Node(type i, Node n) {
            item = i;
            next = n;
        }
    }

    public SLList3() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public SLList3(type x) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
        size = 1;
    }

    public type getfirst() {
        return sentinel.next.item;
    }

    public void addfirst(type x) {
        Node first = sentinel.next;
        Node p = new Node(x, first);
        sentinel.next = p;
        size += 1;
    }

    public void addlast(type x) {
        Node p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(x, null);
        size += 1;
    }

    public Node getlastNode(){
        Node p = sentinel;
        while(p.next != null){
            p = p.next;
        }
        return p;
    }

    public type getlast(){
        Node p = getlastNode();
        return p.item;
    }

    public type removelast(){
        Node last = getlastNode();
        if(last == sentinel){
            return null;
        }
        Node p = sentinel;
        while(p.next != last){
            p = p.next;
        }
        p.next = null;
        size = size - 1;
        return last.item;
    }

    public type removefirst(){
        if(sentinel.next == null){
            return null;
        }
        Node p = sentinel.next;
        sentinel.next = p.next;
        size -= 1;
        return p.item;
    }

    public type get(int index) {
        if (index == 0) {
            return getfirst();
        }
        Node p = sentinel.next.next;
        while(index > 1 && p.next != null){
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    public int size(){
        return size;
    }

    public void insert(type item,int index){
        if(sentinel.next == null || index == 0){
            addfirst(item);
            return;
        }
        Node p = sentinel.next.next;
        while(index > 1 && p.next != null){
            p = p.next;
            index -= 1;
        }

        Node q = new Node(item,p.next);
        p.next = q;
    }
}
