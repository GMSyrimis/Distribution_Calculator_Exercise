import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by c4q-george on 4/1/15.
 */
public class LinearSearch {

    public static int search(ArrayList<Integer> alist,int x){
        return alist.indexOf(x);
    }

    public static void main(String[] args){

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(5);
        list.add(19);

        System.out.println(search(list,5));
    }
}
