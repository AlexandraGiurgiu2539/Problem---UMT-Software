import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        ArrayList<Integer> a = new ArrayList<>();
        Problem problem = new Problem(a);
        Scanner in = new Scanner(System.in);

        System.out.println("Insert array length: ");
        int len = in.nextInt();

        for (int i = 0;i < len;i++){
            System.out.println("Insert element " + (i+1) +": ");
            a.add(in.nextInt());
        }

        System.out.println(problem.checkSplit());
    }
}
