package onl9class;

import java.util.Scanner;

/**
 * Given a list of  integers, A and another integer b,  representing the expected sum. Select zero or more numbers from  such that the sum of these numbers is as near as possible, but not exceeding, to the expected sum ().

Note

Each element of  can be selected multiple times.
If no element is selected then the sum is 0.
Input Format

The first line contains  the number of test cases. 
Each test case comprises of two lines. First line contains two integers,  , representing the length of list  and expected sum, respectively. Second line consists of  space separated integers, , representing the elements of list .

Constraints 

Output Format

Output  lines, the maximum sum for each test case which is as near as possible, but not exceeding, to the expected sum (k).

Sample Input

2
3 12
1 6 9
5 9
3 4 4 4 8
Sample Output

12
9
Explanation

In the first test case, one can pick {6, 6}. In the second, we can pick {3,3,3}.

Submissions:11545
Max Score:60
Difficulty: Medium
Rate This Challenge:
More
Current Buffer (saved locally, editable)     

 * @author abhimanyu
 *
 */
public class UnboundedKnapsack {
	
	static Long calculateKnapsack(int totalCount,int[] items) {
		Long[] countArr= new Long[totalCount+1];
		for (int i = 0; i < countArr.length; i++) {
			countArr[i] = 0L;
		}
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i]);
		}
		System.out.println(totalCount +"  "+ items);
		for(int i = 1;i<=totalCount;i++) {
			for(int j=0;j<items.length;j++) {
				if(items[j]<= i) {
					Long prevPlus = countArr[i-items[j]]+items[j];
					System.out.println(i+" current "+countArr[i]+" prevPlus "+prevPlus);
					countArr[i] = Math.max(countArr[i], prevPlus);
				}
			}
		}
		return countArr[totalCount];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests =  sc.nextInt();
		long l = 5L;
		
		int itemCount, totalCount;
		int[] items ;
		for(int i=0;i<tests;i++) {
			itemCount=sc.nextInt();
			//System.out.println(itemCount);
			totalCount=sc.nextInt();
			//System.out.println(totalCount);
			items= new int[itemCount];
			for(int j=0;j<itemCount;j++) {
				items[j] = sc.nextInt();
			}
			System.out.println(calculateKnapsack(totalCount,items));
		
		}
	
	}
}
