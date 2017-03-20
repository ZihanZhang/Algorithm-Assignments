package assignment1;

public class Run {

	public static void main(String[] args) {
		BlockIndex blockindex = new BlockIndex();
		blockindex.init();
		blockindex.getBlock(3);
		show(blockindex);
	}
	
	public static void show(BlockIndex blockindex) {
		Block curtblock = blockindex.header;
		while (curtblock.next != null) {
			System.out.print(curtblock.index);
			System.out.print(" ");
			curtblock = curtblock.next;
		}
		System.out.print(curtblock.index);
		System.out.println("");
		for(Block block: blockindex.BlockIndex) {
			if (block != null){
				System.out.print(block.index);
				System.out.print(" ");
			}
			else {
				System.out.print("null");
				System.out.print(" ");
			}
		}
	}
}
