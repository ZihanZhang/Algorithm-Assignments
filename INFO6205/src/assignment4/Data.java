package assignment4;

public class Data implements Comparable<Data>{
	int data;

	@Override
	public int compareTo(Data o) {
		if (this.data > o.data){
			return 1;
		}
		else return -1;
	}
	
	public String toString() {
		return Integer.toString(this.data);
	}
}
