package assignment2;

public class Initial {

	Block block = new Block();
	UpAndDown upDownT=new UpAndDown();
	int count=0;
	public void creatBlock(Block pointer) {
		if (pointer.left == null) {
			creatLeftBlock(pointer);
		}
		if (pointer.right == null) {
			creatRightBlock(pointer);
		}
	}

	private void creatLeftBlock(Block pointer) {
		block = new Block(pointer.index - 1);
		pointer.left = block;
		block.p = pointer;
		pointer = pointer.left;
		// recursion
		if (pointer.index > 0) {
			creatBlock(pointer);
		}
		return;
	}

	private void creatRightBlock(Block pointer) {
		block = new Block(pointer.index - 1);
		pointer.right = block;
		block.p = pointer;
		pointer = pointer.right;
		// recursion
		if (pointer.index > 0) {
			creatBlock(pointer);
		}
		return;
	}

	Block findBlock;

	public Block getIndexBlock(int index, Block pointer) {
		try{
			if (index == pointer.index && pointer.isUse == true) {
				System.out.println("All block of size " + pointer.index + " are buzy");
				return null;
			}
		}catch(NullPointerException e){
			
		}
		try {
		while (pointer.index != index + 1 && index != pointer.index) {// 取到想要的block的parent
																		// 後者是因為findBlock的調用會使findBlock在index位置上
			pointer = pointer.left; ///// 在這裡設定 當left是busy的時候 就停下來
		}
		pointer = getBlock(pointer, index);
		}catch(NullPointerException e){
			
		}
		if (pointer != null)
			pointer.isUse = true;

		return pointer;// 遞歸到底以後，這裡一般先從右邊開始輸出
	}

	Block hasSmallBlock, hasBlock, nextBlock;

	public Block getBlock(Block pointer, int index) {
		findBlock = pointer;
		if (findBlock.index != index) {// 當index是最大的時候不能用這個,否則會導致pointer變化
			pointer = checkChild(pointer);// 默認先拿parent左邊的
			if (pointer == null) {// 左右都不能用的情況,跳轉到另一邊去取,當到盡頭沒有相應的blcok要處理
				findBlock=upDownT.leftTree(findBlock);
				
				findBlock = findBlock.right;
				
				findBlock=upDownT.rightTree(findBlock,index);
				//recursion
				pointer = getIndexBlock(index, findBlock);
			}
		}
		return pointer;
	}

	public Block checkChild(Block pointer) {// 找這個 打印了下一個返回
		if (pointer.left.isUse == false) {
			if (pointer.isUse == true) {
				return null;
			}
			return pointer.left;
		} else
			return null;
	}

	public Block setParentBusy(Block pointer) {
		while (pointer.p != null) {
			pointer.p.isUse = true;
			pointer = pointer.p;
		}
		return pointer;
	}

	public Block setChildrenBusy(Block pointer) {
		pointer.isUse = true;
		if (pointer.left != null || pointer.right != null) {
			pointer.left.isUse = true;
			pointer.right.isUse = true;
			setChildrenBusy(pointer.left);
			setChildrenBusy(pointer.right);
		}
		return pointer;
	}
	
	public Block setChildrenFree(Block pointer) throws NullPointerException{
		pointer.isUse = false;
		if (pointer.left != null || pointer.right != null) {
			pointer.left.isUse = false;
			pointer.right.isUse = false;
			setChildrenFree(pointer.left);
			setChildrenFree(pointer.right);
		}
//		setParentFree(pointer);
		return pointer;
	}
	
	public Block setParentFree(Block pointer){
		if(pointer.p!=null&&pointer.p.left.isUse==false&&pointer.p.right.isUse==false){
			pointer.p.isUse=false;
		}
		while(pointer.p!=null){
			pointer=pointer.p;
			setParentFree(pointer);
		}
		return pointer;
	}

}
