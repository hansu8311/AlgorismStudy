package Exhaustiv_search;

import java.util.Scanner;

/* 게임판 덮기 PICNIC 출처 : https://algospot.com/judge/problem/read/BOARDCOVER
입력 : 
3 
3 7 
#.....# 
#.....# 
##...## 
3 7 
#.....# 
#.....# 
##..### 
8 10 
########## 
#........# 
#........# 
#........# 
#........# 
#........# 
#........# 
########## 

출력 :  
0
2
1514
*/
public class ex03 {
	
	static char [][] game_board;
	static int [] game_anser;
	static int iH = 0;
	static int iW = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int icases = sc.nextInt();
		game_anser = new int[icases];
		
		for(int cases = 0 ; cases < icases ; cases++) 
		{
			game_anser[cases] = 0;
			int iWhiteNum = 0;
			iH = sc.nextInt();
			iW = sc.nextInt();
			//System.out.println("iH : " + iH + ", iW : " + iW);
			
			sc.nextLine();//엔터 제거
		    game_board = new char[iH][iW];
			for(int i = 0 ; i < iH; i++) {
				//System.out.println("i : " + i);
				String sbuffer = sc.nextLine();
				

				for(int j = 0; j < sbuffer.length() ; j++) {
					
	        		char ch = sbuffer.charAt(j); 
	        		//System.out.println("ch : " + ch);
		        	if(ch=='.' || ch=='#'){
		        		if(ch == '.') iWhiteNum++;
		        		game_board[i][j] = ch;
		        	}
		        	else
		        	{
		        		System.out.println(".또는 # 이외의 문자를 입력하셨습니다.");
		        		break;
		        	}					
				}
			}
			
//			for(int i = 0 ; i < iH; i++) {
//				for(int j = 0; j < game_board[i].length ; j++) {
//		        		System.out.print(game_board[i][j] + " ");	
//		        }
//				System.out.println();
//			}	
			
			boolean bcollect = false;
			int ix=0,iy=0;
			
			if(iWhiteNum % 3 == 0)
			{
//				for(int i = 0 ; i < iH-1; i++) {
//					for(int j = 0; j < game_board[i].length -1 ; j++) {
//			        		if(game_board[i][j] == '.' && game_board[i+1][j] == '.' &&game_board[i+1][j+1] == '.' ||
//			        		   game_board[i][j] == '.' && game_board[i][j+1] == '.' &&game_board[i+1][j+1] == '.' ||
//			        		   game_board[i][j] == '.' && game_board[i+1][j] == '.' &&game_board[i][j+1] == '.'   ||
//			        		   game_board[i][j] == '.' && game_board[i+1][j] == '.' &&game_board[i-1][j-1] == '.') {
//			        			ix = i;
//			        			iy = j;
//			        			bcollect = true;
//			        			break;
//			        		}
//			        }
//					if(bcollect) break;
//				}
//				System.out.println("x: "+ix +" y: "+iy);
				BoardCovering(cases,SearchEmptyX(0,0),SearchEmptyY(0,0));
			}
			else
			{
				game_anser[cases] = 0;
			}

//			//ㄱ
//			if(game_board[ix][iy] == '.' && game_board[ix+1][iy] == '.' &&game_board[ix+1][iy+1] == '.') 
//			{
//				System.out.println("======ㄴ");
//				game_board[ix][iy] = '+' ;
//			    game_board[ix+1][iy] = '+';
//			    game_board[ix+1][iy+1] = '+';
//			    
//			    BoardCovering(ix,iy);
//				
//			    game_board[ix][iy] = '.' ;
//			    game_board[ix+1][iy] = '.';
//			    game_board[ix+1][iy+1] = '.';
//			}
//			//ㄴ
//			if(game_board[ix][iy] == '.' && game_board[ix][iy+1] == '.' &&game_board[ix+1][iy+1] == '.') 
//			{
//				System.out.println("======ㄴ");
//				game_board[ix][iy] = '+' ;
//			    game_board[ix][iy+1] = '+';
//			    game_board[ix+1][iy+1] = '+';
//			    
//			    BoardCovering(ix,iy);
//				
//			    game_board[ix][iy] = '.' ;
//			    game_board[ix][iy+1] = '.';
//			    game_board[ix+1][iy+1] = '.';
//			}
			//┌
			if(game_board[ix][iy] == '.' && game_board[ix+1][iy] == '.' &&game_board[ix][iy+1] == '.') 
			{
				System.out.println("======┌");
//				game_board[ix][iy] = '+' ;
//			    game_board[ix+1][iy] = '+';
//			    game_board[ix][iy+1] = '+';
			    
			    BoardCovering(cases,SearchEmptyX(0,0),SearchEmptyX(0,0));
			    
//				game_board[ix][iy] = '.' ;
//			    game_board[ix+1][iy] = '.';
//			    game_board[ix][iy+1] = '.';
			}
		}
		for (int i = 0; i < game_anser.length; i++) {
			System.out.println(game_anser[i]);
		}
	}
	public static boolean BoardCovering(int cases ,int ix, int iy){
		int []dx = {0, 1,  1, 1, 1, 1,  0, 1};
		int []dy = {1, 1,  0, 1, 0,-1,  1, 0};
		//ShowBoard();
		//System.out.println("함수 들어왔다 x: "+ix +" y: "+iy);
		

		if(game_board[ix][iy] == '.') 
		{
			for(int i = 0; i < dx.length ; i+=2)
			{
				//System.out.println("함수 안의 i"+i);
				if(game_board[ix + dx[i]][iy+ dy[i]] == '.' &&
				   game_board[ix + dx[i+1]][iy+ dy[i+1]] == '.')
				{
					game_board[ix][iy] = '+' ;
					game_board[ix + dx[i]][iy+ dy[i]] = '+';
					game_board[ix + dx[i+1]][iy+ dy[i+1]] = '+';
				    
					BoardCovering(cases,SearchEmptyX(ix,iy),SearchEmptyY(ix,iy));
					
					game_board[ix][iy] = '.' ;
					game_board[ix + dx[i]][iy+ dy[i]] = '.';
					game_board[ix + dx[i+1]][iy+ dy[i+1]] = '.';
				}
			}
		}
		else 
		{
			//ShowBoard();
			game_anser[cases] +=1; 
			//System.out.println("=======정답 : " + game_anser[cases]);
			return true;
		}
			
		return false;
	}
	
	public static void ShowBoard(){
		for(int i = 0 ; i < iH; i++) {
			for(int j = 0; j < game_board[i].length ; j++) {
	        		System.out.print(game_board[i][j] + " ");	
	        }
			System.out.println();
		}	
	}
	public static int SearchEmptyX(int ix, int iy){
		int rx = 0;
		int ry = 0;
		boolean bcollect = false;
		for(int i = ix ; i < iH; i++) {
			for(int j = 0; j < iW  ; j++) {
	        		if(game_board[i][j] == '.')
	        		{
	        			//ShowBoard();
	        			
	        			rx = i;
	        			ry = j;
	        			//System.out.println("SEARCH : "+rx + " : "+ry +" : "+ ix + " : "+iy);
	        			bcollect = true;
	        			break;
	        		} 
	        }
			if(bcollect) break;
		}
		
		if(!bcollect) return iH-1;
		return rx;
	}
	public static int  SearchEmptyY(int ix, int iy){
		int rx = 0;
		int ry = 0;
		boolean bcollect = false;
		for(int i = ix ; i < iH; i++) {
			for(int j = 0; j < iW  ; j++) {
	        		if(game_board[i][j] == '.')
	        		{
	        			rx = i;
	        			ry = j;
	        			bcollect = true;
	        			break;
	        		}
	        }
			if(bcollect) break;
		}
		if(!bcollect) return iW-1;
		return ry;
	}
	
}
