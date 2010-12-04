import java.util.Random;


public class IOThread extends CPUThread {

	IOThread(String duration) {
		if (duration.equals("S")) {
			this.duration = shortdur;
		}

		if (duration.equals("M")) {
			this.duration = mediumdur;
		}

		if (duration.equals("L")) {
			this.duration = longdur;
		}
	}
	
	protected final static long shortdur = 100, longdur = 100000, mediumdur = 10000, sleepfactor=5;
	
	public void run() {
		final long startTime = System.nanoTime();
		final long endTime;
		Random rand = new Random();
		for (long i = 0; i < duration; i++) {
			try { //simulate waiting on I/O
				sleep(rand.nextInt((int) (duration/sleepfactor)));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		endTime = System.nanoTime();
		elapsed_time = endTime- startTime ;
	}

}
