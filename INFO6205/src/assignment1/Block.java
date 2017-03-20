package assignment1;

public class Block {
	Block trailer;
	int size;
	int index;
	Block next;
	public Block(int index) {
		this.index = index;	
		this.size = (int) Math.pow(2, index);
	}
}
