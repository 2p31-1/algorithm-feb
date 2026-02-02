package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2589 {
	
	static int n,m;
	static char[][] A = new char[50][50];
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	
	static int bfs(int x, int y) {
		int ret = -1;
		boolean[][] visited = new boolean[n][m];
		for(int i=0;i<n;i++) for(int j=0;j<m;j++) visited[i][j] = false;
		
		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{x,y});
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] f = q.poll();
				
				for(int j=0;j<4;j++) {
					int nx = f[0] + dx[j], ny = f[1] + dy[j];
					if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && A[nx][ny] == 'L') {
						visited[nx][ny] = true;
						q.offer(new int[] {nx,ny});
					}
				}
			}
			ret++;
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				char c = s.charAt(j);
				A[i][j] = c;
			}
		}
		
		int ans = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(A[i][j] == 'L') {
					int temp= bfs(i,j);
//					System.out.println(i + ", " + j + ":" + temp);
					ans = Math.max(ans, temp);
				}
			}
		}
		System.out.println(ans);
	}
}
