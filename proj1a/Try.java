package proj1a;

public class Try {

    public static void main(String[] args){
        int i = 1;
        while(i < 11){
           int p = 0;
           int x = 0;
            while(x < i){
               p = p + x;
               x++;
           }
            System.out.println(p);
            i++;
        }
    }
}
