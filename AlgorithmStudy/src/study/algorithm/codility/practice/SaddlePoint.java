package study.algorithm.codility.practice;

/**
 * saddle point 개수 return  
 * 가운데 값이 행 양옆 값보다 작고, 열 위아래 값보다 클 때
 * OR
 * 가운데 값이 행 양옆 값보다 크고, 열 위아래 값보다 작을 때
 * 
 * @since 2020-02-10
 * @author joy.seo
 *
 */
public class SaddlePoint {
	public static void main(String[] args) {
		int[][] A = {{0,1,9,3},{7,5,8,3},{9,2,9,4},{4,6,7,1}};
		
		/*for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[i].length; j++) {
				System.out.print("A["+i+"]["+j+"] = " + A[i][j] +" ");
			}
			System.out.println();
		}*/
		System.out.println(solution(A));
	}
	
	/**
	 * @param A[][]
	 * @return saddle point 개수
	 */
	public static int solution(int[][] A) {
		int saddlePointCnt = 0;
		int point = 0;
		int row = 0;
		int col	= 0;
		
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[i].length; j++) {
				// 양옆/위/아래 값이 없는 경우 skip
				if(i==0 || j==0 || i==A.length-1 || j==A[i].length-1)
					continue;
				// 기준 점
				point = A[i][j];
				// 행에 대한 값 비교
				row = compareValue(point, A[i-1][j], A[i+1][j]);
				// 열에 대한 값 비교
				col = compareValue(point, A[i][j-1], A[i][j+1]);
				
				if((row==1 && col ==2) || (row==2 && col ==1))
					saddlePointCnt += 1;
			}
		}
		
		return saddlePointCnt;
	}
	
	// point가 val1, val2 보다 큰지, 작은지 검사하는 메소드
	public static int compareValue(int point, int val1, int val2) {
		if(point > val1 && point > val2) // 클 때
			return 1;
		else if(point < val1 && point < val2) // 작을 때
			return 2;
		else 
			return 3; // 암것도 아닐 때
	}
}
