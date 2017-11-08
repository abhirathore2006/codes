package onl9class;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * Output Format
 * A single line which is the number of candies in the box Result % 10^9+7
 * 
 * Sample Input 0

16
Sample Output 0

23
Explanation 0

The substring of number 16 are 16, 1 and 6. Whose sum is 23.

Sample Input 1

123
Sample Output 1

164
Explanation 1

The sub-strings of 123 are 1, 2, 3, 12, 23, 123 which sums to 164.

Solution:

Consider an example with string "6789" to understand the logic. The sub-strings of "6789" are 6, 7, 8, 9, 67, 78, 89, 678, 789, 6789.
Now, sub-string "789" can be expressed as 700 + 80 + 9. If all the substrings are expressed in similar way, we just need to know position and frequency of each digit in all the substrings combined, to get the total sum.
For substring "6789", we have :
        Frequency in substrings at positions
Digit   Unit    Ten     Hundred     Thousand        Sum
6       1       1       1           1           = 6*1*1111
7       2       2       2                       = 7*2*111
8       3       3                               = 8*3*11
9       4                                       = 9*4*1
This example gives the insight that for a string of length n,
 contribution by a digit x at position k will be : x* k* 11..1(n-k+1 times '1').

Translating the same for the above code. Loop runs through all the digits :
f takes values 1, 11, 111, 1111 ... (and so on)
s[i] is the digit x as discussed in above example.
i+1 is the position k.

 * @author abhimanyu
 *
 */
public class SamANdSubstring {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		
		URL url = SamANdSubstring.class.getResource("SamAndsubstringinput.txt");
		File file = new File(url.getPath());
		BufferedReader br = null;
		FileReader fr = null;
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		String[] s= br.readLine().split("");
				//br.readLine();
		long res =0; //result value
	    long f = 1; //f will be 1,11,111,1111...etc
		long MOD = 1000000007;
		for(int i = s.length-1; i >= 0; i--) {
			long x = Long.valueOf(s[i]);
		    res = (res + (x*f*(i+1))) % MOD;
		    f = (f*10+1) % MOD;
		}
		System.out.println(res);
	}

}
