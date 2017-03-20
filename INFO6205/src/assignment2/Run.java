package assignment2;

public class Run {

	public static void main(String[] args) {
		
		// create BST
		init.creatBlock(pointer);
		
		
		RequestAllocator rll = new RequestAllocator(pointer, topindex, init);
		
		long startTime = System.currentTimeMillis();
		
		rll.allocate();

		long endTime = System.currentTimeMillis();
		
		long totalTime = endTime - startTime;
		
		System.out.println(totalTime/1000);

//		for (int i = 0; i < 14; i++) {
//			setFF = useSizeBlock(3);
//		}

//		useSizeBlock(3);
//		useSizeBlock(3);
//		setSizeFree(setFF);
//		useSizeBlock(3);
//		useSizeBlock(0);
//		useSizeBlock(3);
//		useSizeBlock(0);
//		useSizeBlock(3);
//		useSizeBlock(0);
//		 System.out.println(pointer);

	}

	static int topindex = 7;
	static Initial init = new Initial();
	static Block pointer = new Block(topindex);
	
	
	public static Block useSizeBlock(int useindex){
		blockSetFree=useBlock(pointer, topindex, useindex, init);
		return blockSetFree;
	}
	
	public static Block setSizeFree(Block setFF){
		setBlockFree=setFree(init, setFF);
		return setBlockFree;
	}

	static int count = 0;
	static Block setF, setFF, rootBlock,blockSetFree,setBlockFree;
	static int totalSize = (int) Math.pow(2, topindex);
	static int availableSiz = totalSize;

	public static Block useBlock(Block pointer, int topindex, int useindex, Initial init) {
		System.out.println("The top index is " + topindex + ". And Total Size of memory: " + totalSize);
		System.out.println("You want a block of index " + useindex + " = size " + (int) Math.pow(2, useindex));

		pointer = init.getIndexBlock(useindex, pointer);
		setF = pointer;
		//Count the size
		if (setF != null) {
			availableSiz = availableSiz - (int) Math.pow(2, setF.index);
		}
		System.out.println("Available Size left: " + availableSiz);

		try {
			init.setChildrenBusy(pointer);
			init.setParentBusy(pointer);
			while (pointer.p != null) {
				pointer = pointer.p;
			}
		} catch (NullPointerException e) {
			count++;
			System.out.println("			Failer number: " + count);
		}

		System.out.println("============================================================================");
		return setF;
	}

	public static Block setFree(Initial init, Block setFF) {
		init.setChildrenFree(setFF);
		availableSiz = availableSiz + (int) Math.pow(2, setFF.index);
		System.out.println("\nAfter free Block index=" + setFF.index + " Available Size: " + availableSiz+"\n");
		System.out.println("============================================================================");
		rootBlock = init.setParentFree(setFF);
		return rootBlock;
	}
}
