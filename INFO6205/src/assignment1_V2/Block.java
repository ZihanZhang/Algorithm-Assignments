package assignment1_V2;

public class Block {
	Block trailer;
	Block next;
	int size;
	int index;
	public Block(int index) {
		this.index = index;	
		this.size = (int) Math.pow(2, index);
	}
}
