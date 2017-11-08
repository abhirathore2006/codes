package onl9class;


import java.util.Scanner;

/**
 * 69 29
   25 27 40 38 17 2 28 23 9 43 18 49 15 24 19 11 1 39 32 16 35 30 48 34 20 3 6 13 44
   
   101768
 * @author abhimanyu
 *
 */
public class CoinExchange {

    static long getWays(long n, long[] c){
        int size = (int)n +1;
        long[][] ways = new long[size][c.length+1];
        for(int k=0;k<=c.length;k++) {
        	ways[0][k]=1;
        }
        for(int i=0;i<size;i++){
            for(int j=1;j<=c.length;j++){
                if(c[j-1]<=i){
                	//System.out.println(ways[(int)(i-c[j])]>0?ways[(int)(i-c[j])]*(n/c[j]));
                    ways[i][j]= ways[i][j-1]+ways[(int)(i-c[j-1])][j];
                }else {
                	ways[i][j]= ways[i][j-1];
                }
            }
        }
        return ways[size-1][c.length];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
}
