public class CPUThread extends Thread {

	long duration;
	
	protected CPUThread(){
		duration=1;
	}
	CPUThread(String duration) {
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

	protected static long shortdur = 10000, longdur = 10000000, mediumdur = 100000;

	public void run() {
		final long startTime = System.nanoTime();
		final long endTime;
		for (long i = 0; i < duration; i++) {
//			try { //not really necessary
//				sleep(0);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				//e.printStackTrace();
//			}
		}
		endTime = System.nanoTime();
		elapsed_time = endTime-startTime;
	}

	protected long elapsed_time;

	long getElapsed() {
		return elapsed_time;
	}

}
