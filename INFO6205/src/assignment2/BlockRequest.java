package assignment2;

import java.awt.AWTException;
import java.awt.Robot;

public class BlockRequest extends Thread{	
	
	Run r = new Run();
	
	Block pointer;
	
	int topindex;
	
	int useindex;
	
	Initial init;
	
	Block usedblock;
	
	public BlockRequest(Block pointer, int topindex, int useindex, Initial init) {
		this.pointer = pointer;
		this.topindex = topindex;
		this.useindex = useindex;
		this.init = init;
	}
	
	@Override
	public void run() {
		try {
			// request block API
			usedblock = r.useSizeBlock(useindex);
			int interval = 1000 + (int)(Math.random()*4000);
			Robot rb = new Robot();
			rb.delay(interval);
			//return block API
			r.setSizeFree(usedblock);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
}
