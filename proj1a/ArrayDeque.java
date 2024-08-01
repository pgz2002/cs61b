package proj1a;

public class ArrayDeque<Type> {
    private int size;
    private Type[] items;
    private int nextfirst;
    private int nextlast;

    private static final int INIT_CAPACITY = 8;

    public ArrayDeque() {
        items = (Type[]) new Object[INIT_CAPACITY];
        nextfirst = 0;
        nextlast = 1;
        size = 0;
    }
    public ArrayDeque(ArrayDeque other){
        items = (Type[]) new Object[other.items.length];
        other.nextfirst = nextfirst;
        other.nextlast = nextlast;
        other.size = size;
        System.arraycopy(other.items,0,items,0,other.items.length);
    }

    public void resize(int capacity){
        Type[] newitem = (Type[]) new Object[capacity];
        int currentindex = plusone(nextfirst);
        for(int i = 0;i < size;i++){
            newitem[i] = items[currentindex];
            currentindex = minusone(currentindex);
        }
        items = newitem;
        nextfirst = capacity - 1;
        nextlast = size;
    }

    public int minusone(int index){
        return (index - 1)%items.length;
    }

    public int plusone(int index){
        return (index - 1 + items.length)%items.length;
    }

    public void addfirst(Type x){
        if(size == items.length){
            resize(items.length * 2);
        }
        items[nextfirst] =  x;
        size = size + 1;
        nextfirst = minusone(nextfirst);
    }

    public void addlast(Type x){
        if(size == items.length){
            resize(items.length * 2);
        }
        items[nextlast] = x;
        nextlast = plusone(nextlast);
        size = size + 1;
    }

    public Type removefirst(){
        Type x = items[plusone(nextfirst)];
        nextfirst = plusone(nextfirst);
        if(items.length >= 16 && size < items.length/4){
            resize(items.length / 2);
        }
        return x;
    }

    public Type removelast(){
        Type x = items[minusone(nextlast)];
        nextlast = minusone(nextlast);
        if(items.length == 16 && size < items.length/4){
            resize(items.length / 2);
        }
        return x;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public Type get(int index){
        if(index < 0 || index >= size){
            return null;
        }
        int currentindex  = (index + plusone(nextfirst)) % items.length;
        return items[currentindex];
    }
}


