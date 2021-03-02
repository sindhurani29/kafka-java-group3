public class Main {
  
	public static void main(String[] args){
		System.out.println("Printing the first 15 narcissistic decimal numbers");
		for(long n = 0, ctr = 0; ctr < 15; n++){
			if(is_narc_dec_num(n)){
				System.out.print(n + " ");
				System.out.println();
				ctr++;
			}
		}
		System.out.println();
	}
    public static boolean is_narc_dec_num(long n){
		if(n < 0) return false;
    
		String str1 = Long.toString(n);
		int x = str1.length();
		long sum_num = 0;
    
		for(char c : str1.toCharArray()){
			sum_num += Math.pow(Character.digit(c, 10), x);
			
		}
		return sum_num == n;
	}
 	

}