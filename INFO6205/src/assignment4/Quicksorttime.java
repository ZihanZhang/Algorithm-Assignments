package assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;

public class Quicksorttime {
	
	
	public void time() {
		long tot = 0;
		long avt;
		System.out.print("Quick Sort: ");
		
		for (int i = 10000; i <= 1000000; i = i + 10000) {
			for (int j = 0; j < 10; j++) {
				tot = tot + run(i);
			}
			avt = tot / 10;
			System.out.print(avt + " ");
		}
		
		System.out.println();
		
	}
	
	
	public long run(int num) {
		Data[] oria = new Data[num];
		List<Integer> lt = new ArrayList<Integer>();
		for (int i = 0; i < num; i++) {
			Data d = new Data();
			d.data = i;
			oria[i] = d;
		}
		for (int i = 0; i < num / 2; i++) {
			Data d = new Data();
			d.data = i;
			lt.add(d.data);
		}
		
		
		Collections.shuffle(lt);
//		Comparable[] a = null;
		Iterator it = lt.iterator();
		for (int i = 0; i < num / 2; i++) {
			oria[i].data = (int) it.next();
		}
		long startTime = System.currentTimeMillis();
		Merge.sort(oria);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		return totalTime;
//		Quick.sort(a);
//		Insertion.sort(a);
//		Selection.sort(a);
//		Heap.sort(a);
	}
}
