package assignment1_V2;

import java.util.Stack;

public class Pool {
	Block[] index0blocks = new Block[100];
	Block[] index1blocks = new Block[100];
	Block[] index2blocks = new Block[100];
	Block[] index3blocks = new Block[100];
	Block[] index4blocks = new Block[100];
	Block[] index5blocks = new Block[100];
	Block[] index6blocks = new Block[100];
	Block[] index7blocks = new Block[100];
	Block[] index8blocks = new Block[100];
	Block[] index9blocks = new Block[100];
	
	Block[] index = new Block[10];
	
	public void init() {
		index0blocks[0] = new Block(0);
		index1blocks[0] = new Block(1);
		index2blocks[0] = new Block(2);
		index3blocks[0] = new Block(3);
		index4blocks[0] = new Block(4);
		index5blocks[0] = new Block(5);
		index6blocks[0] = new Block(6);
		index7blocks[0] = new Block(7);
		index8blocks[0] = new Block(8);
		index9blocks[0] = new Block(9);
		
		index[0] = index0blocks[0];
		index[1] = index1blocks[0];
		index[2] = index2blocks[0];
		index[3] = index3blocks[0];
		index[4] = index4blocks[0];
		index[5] = index5blocks[0];
		index[6] = index6blocks[0];
		index[7] = index7blocks[0];
		index[8] = index8blocks[0];
		index[9] = index9blocks[0];
		
		index0blocks[0].trailer = null;
		index0blocks[0].next = index1blocks[0];
		index1blocks[0].trailer = index0blocks[0];
		index1blocks[0].next = index2blocks[0];
		index2blocks[0].trailer = index1blocks[0];
		index2blocks[0].next = index3blocks[0];
		index3blocks[0].trailer = index2blocks[0];
		index3blocks[0].next = index4blocks[0];
		index4blocks[0].trailer = index3blocks[0];
		index4blocks[0].next = index5blocks[0];
		index5blocks[0].trailer = index4blocks[0];
		index5blocks[0].next = index6blocks[0];
		index6blocks[0].trailer = index5blocks[0];
		index6blocks[0].next = index7blocks[0];
		index7blocks[0].trailer = index6blocks[0];
		index7blocks[0].next = index8blocks[0];
		index8blocks[0].trailer = index7blocks[0];
		index8blocks[0].next = index9blocks[0];
		index9blocks[0].trailer = index8blocks[0];
		index9blocks[0].next = null;
	}
	
	public void fetchB(int id) {
		if (index[id] == null) {    //block = null
//			nullblock(id);
			if(splittoindex(id) == 0){
				return;
			}
			else {
			   fetchB(id);
			}
		}
		else if (index[id].trailer == null) {
			int firstnotnullindex = findfirstnotnullindex(0);
			if (firstnotnullindex == 100) {
				System.out.println("Fail Request");
				return;
			}
			index[firstnotnullindex].trailer = null;
			index[id] = null;
		}
		else if (index[id].next == null) {
			int lastnotnullindex = findlastnotnullindex();
			index[lastnotnullindex].next = null;
			index[id] = null;
		}
		else if (index[id].next.index == id) {     //more than 1 blocks
			index[id].trailer.next = index[id].next;
			index[id].next.trailer = index[id].trailer;
			index[id] = index[id].next;
		}
		else {             //1 block
			index[id].trailer.next = index[id].next;
			index[id].next.trailer = index[id].trailer;
			index[id] = null;			
		}
	}
	
	public void returnB(int id) {
		Block newblock = new Block(id);
		if (id == 9) {
			return;
		}
		if (index[id] == null) {
			int firstnotnullindex = findfirstnotnullindex(id);
			if (firstnotnullindex == 100) {
				int lastnotnullindex = findlastnotnullindex();
				newblock.trailer = index[lastnotnullindex];
				newblock.next = null;
				if (lastnotnullindex == 9) {
					return;
				}
				index[lastnotnullindex].next = newblock;
				
			}
			else if (index[firstnotnullindex].trailer == null) {
				newblock.next = index[firstnotnullindex];
				newblock.trailer = null;
				index[firstnotnullindex].trailer = newblock;
				index[id] = newblock;
			}
			else {
				newblock.next = index[firstnotnullindex];
				newblock.trailer = index[firstnotnullindex].trailer;
				index[firstnotnullindex].trailer.next = newblock;
				index[firstnotnullindex].trailer = newblock;
				index[id] = newblock;
			}
		}
		else {
			if (index[id].trailer == null) {
				int firstnotnullindex = findfirstnotnullindex(id);
				newblock.next = index[firstnotnullindex];
				newblock.trailer = null;
				index[firstnotnullindex].trailer = newblock;
				index[id] = newblock;
			}
			else {
				newblock.next = index[id];
				newblock.trailer = index[id].trailer;
				index[id].trailer.next = newblock;
				index[id].trailer = newblock;
				index[id] = newblock;
			}
		}
	}
	
	public void splitB(int id) {
		fetchB(id);
		returnB(id - 1);
		returnB(id - 1);
	}
	
	public void mergeB(int id) {
		Stack st = new Stack();
		int curtsumofsize = 0;
		int curtint;
		Block curtB = findlastblocksmallthanid(id);
		int isavailable = 0;
		while (true) {
			if (curtsumofsize >= Math.pow(2, id)) {
				isavailable = 1;
				break;
			}
			if (curtB.trailer == null) {
				break;
			}
			curtsumofsize = curtsumofsize + curtB.size;
			st.push(curtB.index);
			curtB = curtB.trailer;
		}
//		System.out.println(st.peek());
//		st.pop();
//		System.out.println(st.peek());
//		st.pop();
		while (!st.isEmpty()) {
			curtint = (int)st.pop();
			fetchB(curtint);
		}
		if (isavailable == 1) {
			returnB(id);
		}
	}
	
//	public void nullblock(int id) {
//		if (index[id + 1] != null) {
//			splitB(id + 1);
//		}
//		else {
//			mergeB(id);
//		}
//	}
	
	public Block findlastblocksmallthanid(int id) {
		int lastnotnullindex = findlastnotnullindex();
		Block curtB = index[lastnotnullindex];
		while (true) {
			if (curtB.index <= id) {
				break;
			}
			curtB = curtB.trailer;
		}
		return curtB;
	}
	
	public int findlastnotnullindex() {
		int lastnotnullindex = 9;
		for (int i = 9; i >= 0; i--) {
			if (index[i] != null) {
				lastnotnullindex = i;
				break;
			}
		}
		return lastnotnullindex;
	}
	
	public int findfirstnotnullindex(int id) {
		int haslargeindex = 0;
		int firstnotnullindex = id + 1;
		for (int i = id + 1; i <= 9; i++) {
			if (index[i] != null) {
				haslargeindex = 1;
				firstnotnullindex = i;
				break;
			}
		}
		if (haslargeindex == 0) {
			return 100;     //100 means ERROR
		}
		return firstnotnullindex;
	}
	
	public int splittoindex(int id) {
		if (id == 9) {
			System.out.println("Fail Request");
			return 0;
		}
		int indexsplitted = findfirstnotnullindex(id);
		if (indexsplitted == 100) {
			mergeB(id + 1);
			splitB(id + 1);
		}
		else {
			int curtintvl = indexsplitted - id;
			int curtindex = indexsplitted;
			for (int i = curtintvl; i >= 1; i--) {
				splitB(curtindex);
				curtindex = curtindex - 1;
			}
		}
		return 1;
	}
	
	public void request(int id, int[] usingB, int requestnum) {
		fetchB(id);
		usingB[requestnum] = id;
	}
	
//	public Block findlastofindex(int id) {
//		Block curtB = index[id];
//		while (curtB.index == id) {
//			if (curtB.next == null) {
//				return curtB;
//			}
//			curtB = curtB.next;
//		}
//		return curtB;
//	}
}
