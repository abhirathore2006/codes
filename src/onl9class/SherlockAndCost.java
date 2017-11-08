package onl9class;

/** • Array B containing elements B1, B2,..., Bn is provided as input.
• Elements A1, A2,.., An for array A has to be decided by the coder/code. An element Ai can be any integer such that 1 <= Ai <= Bi.
• Select elements for array A such that it maximizes S (sum of difference between consecutive elements of A).
• Output required : the maximized value S.
e.g. input 10 1 10 1 10 
output -> 36 ; selected values  10 1 10 1 10  => |10-1|+|1-10|+|10-1|+|1-10|

DP[i][minOf I]= max( DP[i+1][minOf I+1 ], DP[i+1][Maxof I+1]+Diff of maximum value of i+1 - minimum value of i)
DP[i][maxOf I]= max( modOf ( maximum value of i+1 - maximum  value of i ) + DP[i+1][MaxOf I+1] , maximum value of I - minimum value of I+1 + DP[i+1][min Of I+1]) 

 SOLUTION  max(DP[0][max Of O], DP[0][min of O])
 * 
 * @author abhimanyu
 *
 */
public class SherlockAndCost {
	
	public static int getMaxDiff(int[] nums) {
		int[][] max = new int[nums.length][4];
		
		for(int i=nums.length-2;i>=0;i--) {
			max[i][0] = Math.max( max[i+1][0],nums[i+1]-1+max[i+1][1]);
			max[i][1] = Math.max( Math.abs(nums[i+1]-nums[i])+max[i+1][1],nums[i]-1+max[i+1][0]);
		}
		return Math.max(max[0][0],max[0][1]);
	}
	public static void main(String[] args) {
		System.out.println(getMaxDiff(new int[] {10,1,10,1,10}));
	}
}
