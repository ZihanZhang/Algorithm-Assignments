package assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import edu.princeton.cs.algs4.*;

public class Manager {

	public static void main(String[] args) {
		Mergesorttime mt = new Mergesorttime();
		mt.time();
		Quicksorttime qt = new Quicksorttime();
		qt.time();
		Insertionsorttime it = new Insertionsorttime();
		it.time();
		Selectionsorttime st = new Selectionsorttime();
		st.time();
		Heapsorttime ht = new Heapsorttime();
		ht.time();
	}

}
