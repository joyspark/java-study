package study.algorithm.codility.lessons;

/**
 * �ڵ���Ƽ lessons 2
 * 
 * intput �� int�� ���� �迭A�� ���� ���� K
 * K ��ŭ �迭 ���� �����͸� ���������� ��ĭ�� �̵�, 
 * �� �������� �����ʹ� �� �������� ���Ե�.
 * (��, �迭�� ������ K�� 0~100 ����)
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
		
		// �� �迭�� ��, ����ó��
		if(len == 0)
			return new int[0];
		
		for(int i=0; i<K; i++) {
			// 1. �� �� ���ڸ� ������ �д�.
			temp = A[len-1];
			
			// 2. �ڿ������� �� ĭ�� ������ �Ű� ��´�.
			for(int j=len-2; j>-1; j--) {
				A[j+1] = A[j];
			}
			
			// 3. �� �տ� �����ص� ���� �ִ´�.
			A[0] = temp;
		}
		
		return A;
	}
}
