import java.util.ArrayList;
import java.util.List;

public class StringProcessing {
    public String reverseString(String s) {
        StringBuilder reverseString = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reverseString.append(s.charAt(i));
        }
        String res = reverseString.toString();
        return res;
    }


    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 && i % 5 == 0 && i != 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add("" + i);
            }
        }
        return res;
    }

}
