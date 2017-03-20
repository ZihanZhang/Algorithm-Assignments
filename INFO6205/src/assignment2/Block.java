package assignment2;

public class Block {

	int size;
	int index;
	boolean isUse;
	Block left;
	Block right;
	Block p;
	
	Block(){
		
	}

	Block(int index) {
		this.size = (int) Math.pow(2, index);
//		this.data = data;
		this.index = index;
	}
	
	public Block creatBlock(int index){
		Block block=new Block(index);
//		System.out.println(block.toString());
		return block;
	}
	
	@Override
	public String toString() {
		return "Block"+index+" [size=" + size + ", parent=Block" + (index+1) + ", index=" + index + ", \tisUse=" + isUse + 
				", \nBlock"+index+"'s  left=" + left + ", \nBlock"+index+"'s right=" + right
				+ "]";
	}

}
