import java.util.ArrayList;

public class MyJav
{
    public static void main(String args[])
    {
        ArrayList<String> myArrayL = new ArrayList<>();
        myArrayL.add("Array1");
        myArrayL.add("Array2");
//        System.out.println(myArrayL);
        for(String a : myArrayL)
        {
            System.out.println(a);
        }
        myArrayL.remove(1);
        System.out.println(myArrayL);
        System.out.println(myArrayL.indexOf("Array1"));
    }
}
