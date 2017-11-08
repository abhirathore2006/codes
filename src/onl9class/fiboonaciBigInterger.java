package onl9class;

import java.math.BigInteger;
import java.util.Scanner;

public class fiboonaciBigInterger {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        BigInteger t1 = sc.nextBigInteger();
        BigInteger t2 = sc.nextBigInteger();
        BigInteger t3 = new BigInteger("0");
        int n = sc.nextInt() -2;
        while(n>0){
            t3 = t1.add(t2.multiply(t2)) ;
            t1 = t2;
            t2 = t3;
            n--;
        }
        System.out.println(t3);
	}
}
