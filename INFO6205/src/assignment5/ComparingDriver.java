package assignment5;

public class ComparingDriver {

	public static void main(String[] args) {
		ComparingDriver cd = new ComparingDriver();
		cd.testlinearbysize(0.5);
		System.out.println("");
		cd.testlinearbyloadfator(1000);
		System.out.println("");
		System.out.println("");
		cd.testquabysize(0.5);
		System.out.println("");
		cd.testquadrabyloadfator(1000);
		System.out.println("");
		System.out.println("");
//		cd.testdoubysize(0.5);
//		System.out.println("");
//		cd.testdoubyloadfator(1000);
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
		for (int i = 0; i < 100000; i++) {
			int key = (int) (Math.random()*100000);
			int value = (int) (Math.random()*100000);
			l.put(key, value);
		}
	}
	
	public void tryput(QuadraticHashing<Integer, Integer> l) {
		for (int i = 0; i < 100000; i++) {
			int key = (int) (Math.random()*100000);
			int value = (int) (Math.random()*100000);
			l.put(key, value);
		}
	}
	
	public void tryput(DoubleHashing<Integer, Integer> l) {
		for (int i = 0; i < 90; i++) {
			int key = (int) (Math.random()*100000);
			int value = (int) (Math.random()*100000);
			l.put(key, value);
		}
	}

}
