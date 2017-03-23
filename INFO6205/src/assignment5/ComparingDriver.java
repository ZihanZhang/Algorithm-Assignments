package assignment5;

public class ComparingDriver {

	public static void main(String[] args) {
		ComparingDriver cd = new ComparingDriver();
//		cd.testdoubyinputwor(1000, 0.5);
//		cd.testlinearbyinputwor(1000, 0.5);
//		System.out.println("");
//		cd.testquabyinputwor(1000, 0.5);
//		cd.testlinearbyinput(10000, 0.5);
//		System.out.println("");
//		cd.testlinearbyinput(1000, 0.5);
//		System.out.println("");
//		cd.testlinearbyinput(100, 0.5);
//		cd.testquabyinput(1000, 0.5);
//		System.out.println("");
//		cd.testdoubyinput(1000, 0.5);
//		cd.testlinearbysize(0.5);
//		System.out.println("");
//		cd.testlinearbyloadfator(1000);
//		System.out.println("");
//		System.out.println("");
//		cd.testquabysize(0.5);
//		System.out.println("");
////		cd.testquadrabyloadfator(1000);
////		System.out.println("");
////		System.out.println("");
//		cd.testdoubysize(0.5);
//		System.out.println("");
//		cd.testdoubyloadfator(1000);
	}
	
	public void testlinearbyinputwor(int size, double loadfactor) {
		for (int i = 10000000; i <= 100000000; i = i+ 10000000) {
			LinearHashingWithoutResizing<Integer, Integer> lwnr = new LinearHashingWithoutResizing<Integer, Integer>(i, loadfactor);
			long starttime = System.currentTimeMillis();
			for (int j = 0; j < i; j++) {
				int key = (int) (Math.random()*100000);
				int value = (int) (Math.random()*100000);
				lwnr.put(key,value);
			}
			long endtime = System.currentTimeMillis();
			System.out.print(endtime - starttime + " ");
		}
	}
	
	public void testquabyinputwor(int size, double loadfactor) {
		for (int i = 10000000; i <= 100000000; i = i+ 10000000) {
			QuadraticHashingWithoutResizing<Integer, Integer> lwnr = new QuadraticHashingWithoutResizing<Integer, Integer>(i, loadfactor);
			long starttime = System.currentTimeMillis();
			for (int j = 0; j < i; j++) {
				int key = (int) (Math.random()*100000);
				int value = (int) (Math.random()*100000);
				lwnr.put(key,value);
			}
			long endtime = System.currentTimeMillis();
			System.out.print(endtime - starttime + " ");
		}
	}
	
	public void testdoubyinputwor(int size, double loadfactor) {
		for (int i = 10000000; i <= 100000000; i = i+ 10000000) {
			DoubleHashingWithoutResizing<Integer, Integer> lwnr = new DoubleHashingWithoutResizing<Integer, Integer>(i, loadfactor);
			long starttime = System.currentTimeMillis();
			for (int j = 0; j < i; j++) {
				int key = (int) (Math.random()*100000);
				int value = (int) (Math.random()*100000);
				lwnr.put(key,value);
			}
			long endtime = System.currentTimeMillis();
			System.out.print(endtime - starttime + " ");
		}
	}
	
	public void testlinearbyinput(int size, double loadfactor) {
		for (int i = 100000; i < 1000000; i = i+ 10000) {
			LinearHashing<Integer, Integer> lwnr = new LinearHashing<Integer, Integer>(i, loadfactor);
			long starttime = System.currentTimeMillis();
			for (int j = 0; j < i; j++) {
				int key = (int) (Math.random()*100000);
				int value = (int) (Math.random()*100000);
				lwnr.put(key,value);
			}
			long endtime = System.currentTimeMillis();
			System.out.print(endtime - starttime + " ");
		}
	}
	
	public void testquabyinput(int size, double loadfactor) {
		for (int i = 100000; i < 1000000; i = i+ 10000) {
			QuadraticHashing<Integer, Integer> lwnr = new QuadraticHashing<Integer, Integer>(i, loadfactor);
			long starttime = System.currentTimeMillis();
			for (int j = 0; j < i; j++) {
				int key = (int) (Math.random()*100000);
				int value = (int) (Math.random()*100000);
				lwnr.put(key,value);
			}
			long endtime = System.currentTimeMillis();
			System.out.print(endtime - starttime + " ");
		}
	}
	
	public void testdoubyinput(int size, double loadfactor) {
		for (int i = 100000; i < 1000000; i = i+ 10000) {
			DoubleHashing<Integer, Integer> lwnr = new DoubleHashing<Integer, Integer>(i, loadfactor);
			long starttime = System.currentTimeMillis();
			for (int j = 0; j < i; j++) {
				int key = (int) (Math.random()*100000);
				int value = (int) (Math.random()*100000);
				lwnr.put(key,value);
			}
			long endtime = System.currentTimeMillis();
			System.out.print(endtime - starttime + " ");
		}
	}
	
	
	public void testlinearbysize(double loadfactor) {
		for (int i = 100; i < 1000; i = i+ 10) {
			long starttime = System.currentTimeMillis();
			LinearHashing<Integer, Integer> lwnr = new LinearHashing<Integer, Integer>(i, loadfactor);
			tryput(lwnr);
			long endtime = System.currentTimeMillis();
			System.out.print(endtime - starttime + " ");
		}
	}
	
	public void testquabysize(double loadfactor) {
		for (int i = 100; i < 1000; i = i+ 10) {
			long starttime = System.currentTimeMillis();
			QuadraticHashing<Integer, Integer> qh = new QuadraticHashing<Integer, Integer>(i, loadfactor);
			tryput(qh);
			long endtime = System.currentTimeMillis();
			System.out.print(endtime - starttime + " ");
		}
	}
	
	public void testdoubysize(double loadfactor) {
		for (int i = 100; i < 1000; i = i+ 10) {
			long starttime = System.currentTimeMillis();
			DoubleHashing<Integer, Integer> dh = new DoubleHashing<Integer, Integer>(i, loadfactor);
			tryput(dh);
//			System.out.print(i + " ");
			long endtime = System.currentTimeMillis();
			System.out.print(endtime - starttime + " ");
		}
	}
	
	public void testlinearbyloadfator(int size) {
		for (double i = 0.1; i < 1.0; i = i+ 0.01) {
			long starttime = System.currentTimeMillis();
			LinearHashing<Integer, Integer> lwnr = new LinearHashing<Integer, Integer>(size, i);
			tryput(lwnr);
			long endtime = System.currentTimeMillis();
			System.out.print(endtime - starttime + " ");
		}
	}
	
	public void testquadrabyloadfator(int size) {
		for (double i = 0.1; i < 1.0; i = i+ 0.01) {
			long starttime = System.currentTimeMillis();
			QuadraticHashing<Integer, Integer> qh = new QuadraticHashing<Integer, Integer>(size, i);
			tryput(qh);
			long endtime = System.currentTimeMillis();
			System.out.print(endtime - starttime + " ");
		}
	}
	
	public void testdoubyloadfator(int size) {
		for (double i = 0.1; i < 1.0; i = i+ 0.01) {
			long starttime = System.currentTimeMillis();
			DoubleHashing<Integer, Integer> dh = new DoubleHashing<Integer, Integer>(size, i);
			tryput(dh);
			long endtime = System.currentTimeMillis();
			System.out.print(endtime - starttime + " ");
		}
	}
	
	public void tryput(LinearHashing<Integer, Integer> l) {
		for (int i = 0; i < 1000000; i++) {
			int key = (int) (Math.random()*100000);
			int value = (int) (Math.random()*100000);
			l.put(key, value);
		}
	}
	
	public void tryput(QuadraticHashing<Integer, Integer> l) {
		for (int i = 0; i < 1000000; i++) {
			int key = (int) (Math.random()*100000);
			int value = (int) (Math.random()*100000);
			l.put(key, value);
		}
	}
	
	public void tryput(DoubleHashing<Integer, Integer> l) {
		for (int i = 0; i < 1000000; i++) {
			int key = (int) (Math.random()*100000);
			int value = (int) (Math.random()*100000);
			l.put(key, value);
		}
	}

}
