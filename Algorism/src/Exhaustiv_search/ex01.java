package Exhaustiv_search;

import java.util.Scanner;

/* 보글게임 
출처 : https://www.algospot.com/judge/problem/read/BOGGLE
  
입력 : 
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
        sc.nextLine();//개행문자 제거
        
        while(cases_board-- > 0) {
//        	System.out.println("Boggle_board.length : " + Boggle_board.length);
        	for(int i = 0; i < Boggle_board.length ; i++){
        		String buffer = sc.nextLine();
//        		System.out.println("Boggle_board i 반복 : " + i +" : " + buffer);
        		for(int j=0;j<buffer.length();j++){
        		
        		char ch = buffer.charAt(j); //charAt는 라인중 하나의 문자씩 받아와 ch에 담는다._

		        	if(ch>='a' &&ch<='z') {//대문자와 소문자 같이 하는곳
		        		System.out.println("대문자만 입력 가능합니다.");
		        		break;
		        	}else 
		        	if(ch>='A'&&ch<='Z'){
		        		Boggle_board[i][j] = ch;
		        	}
		        	else{
		        		System.out.println("문자만 입력 가능합니다.");
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
        	
        	System.out.println("BOARD_END"); 
        	
        	cases_anser = sc.nextInt();
        	
        	sc.nextLine();//개행문자 제거
        	
        	Boggle_anser = new String[cases_anser];
        	
        	Boggle_YN = new String[cases_anser];
        	while(cases_anser-- > 0) {
	        	for(int i = 0; i < Boggle_anser.length ; i++){
	        		
	        		String buffer = sc.nextLine();
	        		
	        		Boggle_anser[i] = buffer;
	        		
	        		if (hasWord(0,0,buffer) == true) {
	        			Boggle_YN[i] = "YES";
	        		}else {
	        			Boggle_YN[i] = "NO";
	        		}
	        		System.out.println("end anser : " + Boggle_anser[i] + " : " + Boggle_YN[i]);
	        	}
        	}
//        	for(int i = 0; i < Boggle_anser.length ; i++){
//        		for(int j = 0; j < Boggle_anser[i].length ; j++){
//        			System.out.print(Boggle_anser[i][j] + " ");
//        		}
//			System.out.println(); 
//        	}
        	
        }
    }
	public static boolean hasWord(int iy, int ix, String iword){
		int []dx = {-1, -1, -1, 1, 1, 1,  0, 0};
		int []dy = {-1,  0,  1,-1, 0, 1, -1, 1};
		int x=ix;
		int y=iy;
		String word=iword;

		System.out.println(x + " : " + y + " : " + word);
		
		if(!inRange(y, x)) return false;
		
		if(Boggle_board[x][y] != word.charAt(0)) return false;
		
		for(int direction = 0; direction < 8; ++direction) {
			int nextY = y + dy[direction], nextX = x + dx[direction];
			
			if(hasWord(nextY, nextX, word.substring(1))) return true;
		}
		return false;
	}
	public static boolean inRange(int iy, int ix){
		int x = ix;
		int y = iy;
		
		if(x > 0 && y<5) return true;
		else return false;
	}
}
