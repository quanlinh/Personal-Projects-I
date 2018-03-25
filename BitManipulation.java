public class BitManipulation {
    public String addBinary(String a, String b) {
        int lenStringA = a.length();
        int lenStringB = b.length();
        StringBuilder rs = new StringBuilder();
        if(lenStringA > lenStringB ) {
            boolean carry = false;
            for(int i = 0; i < lenStringA; i++) {
                char charA = a.charAt(i);
                if(i < lenStringB) {
                    char charB = b.charAt(i);
                    if     ( charA == charB && charA == '1' && charB == '1')  {
                        if   (carry)  {
                            rs.append("1");
                            carry = false;
                        } else { rs.append("0");
                            carry = true;
                        }
                    } else if ( charA == charB && charA == '0' && charB == '0')  {
                        if   (carry) {
                            rs.append("1");
                            carry = false;
                        } else {
                            rs.append("0");
                            carry = false;
                        }
                    }   else {
                        if (carry) {
                            rs.append("0");
                            carry = true;
                        }else {
                            rs.append("1");
                            carry = false;
                        }

                    }

                } else  {
                    if(carry && charA == '1')  {
                        rs.append("0");
                        carry = true;
                    } else {
                        rs.append("1");
                        carry = false;
                    }



                }

            }
            return rs.toString();


        } else {
            boolean carry = false;
            for(int i = 0; i < lenStringB; i++) {
                char charB = b.charAt(i);
                if(i < lenStringA) {
                    char charA = a.charAt(i);
                    if     ( charA == charB && charA == '1' && charB == '1')  {

                        if   (carry)  {
                            rs.append("1");
                            carry = false;
                        } else { rs.append("0");
                            carry = true;
                        }
                    } else if ( charA == charB && charA == '0' && charB == '0')  {
                        if   (carry) {
                            rs.append("1");
                            carry = false;
                        } else {
                            rs.append("0");
                            carry = false;
                        }
                    }   else {
                        if (carry) {
                            rs.append("0");
                            carry = true;
                        }else {
                            rs.append("1");
                            carry = false;
                        }

                    }

                } else  {
                    if(carry && charB == '1')  {
                        rs.append("0");
                        carry = true;
                    } else {
                        rs.append("1");
                        carry = false;
                    }



                }

            }

            return rs.toString();

        }

    }


}
