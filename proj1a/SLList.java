package proj1a;
public class SLList{
    public class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int i,IntNode n){
            item = i;
            next = n;
        }

    }
    private int size;
    private IntNode first;

    public SLList(){
        first = null;
        size = 0;
    }

    public SLList(int x){
    first = new IntNode(x,null);
    size = 1;
}

public void addfirst(int x){
first = new IntNode(x,first);
size += 1;
}

public int getfirst(){
return first.item;
}

public void addlast(int x){

    if(first == null){
    first = new IntNode(x,null);
    return;
}

    IntNode p = first;
    while(p.next != null){
    p = p.next;
    }
    p.next = new IntNode(x,null);

size += 1;
}


public int size(){
        return size;

}





public static void main(String[] args){
SLList x = new SLList();
x.addlast(5);
x.addfirst(10);
x.addfirst(15);
x.addlast(30);
System.out.println(x.size());
System.out.print(x.getfirst());
}
}