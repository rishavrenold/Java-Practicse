package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MultiSourceBFS {
    
    static final int N = 1010;
    static final int MOD = (int) 1e9 + 7;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] grid = new boolean[N][N];
    static int[][] distA = new int[N][N];
    static int[][] distMon = new int[N][N];
    static Queue<int[]> monsterOcc = new LinkedList<>();
    static Queue<int[]> AOcc = new LinkedList<>();
    static int[][][] par = new int[N][N][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m=sc.nextInt();
        sc.nextLine();
        
        for(int i=0;i<n;i++)
        {
            Arrays.fill(grid[i],false);
            Arrays.fill(distA[i],-1);
            Arrays.fill(distMon[i],-1);
        }
        for(int i=0;i<n;i++)
        {
            String s=sc.nextLine();
            for(int j=0;j<m;j++)
            {
                grid[i][j]=true;
                if(s.charAt(j)=='#')
                {
                    grid[i][j]=false;
                }else if(s.charAt(j)=='M')
                {
                    distMon[i][j]=0;
                    monsterOcc.offer(new int[]{i,j});
                }else if(s.charAt(j)=='A')
                {
                    distA[i][j]=0;
                    AOcc.offer(new int[]{i,j});
                    par[i][j][0]=-1;
                    par[i][j][1]=-1;
                }
            }
        }

            while(!monsterOcc.isEmpty())
            {
                int []xy=monsterOcc.poll();
                int x=xy[0];
                int y=xy[1];
                for(int i=0;i<4;i++)
                {
                    int xx=x+dx[i]; int yy= y+dy[i];
                    if(xx<0 || xx>=n ||yy <0 ||yy>=m) continue;
                    if(grid[xx][yy] || distMon[xx][yy]==-1)
                    {
                        distMon[xx][yy]=distMon[x][y]+1;
                        monsterOcc.add(new int[]{xx,yy});
                    } 
                }
            }

            while(!AOcc.isEmpty())
            {
                int []xy=AOcc.poll();
                int x=xy[0];
                int y=xy[1];
                for(int i=0;i<4;i++)
                {
                    int xx=x+dx[i]; int yy= y+dy[i];
                    if(xx<0 || xx>=n ||yy <0 ||yy>=m) continue;
                    if(grid[xx][yy] || distMon[xx][yy]==-1)
                    {
                        distA[xx][yy]=distMon[x][y]+1;
                        AOcc.add(new int[]{xx,yy});
                        par[xx][yy][0]=x;
                        par[xx][yy][1]=y;
                    } 
                }
            }
            int finx = -1, finy = -1, findist = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (grid[i][0] && distA[i][0] >= 0 && (distA[i][0] < distMon[i][0] || distMon[i][0] == -1)) {
                    finx = i; finy = 0;
                    findist = Math.min(findist, distA[i][0]);
                }
                if (grid[i][m - 1] && distA[i][m - 1] >= 0 && (distA[i][m - 1] < distMon[i][m - 1] || distMon[i][m - 1] == -1)) {
                    finx = i; finy = m - 1;
                    findist = Math.min(findist, distA[i][m - 1]);
                }
            }
    
            for (int i = 0; i < m; i++) {
                if (grid[0][i] && distA[0][i] >= 0 && (distA[0][i] < distMon[0][i] || distMon[0][i] == -1)) {
                    finx = 0; finy = i;
                    findist = Math.min(findist, distA[0][i]);
                }
                if (grid[n - 1][i] && distA[n - 1][i] >= 0 && (distA[n - 1][i] < distMon[n - 1][i] || distMon[n - 1][i] == -1)) {
                    finx = n - 1; finy = i;
                    findist = Math.min(findist, distA[n - 1][i]);
                }
            }
        
            if (finx == -1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                System.out.println(findist);
                
                StringBuilder path = new StringBuilder();
                int x = finx, y = finy;
                while (true) {
                    int prex = par[x][y][0];
                    int prey = par[x][y][1];
                    if (prex == -1 && prey == -1) break;
                    if (y - prey == 1) path.append('R');
                    else if (y - prey == -1) path.append('L');
                    else if (x - prex == 1) path.append('D');
                    else path.append('U');
                    x = prex; y = prey;
                }
                System.out.println(path.reverse().toString());
            }
            sc.close();


    }
}

