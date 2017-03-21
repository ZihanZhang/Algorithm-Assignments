package assignment5;

public class Test1 {
	public static void main(String [] args) {
		int i = hash(42949672);
		System.out.println(i);
	}
	
    private static int hash(Integer key) {
        return (key.hashCode() & 0x7fffffff) % 1000;
//    	return ((int)key) % m;
    }
}
