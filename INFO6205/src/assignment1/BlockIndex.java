package assignment1;

import java.util.ArrayList;

public class BlockIndex {
	ArrayList<Block> BlockIndex = new ArrayList<Block>();
	Block header;
	
	public void init() {
		header = new Block(0);
		BlockIndex.add(header);
		for (int i = 0; i < 10 ; i++) {
			if (i == 0) {
				header = BlockIndex.get(0);
			}
			else{
				BlockIndex.add(new Block(i));
				BlockIndex.get(i - 1).next = BlockIndex.get(i);
				BlockIndex.get(i).trailer = BlockIndex.get(i - 1);
			}
		}
	}
	
	public Block findheader(int index) {
		Block curt;
		curt = header;
		for (int i = 0; i < BlockIndex.size(); i++) {
			if (curt.index == index) {
				return curt;
			}
			curt = curt.next;
		}
		return null;
	}
	
/*	public void setHeader(int index) {
		if (BlockIndex.get(index).next.index == index) {
			BlockIndex.set(index, BlockIndex.get(index).next);
		}
		else {
			BlockIndex.set(index, null);
		}
	}
	
/*	public Block findend(int index) {
		Block curt;
		curt = header.next;
		Block trailer;
		trailer = header;
		for (int i = 0; i < BlockIndex.size(); i++) {
			if (curt.index == index + 1) {
				return trailer;
			}
			curt = curt.next;
			trailer = trailer.next;
		}
		return null;
	}
*/
	public void extractBlock(Block b) {
		if (b.next.index == b.index) {
			BlockIndex.set(b.index, b.next);
			b.trailer.next = b.next;
			b.next.trailer = b.trailer;
			b.trailer = null;
			b.next = null;
		}
		else {
			BlockIndex.set(b.index, null);
			b.trailer.next = b.next;
			b.next.trailer = b.trailer;
			b.trailer = null;
			b.next = null;
		}
	}
	
	public void splitBlock(Block b) {
		extractBlock(b);
		returnBlock(new Block(b.index - 1));
		returnBlock(new Block(b.index - 1));
	}
	
	public void returnBlock(Block b) {
		Block oldindexheader = findheader(b.index);
		b.next = oldindexheader;
		b.trailer = oldindexheader.trailer;
		//findend(b.index - 1).next = b;
		oldindexheader.trailer.next = b;
		oldindexheader.next.trailer = b;
		BlockIndex.set(b.index, b);
	}
	
	public void getBlock(int size) {
		int index = 0;
		for (int i = 0; i < BlockIndex.size(); i++) {
			if ((Math.pow(2, i) < size) && (Math.pow(2,i+1) >= size)) {
				index = i + 1;
				break;
			}
		}
		if (findheader(index) != null) {
			//findend(index - 1).next = BlockIndex.get(index).next;
			//setHeader(index);
			extractBlock(BlockIndex.get(index));
		}
		else {
			for (int i = index + 1; i < BlockIndex.size(); i++) {
				if (findheader(i) != null) {
					int curtindex = i;
					while(curtindex != index) {
						splitBlock(BlockIndex.get(curtindex));
						curtindex--;
					}
//					setHeader(index);
					extractBlock(BlockIndex.get(index));
				}
			}
		}
	}
}
