package leetcode.AddBinary;

public class AddBinary {

    public static void main(String[] args) {
        addBinary("1010", "101");
    }

    public static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = a.length()-1 , j = b.length()-1, carry = 0;
        while (i>=0||j>=0){
            int sum = carry;
            if(i>=0)sum += a.charAt(i--) - '0'; ////we subtract '0' to get the int value of the char from the ascii
            if(j>=0)sum += b.charAt(j--) - '0';
            sb.append(sum%2);
            carry = sum/2;
        }
        if(carry!=0) sb.append(carry); //adding remaining carry to sum
        return sb.reverse().toString();

    }
}
