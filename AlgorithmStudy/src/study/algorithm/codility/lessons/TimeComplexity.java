package study.algorithm.codility.lessons;

import java.util.ArrayList;
import java.util.Collections;

/**
 * lesson 3
 * 
 * @since 2020-02-12
 * @author joy.seo
 *
 */
public class TimeComplexity {
	
	public static void main(String[] args) {
		// 1) Perm Missing Elem
		int[] A = {3,1,2,4,3};
		//System.out.println(solution1(A));
		// 2) Tape Equilibrium
		System.out.println(solution2(A));
		// 3) Frog Jmp
	}
	
	/**
	 * �迭 �߰��� ���� ���� �ϳ��� ã�� �˰���
	 * 
	 * @param A => int[1~N+1] (N : 1~100,000����), �ߺ��Ǵ� ���ڴ� ����
	 * @return ���� ����
	 */
	public static int solution1(int[] A) {
		int missingElem = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// �� ���� ��� 
		if(A.length == 0)
			return 1;
		
		// list �� ���� �ִ´�.
		for(int a : A) {
			list.add(a);
		}
		
		list.sort(null);
		// ������ �� ��
		if(list.get(list.size()-1) == A.length) {
			return A.length+1;
		// ó�� �� ��
		} else if(list.get(0) != 1){
			return 1;
		} else {
			for(int i=list.size()-1; i>0; i--) {
				// ���� ���̶� ���ؼ� ���̰� 2�� �� 
				if((list.get(i) - list.get(i-1)) == 2) {
					missingElem = list.get(i)-1;
				}
			}
			return missingElem;
		}
	}
	
	
	/**
	 * �� ĭ�� �̵��ϸ鼭
	 * �տ��� �ڸ� ���� ��
	 * ���� ���̰� ���� ���ڸ� return
	 * 
	 * @param A [-1,000~1,000], ���� (2~100,000)
	 * @return
	 */
	public static int solution2(int[] A) {
		int front = 0;
		int back = 0;
		int min = 0;
		int diff = 0;
		
		for(int i=0; i<A.length-1; i++) {
			// ù ��ƾ ���
			if(i==0) {
				// ���� ���ϱ� ���
				front += A[0];
				// ���� ���ϱ� ���
				for(int j=1; j<A.length; j++)
					back += A[j];
			} else {
				front += A[i];
				back -= A[i];
			}
			// ���� ��� 
			diff = front-back; 
			if(diff < 0)
				diff = diff * -1;
			// diff �ּ� �� ��
			if(i==0)
				min = diff;
			else if(diff < min)
				min = diff;
		}
		
		return min;
	}
}
