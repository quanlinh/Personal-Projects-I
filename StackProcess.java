import java.util.Stack;

public class StackProcess {
    /*
    This function checking whether a parentheses is valid
     */
    public boolean isValid(String s) {
        Stack<Character> p = new Stack<>();
        if(s.length() == 1) return false;

        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[' ) {
                p.push(c);
            } else {
                if(!p.isEmpty()) {
                    char cPlus = p.pop();
                    if ( (cPlus  == '(' && c == ')')
                            || (cPlus == '[' && c == ']' )
                            || (cPlus == '{' && c == '}'))
                        continue;
                    else return false;
                } else {
                    return false;
                }


            }
        }
        // did not count for edge Cases such as "(("
        // extra condition to test is to make invariant of stack empty
        if(!p.isEmpty()) return false;
        return true;
    }
}

