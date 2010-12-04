import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;


public class Dispatcher {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0){
			usage();
			System.exit(1);
		}
		if (args.length == 2){
			if (args[1].equals("-f")){
				//open file
			}
			else {
				usage();
				System.exit(1);
			}
		}
		if (args.length==4){
			setup_children(args[0],args[1],args[2],args[3]);
		}

	}

	private static void setup_children(String s_num_procs, String s_num_threads,
			String type, String duration) {
		// TODO Auto-generated method stub
		
		//Parse strings
		int num_procs=1, num_threads=1;
		try{
			num_procs=Integer.parseInt(s_num_procs);
			num_threads=Integer.parseInt(s_num_threads);
		}
		catch(NumberFormatException e){
			usage();
			System.exit(1);
			
		}
		if (!(type.equals("I")||type.equals("C"))){
			usage();
			System.exit(1);
		}
		
		if (!(duration.equals("S")||duration.equals("M")||duration.equals("L"))){
			usage();
			System.exit(1);
		}
		
		//start processes or threads
		
		if (num_procs>1){
			System.err.println("can only run one process");
			// TODO call processes
//			ProcessBuilder this_proc = new ProcessBuilder();
//			String stuff=this_proc.command().toString();
//			ProcessBuilder pb = new ProcessBuilder("java", "-jar", "./multi-test.jar", "1", s_num_threads, type, duration);
//			for(int i=1; 1<=num_procs; i++){
//				try {
//					pb.start();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}
		else{
			ArrayList<Long> times = new ArrayList<Long> (num_threads);
			ArrayList<CPUThread> thrds = new ArrayList<CPUThread>(num_threads);
			long proc_elapsed, t_start;
			t_start = System.nanoTime();
			if (type.equals("C")){
				
				for (int i=0; i<num_threads; i++){
					CPUThread thrd = new CPUThread(duration);
					thrd.start();
					thrds.add(thrd);
				}
			}
			
			else {
				for (int i=0; i<num_threads; i++){
					IOThread thrd = new IOThread(duration);
					thrd.start();
					thrds.add(thrd);
				}
			}
			for(CPUThread thrd : thrds){
				try {
					thrd.join(); // wait for thread to complete before getting elapsed time
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				times.add(thrd.getElapsed());
			}
			proc_elapsed=System.nanoTime()-t_start;
			double mean=0;
			for(long i : times){
				mean+=i;
			}
			mean = mean / num_threads;
			Collections.sort(times);
			System.out.println(""+proc_elapsed+" "+mean+" "+times.toString());
		}	
	}
	
	static void usage(){
		System.err.println("Invalid usage: multi-test <number of processes> <number of threads> C|I S|M|L \n\t\tmulti-test -f <input-file>");
	}
}
