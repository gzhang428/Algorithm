package algorithm.leetcode;

public class Multiply {

	public static void main(String[] args) {
		String res = new Multiply().multiply("0", "456");
		System.out.println(res);
	}
	public String multiply(String num1, String num2) {
        String s1 = new StringBuilder(num1).reverse().toString();
        String s2 = new StringBuilder(num2).reverse().toString();
        
        int[] res = new int[s1.length() + s2.length()];
        for (int i = 0; i < s1.length();i++){
            int a = (int)(s1.charAt(i) - '0');
            for (int j = 0; j < s2.length(); j++){
                 res[i + j] += a * (int)(s2.charAt(j) - '0');
            }
        }
        int carry = 0;
        for (int i = 0; i < res.length; i++){
             int sum = res[i] + carry;
             carry = sum / 10;
             res[i] = sum % 10;
        }
        StringBuilder sb = new StringBuilder();
        int i = res.length - 1;
        while(i >= 0 && res[i] == 0){
            i --;
        }
        if (i < 0){
            sb.append(0);
        }
        for (; i >=0; i--){
            sb.append(res[i]);
        }
        
        return sb.toString();
    }
	        
	        

}
