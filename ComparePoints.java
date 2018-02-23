import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ComparePoints {

    static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2){
        // Complete this function
        // Alice follow by Bob
        int[] comparePoints = new int[2];
        if (a0 >  b0) {
            comparePoints[0] = 1;
        } else if(a0 < b0) {
            comparePoints[1] = 1;
        }
        if(a1 > b1) {
            comparePoints[0] = comparePoints[0]+1;
        } else if(a1 < b1 ) {
            comparePoints[1] = comparePoints[1] + 1;
        }
        if(a2 > b2) {
            comparePoints[0] = comparePoints[0] + 1;
        } else if(a2 < b2){
            comparePoints[1] = comparePoints[1] + 1;
        }
        return comparePoints;

    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int a0 = in.nextInt();
//        int a1 = in.nextInt();
//        int a2 = in.nextInt();
//        int b0 = in.nextInt();
//        int b1 = in.nextInt();
//        int b2 = in.nextInt();
//        int[] result = solve(a0, a1, a2, b0, b1, b2);
        int[] result1 = solve(2, 2, 2, 3, 3, 3);

        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + (i != result1.length - 1 ? " " : ""));
        }
        System.out.println("");


    }
}