package algorithm;

import java.util.*;
import java.io.*;

public class Main {
	
	static int[] answer;
	
	static boolean backTracking(int idx) {
		if (idx >= answer.length) {
			return true;
		}
		
		int possible = 7; // 111 : {3, 2, 1}에 대한 비트마스킹

		for (int j = 1; j <= (idx + 1) / 2; j++) { // 길이 j만큼 비교합니다.
			int rightIdx = idx - (j - 1);
			int leftIdx = rightIdx - j;
			
			for (int k = 0; k < j; k++) {
				if (k == j-1) {
					possible = possible ^ (1 << (answer[leftIdx + k] - 1));
				}
				
				if (answer[leftIdx + k] != answer[rightIdx + k]) {
					break;
				}
			}
		}
		
		if (possible == 0) {
			return false;
		}
		
		int num = 0;
		for (int j = 0; j < 3; j++) {
			if ((possible & (1 << j)) > 0) {
				answer[idx] = j + 1;
				if (backTracking(idx + 1)) {
					return true;
				}
			}
		}
		return false;
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	answer = new int[N];

    	for (int i = 1; i <= 3; i++) {
    		answer[0] = i;
    		if (backTracking(1)) {
    			break;
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < N; i++) {
    		sb.append(answer[i]);
    	}
    	System.out.println(sb);
    }
}