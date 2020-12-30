package Exhaustiv_search;

import java.util.Scanner;

/* 보글게임
출처: https://www.algospot.com/judge/problem/read/BOGGLE
  
입력: 
1
URLPM
XPRET
GIAET
XTNZY
XOQRS
6
PRETTY
GIRL
REPEAT
KARA
PANDORA
GIAZAPX

출력 :
PRETTY YES
GIRL YES
REPEAT YES
KARA NO
PANDORA NO
GIAZAPX YES
  */
public class ex01 {
	
	static char[][] Boggle_board = new char[5][5];
	
	public static void main(String[] args) {

		
        Scanner sc = new Scanner(System.in);
        int cases_board = sc.nextInt();
        int cases_anser = 0;
        
        String[] Boggle_anser = null;
        String[] Boggle_YN = null;
        sc.nextLine();//엔터 제거
        
        while(cases_board-- > 0) {
//        	System.out.println("Boggle_board.length : " + Boggle_board.length);
        	for(int i = 0; i < Boggle_board.length ; i++){
        		String buffer = sc.nextLine();

        		for(int j=0;j<buffer.length();j++){
        		
        		char ch = buffer.charAt(j); 

		        	if(ch>='a' &&ch<='z') {
		        		System.out.println("대문자만 입력가능");
		        		break;
		        	}else 
		        	if(ch>='A'&&ch<='Z'){
		        		Boggle_board[i][j] = ch;
		        	}
		        	else{
		        		System.out.println("잘못입력.");
		        		break;
		        	}
//	        		System.out.println(ch + "~~");
        		}
        	}
        	
//        	for(int i = 0; i < Boggle_board.length ; i++){
//        			for(int j = 0; j < Boggle_board[i].length ; j++){
//        				System.out.print(Boggle_board[i][j] + " ");
//        			}
//        			System.out.println(); 
//        	}
        	
        	//System.out.println("BOARD_END"); 
        	
        	cases_anser = sc.nextInt();
        	
        	sc.nextLine();
        	
        	Boggle_anser = new String[cases_anser];
        	
        	Boggle_YN = new String[cases_anser];

        	//System.out.println("cases_anser : " + cases_anser);
	        for(int i = 0; i < Boggle_anser.length ; i++){
	        		
	        	String buffer = sc.nextLine();
	        		
	        	Boggle_anser[i] = buffer;
	        	for(int x = 0; x<5; x++) {
	        		for(int y = 0; y<5; y++) {
	        			
	        			if (hasWord(y,x,buffer) == true) {
	        				Boggle_YN[i] = "YES";
	        				break;
	        			}else {
	        				Boggle_YN[i] = "NO";
	        			}
	    	       		
	        		}
	        		if(Boggle_YN[i].equals("YES")) {
	        			break;
	        		}
	        	}
	        }
        	
        	
        	for(int i = 0; i < Boggle_anser.length ; i++){
        		System.out.println(Boggle_anser[i] + " " + Boggle_YN[i]) ;
        	}
        	
        }
    }
	public static boolean hasWord(int iy, int ix, String iword){
		int []dx = {-1, -1, -1, 1, 1, 1,  0, 0};
		int []dy = {-1,  0,  1,-1, 0, 1, -1, 1};
		int x=ix;
		int y=iy;
		String word=iword;
		 
//		System.out.println(x + " : " + y + " : " + word);
		
		if(!inRange(y, x)) return false;
//		System.out.println(Boggle_board[x][y] + " : " + word.charAt(0));
		if(Boggle_board[x][y] != word.charAt(0)) return false;
		
		for(int direction = 0; direction < 8; ++direction) {
			int nextY = y + dy[direction], nextX = x + dx[direction];
			
			if(word.substring(1).isEmpty() || hasWord(nextY, nextX, word.substring(1))) return true;
		}
		return false;
	}
	public static boolean inRange(int iy, int ix){
		int x = ix;
		int y = iy;
		
		if(x >= 0 && x < 5 && y >= 0 &&  y<5) return true;
		else return false;
	}
}
