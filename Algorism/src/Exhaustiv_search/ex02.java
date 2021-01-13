package Exhaustiv_search;

import java.util.Scanner;

/* 소풍 PICNIC 출처 : https://algospot.com/judge/problem/read/PICNIC
입력 : 
3 
2 1 
0 1 
4 6 
0 1 1 2 2 3 3 0 0 2 1 3 
6 10 
0 1 0 2 1 2 1 3 1 4 2 3 2 4 3 4 3 5 4 5

출력 : 
1
3
4
*/
public class ex02 { 
	static int[] Picnic_anser = null;
	static int cases_Picnic = 0;
	static int Picnic_person = 0;
	static int retrunCount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		cases_Picnic = sc.nextInt();
		
		Picnic_anser = new int[cases_Picnic];
		
		int Picnic_relation = 0;
		
		int [] Picnic_relation_x = null;
		int [] Picnic_relation_y = null;
		
		while(cases_Picnic-- > 0) {
			Picnic_person = sc.nextInt();
			Picnic_relation = sc.nextInt();
			
			Picnic_relation_x = new int[Picnic_relation];
			Picnic_relation_y = new int[Picnic_relation];
			
			for(int i = 0; i < Picnic_relation ; i++) {
				Picnic_relation_x[i] = sc.nextInt();
				Picnic_relation_y[i] = sc.nextInt();
			}
			
			System.out.println("cases_Picnic : " + cases_Picnic);
			System.out.println("Picnic_person : " + Picnic_person);
			System.out.println("Picnic_relation : " + Picnic_relation);
			for(int i = 0; i < Picnic_relation-1 ; i++) {
				System.out.println("=================초기화START==============================");
				retrunCount =0;
				countParings(i, 1, Picnic_relation_x,Picnic_relation_y);
				System.out.println("=================초기화END++==============================");
			}
			System.out.println();
			
		}
		System.out.println("Picnic_anser");
		for(int i = 0; i < Picnic_anser.length ; i++) {
			System.out.println(Picnic_anser[i]);
		}
	}
	public static boolean countParings(int istart ,int icount, int irelation_x[], int irelation_y[]){
		retrunCount++;
		System.out.println(retrunCount+" 번째 함수 들어옴" + istart +" : "+ icount+" :" +retrunCount);
		
		int anser = Picnic_person / 2;
		int lcount = icount;
		if(retrunCount == 1) System.out.println("("+irelation_x[istart]+", "+irelation_y[istart] +")");

		if(istart < 0 || istart > irelation_x.length) return false;
		
		if(istart == irelation_x.length-1) return true;
		
		for(int i = istart + 1; i < irelation_x.length ; i++) {
			lcount = icount;
//			if(irelation_x[istart] == irelation_x[i]) System.out.println("irelation_x["+istart+"]==irelation_x["+i+"] : "+ irelation_x[istart]+"=="+irelation_y[i]);
//			else if(irelation_x[istart] == irelation_y[i]) System.out.println("irelation_x["+istart+"]==irelation_y["+i+"] : "+ irelation_x[istart]+"=="+irelation_y[i]);
//			else if(irelation_y[istart] == irelation_y[i]) System.out.println("irelation_y["+istart+"]==irelation_y["+i+"] : "+ irelation_y[istart]+"=="+irelation_y[i]);
//			else if(irelation_y[istart] == irelation_x[i]) System.out.println("irelation_y["+istart+"]==irelation_x["+i+"] : "+ irelation_y[istart]+"=="+irelation_x[i]);
//			System.out.println();
			System.out.print(i + " ");
			if(irelation_x[istart] == irelation_x[i] ||
			   irelation_x[istart] == irelation_y[i] ||	
			   irelation_y[istart] == irelation_x[i] ||
			   irelation_y[istart] == irelation_y[i] ) {}
			else {
				lcount ++;
				System.out.println("("+irelation_x[i]+", "+irelation_y[i] +") lcount : "+lcount);
				if(lcount == anser) {
					Picnic_anser[cases_Picnic] = Picnic_anser[cases_Picnic] +1;
					System.out.println("정답  count : "+Picnic_anser[cases_Picnic] +" " + lcount+ ", anser :" +anser);
					break;
				}else {
					countParings(i, lcount,irelation_x,irelation_y);
				}
			}
		}
		System.out.println();
		return false;
	}
}
