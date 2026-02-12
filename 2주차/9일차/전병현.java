import java.io.*;
import java.util.*;



public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	
	static int arr[] = new int[10];
	
	static int scores[]=new int[]{
		0,
		2,4,6,8,10,
		12,14,16,18,20, //10
		22,24,26,28,30,
		32,34,36,38,40, //20
		13,16,19, //23
		22,24, //25
		28,27,26,
		25, //29
		30,35, 0 //32
	};
	
	static int nexts[] = new int[] {
			1,2,3,4,5,21,7,8,9,10,24,12,13,14,15,26,17,18,19,20,32, //20
			22,23,29, //23
			25,29, //25
			27,28,29, //28
			30, //29
			31,20,
			32	
	};
	
	static int moves[][]
	= new int[][]{
		{ 1, 2, 3, 4, 5},//0
		{ 2, 3, 4, 5, 6},
		{ 3, 4, 5, 6, 7},
		{ 4, 5, 6, 7, 8},
		{ 5, 6, 7, 8, 9},
		{21,22,23,29,30}, //5
		{ 7, 8, 9,10,11},
		{ 8, 9,10,11,12},
		{ 9,10,11,12,13},
		{10,11,12,13,14},
		{24,25,29,30,31}, //10
		{12,13,14,15,16},
		{13,14,15,16,17},
		{14,15,16,17,18},
		{15,16,17,18,19},
		{26,27,28,29,30}, //15
		{17,18,19,20,32},
		{18,19,20,32,32},
		{19,20,32,32,32},
		{20,32,32,32,32},
		{32,32,32,32,32}, //20
		{22,23,29,30,31},
		{23,29,30,31,20},
		{29,30,31,20,32}, //23
		{25,29,30,31,20},
		{29,30,31,20,32}, //25
		{27,28,29,30,31},
		{28,29,30,31,20},
		{29,30,31,20,32},
		{30,31,20,32,32}, //29
		{31,20,32,32,32},
		{20,32,32,32,32},
		{32,32,32,32,32}  //32
	};
	
	static boolean chk(int nm, int m1, int m2, int m3) {
		if(nm==32)return true;
		return nm!=m1&&nm!=m2&&nm!=m3;
	}
	
	static int dfs(int idx, int m1, int m2, int m3, int m4, int score) {
		if(idx==10)return score;
		if(m1==32 && m2==32&&m3==32&&m4==32)return score;
		int mo = arr[idx]-1;
		int nm = moves[m1][mo];
		int max = 0;
		if(chk(nm, m2, m3, m4))
			max = Math.max(max, dfs(idx+1, nm, m2, m3, m4, score+scores[nm]));
		nm = moves[m2][mo];
		if(chk(nm, m1, m3, m4))
			max = Math.max(max, dfs(idx+1, m1, nm, m3, m4, score+scores[nm]));
		nm = moves[m3][mo];
		if(chk(nm, m1, m2, m4))
			max = Math.max(max, dfs(idx+1, m1, m2, nm, m4, score+scores[nm]));
		nm = moves[m4][mo];
		if(chk(nm, m1, m2, m3))
			max = Math.max(max, dfs(idx+1, m1, m2, m3, nm, score+scores[nm]));
		return max;
	}
	
    public static void main(String[] args) throws Exception {
//    	moves = new int[33][5];
//    	for(int i=0;i<33;i++) {
//    		int last = i;
//    		for(int j=0;j<5;j++) {
//    			last = moves[i][j] = nexts[last];
//    		}
//    	}
    	br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<10;i++)arr[i] = Integer.parseInt(st.nextToken());
        bw.write(""+dfs(0, 0, 0, 0, 0, 0));
        bw.flush();
    }
}












