import java.util.Random;


public class IOThread extends CPUThread {

	IOThread(String duration) {
		super(duration);
		// TODO Auto-generated constructor stub
	}
	
	final static int shortdur = 10, longdur = 1000, mediumdur = 100, sleepfactor=5;
	
	public void run() {
		final long startTime = System.nanoTime();
		final long endTime;
		Random rand = new Random();
		for (int i = 0; i < duration; i++) {
			try { //simulate waiting on I/O
				sleep(rand.nextInt(duration/sleepfactor));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		endTime = System.nanoTime();
		elapsed_time = startTime - endTime;
	}

}
