package assignment2;

public class UpAndDown {
	Block hasSmallBlock;
	public Block leftTree(Block findBlock) {
		leftMove: while (findBlock.p != null && findBlock.right.isUse == true) {// 當所要的剛好被利用
			// 而且同parent底下的同size也被使用
			// 在二叉樹左邊的時候，需要確認下面是否還是有小的可以使用，有的話，就在該點進入
			hasSmallBlock = findBlock;
			while (hasSmallBlock.right != null) {
				hasSmallBlock = hasSmallBlock.right;
			}
			if (hasSmallBlock.isUse == false) {
				break leftMove;
			}
			findBlock = findBlock.p;
		}
		return findBlock;
	}
	
	Block hasBlock, nextBlock;
	public Block rightTree(Block findBlock,int index){
		rightMove: while (findBlock.p.p == null && findBlock.p.right == findBlock // 承認pointer處於樹右邊第一個的位置
				&& findBlock.right.isUse == true && index < findBlock.index) {// 需要取右下角沒用到的block的時候
			while (findBlock.right != null && findBlock.isUse == true) {
				if (findBlock.index == index) {
					System.out.println("All block of size " + findBlock.index + " are busy");
					return null;
				}
				// 對於二叉樹的右邊，每個分支都進去確認是否有block可用，有的話，就在該點進入，沒有的話就往下面的block移動
				hasBlock = findBlock;
				while (hasBlock.left != null) {
					hasBlock = hasBlock.left;
					//保證free完以後依舊能取到
					if(hasBlock.index==index&&hasBlock.isUse==false){
						findBlock=hasBlock;
						break rightMove;
					}
					nextBlock = hasBlock;
					while (nextBlock.right != null) {
						nextBlock = nextBlock.right;
//						System.out.println("wwwwwww");
					}
					if (nextBlock.isUse == false) {
						break rightMove;
					}
				}

				findBlock = findBlock.right;
			}
		}
		return findBlock;
	}

}
