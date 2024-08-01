package proj1a;

public class SLList2 {
    public class IntNode{
        int item;
        IntNode next;
        public IntNode(int i,IntNode n){
            item = i;
            next = n;
        }
    }
    private IntNode sentinel;
    private int size;

    public SLList2(){
         sentinel = new IntNode(6,null);
        size = 0;
    }
    public SLList2(int x){
         sentinel = new IntNode(6,sentinel.next);
         sentinel.next = new IntNode(x,null);
        size = 1;
    }

    public void addfirst(int x){
        sentinel.next = new IntNode(x,sentinel.next.next);
        size += 1;
    }

    public int getfirst(){
        return sentinel.next.item;
    }

    public void addlast(int x) {
        IntNode p = sentinel;
        while(p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x,null);
        size += 1;
    }

    public int size(){
        return size;
    }

    public void main(String[] args){
        SLList2 x = new SLList2();
        x.addlast(99);
        x.addlast(98);
        x.addlast(97);
        x.getfirst();
        System.out.println(x.size());

    }



    }

