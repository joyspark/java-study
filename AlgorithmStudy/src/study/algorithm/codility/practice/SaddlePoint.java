package study.algorithm.codility.practice;

/**
 * saddle point ���� return  
 * ��� ���� �� �翷 ������ �۰�, �� ���Ʒ� ������ Ŭ ��
 * OR
 * ��� ���� �� �翷 ������ ũ��, �� ���Ʒ� ������ ���� ��
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
	 * @return saddle point ����
	 */
	public static int solution(int[][] A) {
		int saddlePointCnt = 0;
		int point = 0;
		int row = 0;
		int col	= 0;
		
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[i].length; j++) {
				// �翷/��/�Ʒ� ���� ���� ��� skip
				if(i==0 || j==0 || i==A.length-1 || j==A[i].length-1)
					continue;
				// ���� ��
				point = A[i][j];
				// �࿡ ���� �� ��
				row = compareValue(point, A[i-1][j], A[i+1][j]);
				// ���� ���� �� ��
				col = compareValue(point, A[i][j-1], A[i][j+1]);
				
				if((row==1 && col ==2) || (row==2 && col ==1))
					saddlePointCnt += 1;
			}
		}
		
		return saddlePointCnt;
	}
	
	// point�� val1, val2 ���� ū��, ������ �˻��ϴ� �޼ҵ�
	public static int compareValue(int point, int val1, int val2) {
		if(point > val1 && point > val2) // Ŭ ��
			return 1;
		else if(point < val1 && point < val2) // ���� ��
			return 2;
		else 
			return 3; // �ϰ͵� �ƴ� ��
	}
}
