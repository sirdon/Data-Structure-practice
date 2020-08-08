package DP;

import java.util.ArrayList;

public class Dynamic {

	public int FibR(int n) {
		return n<2 ? n : FibR(n-1)+FibR(n-2);
	}

	public int FibDP(int n) {
        int[] arr = new int[n+1];
		return FiboDPHelper(n,arr);
	}

    private int FiboDPHelper(int n, int[] arr) {
        if(n<2) return n;

        if(arr[n]!=0) return arr[n];
        arr[n] =FiboDPHelper(n-1, arr) +FiboDPHelper(n-2, arr);
        return arr[n];
    }

	public int FibDPTab(int n) {
        if(n<2) return n;
        int[] arr = new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
    public int FibDPSlider(int n){
        int a=0,b=1;
        for(int i=2;i<=n;i++){
            int nf = a+b;
            a=b;
            b=nf;
        }
        return b;
    }
    public int countBoardPathR(int s, int d) {
        if(s==d) return 1;
        if(s>d) return 0;
        int cstod = 0;
        for(int dice = 1; dice<=6;dice++){
            int i = s+dice;
            int citod = countBoardPathR(i, d);
            cstod += citod;
        }
        return cstod;
    }

	public int countBoardPathM(int s, int d) {
        int[] arr = new int[d+1];
		return countBoardPathMHelper(s, d, arr);
	}

    private int countBoardPathMHelper(int s, int d, int[] arr) {
        if(s==d) return 1;
        if(s>d) return 0;
        if(arr[s]!=0) return arr[s];
        int cstod = 0;
        for(int dice = 1; dice<=6;dice++){
            int i = s+dice;
            int citod = countBoardPathMHelper(i, d, arr);
            cstod += citod;
        }
        arr[s] = cstod;
        return cstod;
    }

	public int countBoardPathT(int s, int d, int[] arr) {
        arr[d] =1;
        for(int x=d-1;x>=s;x--){
            for(int dice=1;dice<=6;dice++){
                if(x+dice <= d){
                    arr[x] += arr[x+dice];
                }
            }
        }
        return arr[0];
    }

    public int countBoardPathSlider(int s, int d) {
        int[] arr = new int[6];
        for(int i=1;i<=5;i++) arr[i]=0;
        arr[0]=1;
        for(int x=d-1;x>=s;x--){
            for(int dice=1;dice<=6;dice++){
                if(x+dice <= d){
                    arr[x] += arr[x+dice];
                }
            }
        }
        return arr[0];
    }
	public int countMazePathR(int sr, int sc, int dr, int dc) {
        if(sr>dr || sc>dc) return 0;
        if(sr==dr && sc==dc) return 1;
        int counth = countMazePathR(sr+1,sc,dr,dc);
        int countv =  countMazePathR(sr,sc+1,dr,dc);
		return counth + countv;
	}

	public int countMazePathM(int sr, int sc, int dr, int dc,int[][] arr) {
		if(sr>dr || sc>dc) return 0;
        if(sr==dr && sc==dc) return 1;
        if(arr[sr][sc]!=0) return arr[sr][sc];
        int counth = countMazePathR(sr+1,sc,dr,dc);
        int countv =  countMazePathR(sr,sc+1,dr,dc);
        int count = counth + countv;
        arr[sr][sc] =count;
		return count;
	}

	public int countMazePathT(int sr, int sc, int dr, int dc, int[][] arr){
        for(int r=dr;r>=sr;r--){
            for(int c=dc;c>=sc;c--){
                if(r==dr && c==dc) arr[r][c]=1;
                else if(r==dr) arr[r][c]=arr[r][c+1];
                else if(c==dc) arr[r][c] = arr[r+1][c];
                else arr[r][c] = arr[r+1][c]+arr[r][c+1];
            }
        }
		return arr[0][0];
	}    
    
}