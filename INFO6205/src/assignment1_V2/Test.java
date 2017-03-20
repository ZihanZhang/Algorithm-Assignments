package assignment1_V2;

import java.lang.reflect.Array;

public class Test {
	public static void main(String[] args) {
		Test tt = new Test();
		Pool pl = new Pool();
		int[] usingB = new int[5];
		int requestnum = 4;
		int fragment = 0;
		pl.init();
			tt.onesetofrequest(pl, tt, usingB, requestnum, fragment);
			for (int i = 0; i < 5; i++) {
				pl.returnB(usingB[i]);
				tt.print(pl, fragment);
			}
//		tt.print(pl);
//		pl.fetchB(3);
//		tt.print(pl);
//		pl.returnB(3);
//		pl.splitB(4);
//		tt.print(pl);
//		pl.mergeB(4);
//		tt.print(pl);
//		pl.fetchB(4);
//		pl.fetchB(5);
//		pl.fetchB(6);
//		pl.splittoindex(4);
//		tt.print(pl);
	}
	
	public void print(Pool pl, int fragment) {
		Block curtB = pl.index[pl.findfirstnotnullindex(-1)];
		while (curtB != null) {
			System.out.print(curtB.index);
			System.out.print(" ");
			fragment = fragment + (10 - curtB.index);
			curtB = curtB.next;
		}
		System.out.print("   fragment:" + fragment);
		System.out.println("");
		fragment = 0;
	}
	
	public void onesetofrequest(Pool pl, Test tt, int[] usingB, int requestnum, int fragment) {
		int requestindex;
		for (int i = 0; i < 5; i++) {
			requestindex = (int)(Math.random()*9);
			pl.request(requestindex, usingB, requestnum);
			tt.print(pl, fragment);
			requestnum--;
		}
	}
}
