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
		int[] A = {6,1,2,4,3};
		System.out.println("문제 1 => " + solution1(A));
		// 2) Tape Equilibrium
		int[] B = {3,1,2,4,3};
		System.out.println("문제 2 => " + solution2(B));
		// 3) Frog Jmp
		System.out.println("문제 3 => " + solution3(999999,1000000000,10000000));
	}
	
	/**
	 * 배열 중간에 빠진 숫자 하나를 찾는 알고리즘
	 * 
	 * @param A => int[1~N+1] (N : 1~100,000사이), 중복되는 숫자는 없음
	 * @return 빠진 숫자
	 */
	public static int solution1(int[] A) {
		int missingElem = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 빈 값일 경우 
		if(A.length == 0)
			return 1;
		
		// list 에 값을 넣는다.
		for(int a : A) {
			list.add(a);
		}
		
		list.sort(null);
		// 마지막 값 비교
		if(list.get(list.size()-1) == A.length) {
			return A.length+1;
		// 처음 값 비교
		} else if(list.get(0) != 1){
			return 1;
		} else {
			for(int i=list.size()-1; i>0; i--) {
				// 다음 값이랑 비교해서 차이가 2일 때 
				if((list.get(i) - list.get(i-1)) == 2) {
					missingElem = list.get(i)-1;
				}
			}
			return missingElem;
		}
	}
	
	
	/**
	 * 한 칸씩 이동하면서
	 * 앞에서 뒤를 뺏을 때
	 * 가장 차이가 적은 숫자를 return
	 * 
	 * @param A [-1,000~1,000], 길이 (2~100,000)
	 * @return
	 */
	public static int solution2(int[] A) {
		int front = 0;
		int back = 0;
		int min = 0;
		int diff = 0;
		
		for(int i=0; i<A.length-1; i++) {
			// 첫 루틴 계산
			if(i==0) {
				// 앞쪽 더하기 계산
				front += A[0];
				// 뒤쪽 더하기 계산
				for(int j=1; j<A.length; j++)
					back += A[j];
			} else {
				front += A[i];
				back -= A[i];
			}
			// 차이 계산 
			diff = front-back; 
			if(diff < 0)
				diff = diff * -1;
			// diff 최소 값 비교
			if(i==0)
				min = diff;
			else if(diff < min)
				min = diff;
		}
		
		return min;
	}
	
	
	/**
	 * X 에서 Y 또는 Y이상으로 가려면 
	 * 뛰어야할 가장 적은 jump 수
	 * 
	 * @param X 현재 위치
	 * @param Y 가려는 위치
	 * @param D 한번에 jump 할 수 있는 거리
	 * @return X-> Y까지 가려면 뛰어야하는 jump 수
	 */
	public static int solution3(int X, int Y, int D) {
		int jump = 0;

		int target = Y - X;
		int n = target/D;
		
		if((D*n)+X == Y)
			jump = n;
		else
			jump = n+1;
		
		return jump;
	}
}
