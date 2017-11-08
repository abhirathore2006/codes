package onl9class;

import java.util.Arrays;

/**
 * 
 * 
Christy is interning at HackerRank. One day she has to distribute some chocolates to her colleagues. She is biased towards her friends and may have distributed the chocolates unequally. One of the program managers gets to know this and orders Christy to make sure everyone gets equal number of chocolates.

But to make things difficult for the intern, she is ordered to equalize the number of chocolates for every colleague in the following manner,

For every operation, she can choose one of her colleagues and can do one of the three things.

She can give one chocolate to every colleague other than chosen one.
She can give two chocolates to every colleague other than chosen one.
She can give five chocolates to every colleague other than chosen one.
Calculate minimum number of such operations needed to ensure that every colleague has the same number of chocolates. 


Soltuin => min ( making all numbers
 * @author abhimanyu
 *
 */
public class EqualChocolates {
	
	
	public static int makeEqual2(int[] choc) {
		Arrays.sort(choc);
		int size =choc.length-1;
		int[][] equal = new int[choc.length][3];
		int[] delta = new int[] {choc[0],choc[0]-1,choc[0]-2};
		for(int i=0;i<choc.length;i++) {
			for(int k=0;k<3;k++) {
				int diff = choc[i]-delta[k];
				equal[i][k]= (i>0?equal[i-1][k]:0) + (diff>0?getMin(diff):0);
				
			}
		}
		return (int)Math.min(equal[size][0],Math.min(equal[size][1],equal[size][2]));
	}
	public static int getMin(int n) {
		int min,rem ;
		min=(int) Math.floor(n/5);
		rem = n %5;
		min+= (int)Math.floor(rem/2) + rem%2;
		return min;
	}
	

	public static void main(String[] args) {
		//System.out.println(makeEqual2(new int[] {2,5,5,5,5,5}));
		//System.out.println(makeEqual2(new int[] {2,2,3,7}));
		System.out.println(makeEqual2(new int[] {53,361,188,665,786,898,447,562,272,123,229,629,670,848,994,54,822,46,208,17,449,302,466,832,931,778,156,39,31,777,749,436,138,289,453,276,539,901,839,811,24,420,440,46,269,786,101,443,832,661,460,281,964,278,465,247,408,622,638,440,751,739,876,889,380,330,517,919,583,356,83,959,129,875,5,750,662,106,193,494,120,653,128,84,283,593,683,44,567,321,484,318,412,712,559,792,394,77,711,977,785,146,936,914,22,942,664,36,400,857}));
	}
}
