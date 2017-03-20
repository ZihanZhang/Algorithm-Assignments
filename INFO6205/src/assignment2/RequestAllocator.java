package assignment2;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Timer;

public class RequestAllocator {
	
	Run r = new Run();
	
	Block pointer;
	
	int topindex;
	
	int useindex;
	
	Initial init;
	
	int requestnum = 0;
	
	public RequestAllocator(Block pointer, int topindex, Initial init) {
		this.pointer = pointer;
		this.topindex = topindex;
		this.init = init;
	}
	
	public void allocate() {
		while(requestnum < 20) {     //define the total number of request		
			useindex = (int)(Math.random()*topindex);
			Thread br = new BlockRequest(pointer, topindex, useindex, init);
			br.start();
			int interval = 1000 + (int)(Math.random()*4000);
			Robot rb;
			try {
				rb = new Robot();
				rb.delay(interval);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			requestnum++;
		}
		
	}
}
