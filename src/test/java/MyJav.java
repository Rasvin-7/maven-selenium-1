public class MyJav
{
    public static void main(String args[])
    {
//        StringBuilder rev_a, a = new StringBuilder("1234");
//        rev_a = a.reverse();
//        System.out.println(rev_a);
        String a = "1234";
        char[] rev_a = a.toCharArray();
        for(int i = rev_a.length-1; i>=0; i--)
        {
            System.out.print(rev_a[i]);

        }

    }
}
