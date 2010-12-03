public class CPUThread extends Thread {

	int duration;

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

	final static int shortdur = 100, longdur = 10000, mediumdur = 1000;

	public void run() {
		final long startTime = System.nanoTime();
		final long endTime;
		for (int i = 0; i < duration; i++) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				//e.printStackTrace();
//			}
		}
		endTime = System.nanoTime();
		elapsed_time = startTime - endTime;
	}

	protected long elapsed_time;

	long getElapsed() {
		return elapsed_time;
	}

}
