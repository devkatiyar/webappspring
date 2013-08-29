package com.springsecurity;

//you can also use imports, for example:
//import java.math.*;
class Solution {
	public static int solution(int[] A) {
		// write your code here...
		if (A == null)
			return Integer.MIN_VALUE;

		int length = A.length;

		int majorIndex = 0;

		int count = 1;
		for (int i = 0; i < length; i++) {
			if (A[majorIndex] == A[i])
				count++;
			else
				count--;

			if (count == 0) {
				majorIndex = i;
				count = 1;
			}
		}
		return A[majorIndex];
	}

	public static int complementary(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] + array[j] == array.length)
					count++;
			}
		}
		return count;
	}

	public static void main(String args[]) {

		int A[] = { 1, 4, -1, 3, 2 };
		// System.out.println(solution(A));
		// System.out.println(complementary(A));
		//System.out.println(solution(-4, 1, 2, 6, 0, -1, 4, 3));
		
		System.out.println(area_intersection(-4, 1, 2, 6, 0, -1, 4, 3));
		// bitwiseMultiply(5,7);
	}
	//  K = -4    L = 1      M = 2     N = 6    
	 // P = 0     Q = -1     R = 4     S = 3    

///////////////
	public static int  area_intersection(int blx1, int bly1, int trx1,int  try1, int blx2, int bly2,int  trx2,int  try2){
		int base = 0, height = 0, area = 0;
	
		if (blx2>=blx1 && blx2<=trx1){
			if (bly2>=bly1 && bly2<=try1){
	if (trx2<=trx1 && trx2>=blx1){
	base = trx2 - blx2;
	height = try2 - bly2;
	area = base * height;
	}
	else{
	base = trx1 - blx2;
	height = try1 - bly2;
	area = base * height;
	}
		}
		}
	//end

		else if( bly1>=bly2 && bly1<=try2){
	base = trx1 - blx2;
	height = try1 - bly1;
	area = base * height;
		}
	//end

		else if (bly2>=bly1 && bly2<=try1){
	if( blx1>=blx2 && blx1<=trx2){
	base = trx1 - blx1;
	height = try2 - bly2;
	area = base * height;
	}
		}
	//end

		else if (blx1>=blx2 && blx1<=trx2){
	     if( bly1>=bly2 && bly1<=try2){
	base = trx1 - blx1;
	height = try1 - bly1;
	area = base * height;
	     }
	if( trx2>=blx1 && trx2<=trx1){
	base = trx2 - blx1;
	height = try2 - bly1;
	area = base * height;
	}
		}
	//end

		else if (bly2>=bly1 && bly2<=try1){
	base = trx1 - blx2;
	height = try1 - bly1;
	area = base * height;
		}
	//end

		//else if(trx1 - blx2)==0 || (try1 - bly1)==0 || !(trx1>blx2 and trx2>trx1 && bly2<=bly1){
	//area = 0
		//}
	//end
	 
	//if( area && area<=2147483647 )
	//area
	//else
	//-1
	//end

		return area;
	}
	////////////////
	public static long solution(int K, int L, int M, int N, int P, int Q, int R,
			int S) {
		long base = 0, height = 0, area = 0;
		if (P >= K && P <= M) {
			if (Q >= L && Q <= N) {
				if (R <= M && R >= K) {
					base = R - P;
					height = S - Q;
					area = base * height;
				} else{
					base = M - P;
				height = N - Q;
				area = base * height;
				}

			}
		}

			else if (L >= Q && L <= S) {
				base = M - P;
				height = N - L;
				area = base * height;
			} 
			else if (Q >= L && Q <= N) {
				if (K >= P && K <= R)
					base = M - K;
				height = S - Q;
				area = base * height;
			}
			// end

			else if (K >= P && K <= R) {
				if (L >= Q && L <= S)
					base = M - K;
				height = N - L;
				area = base * height;
				if (R >= K && R <= M)
					base = R - K;
				height = S - L;
				area = base * height;
			}

			// end
			else if (Q >= L && Q <= N) {
				base = M - P;
				height = N - L;
				area = base * height;
			}
			// end
	 else if ((M - P) == 0 || (N - L) == 0 || !(M > P && R > M && Q <= L)){
			area = 0;
	 }

		if (area <= 2147483647)
			return area;
		else
			return -1;
		
		
		

	}

	public static void bitwiseMultiply(int n1, int n2) {
		int a = n1, b = n2, result = 0;
		while (b != 0) // Iterate the loop till b==0
		{
			if ((b & 01) != 0) // Logical ANDing of the value of b with 01
			{
				result = result + a; // Update the result with the new value of
										// a.
			}
			a <<= 1; // Left shifting the value contained in 'a' by 1.
			b >>= 1; // Right shifting the value contained in 'b' by 1.
		}
		System.out.println("=========" + result);
	}

}
