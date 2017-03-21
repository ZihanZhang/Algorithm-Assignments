package assignment5;

public class Test {
	
	static int m = 100;
	
    private static int hash(Integer key) {
        return (key.hashCode() & 0x7fffffff) % m;
//    	return ((int)key) % m;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer key = 2333333;
		
		int i;
        int j = 1;
        for (i = hash(key); j <= 10; i = (i + (j * hash2((int)key))) % m) {
        	j++;
//            if (keys[i].equals(key)) {
//                vals[i] = val;
//                
////                long endtime = System.currentTimeMillis();
////                time = endtime - starttime;
////                System.out.print(time + " ");
//                return;
//            }
        	System.out.println(i);
        	System.out.println(j);
        }
	}
	
    public static int hash2(int key) {
    	return  97 - (key % 97);
    }

}
