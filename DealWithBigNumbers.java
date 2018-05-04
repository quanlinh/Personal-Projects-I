import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DealWithBigNumbers {


        static BigInteger fibonacciModified(BigInteger t1, BigInteger t2, int n) {
            // Complete this function
            if(n < 0) throw new IllegalArgumentException("Numbers of element should not less than 0");
            BigInteger bigT1 = new BigInteger(String.valueOf(t1));
            BigInteger bigT2 = new BigInteger(String.valueOf(t2));
            if      (n == 1) return bigT1;
            else if (n == 2) return bigT2;
            else
            {
                for (int i = 2; i < n; i++)
                {
                    BigInteger temp = bigT1;
                    bigT1 = bigT2;
                    bigT2 = bigT2.multiply(bigT2);
                    bigT2 = temp.add(bigT2);
                }
            }
            return bigT2;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            BigInteger t1 = new  BigInteger(String.valueOf(in.nextInt()));
            BigInteger t2 = new  BigInteger(String.valueOf(in.nextInt()));
            int n = in.nextInt();
            BigInteger result = fibonacciModified(t1, t2, n);
            System.out.println(result);
            in.close();
        }


}
