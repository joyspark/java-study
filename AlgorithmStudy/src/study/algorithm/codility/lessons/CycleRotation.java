package study.algorithm.codility.lessons;

/**
 * 코딜리티 lessons 2
 * 
 * intput ⇒ int를 가진 배열A와 양의 정수 K
 * K 만큼 배열 안의 데이터를 오른쪽으로 한칸씩 이동, 
 * 맨 오른쪽의 데이터는 맨 왼쪽으로 오게됨.
 * (단, 배열의 개수와 K는 0~100 사이)
 * 
 * @since 2020-01-15
 * @author joy.seo
 */
public class CycleRotation {

	public static void main(String[] args) {
		int[] A = {1,2};
		int K = 5;
		
		int[] result = solution(A, K);
		for(int a : result)
			System.out.println(a);
	}
	
	/**
	 * 
	 * @param A
	 * @param K
	 * @return
	 */
	public static int[] solution(int[] A, int K) {
		int len = A.length;
		int temp = 0;
		
		// 빈 배열일 때, 예외처리
		if(len == 0)
			return new int[0];
		
		for(int i=0; i<K; i++) {
			// 1. 맨 뒤 숫자를 저장해 둔다.
			temp = A[len-1];
			
			// 2. 뒤에서부터 한 칸식 옆으로 옮겨 담는다.
			for(int j=len-2; j>-1; j--) {
				A[j+1] = A[j];
			}
			
			// 3. 맨 앞에 저장해둔 값을 넣는다.
			A[0] = temp;
		}
		
		return A;
	}
}
