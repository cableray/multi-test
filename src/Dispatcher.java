
public class Dispatcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 0){
			//fail
		}
		if (args.length == 3){
			if (args[1].equals("-f")){
				//open file
			}
		}
		if (args.length==5){
			setup_children(args[1],args[2],args[3],args[4]);
		}

	}

	private static void setup_children(String s_num_procs, String s_num_threads,
			String type, String duration) {
		// TODO Auto-generated method stub
		
		//Parse strings
		int num_procs, num_threads;
		try{
			num_procs=Integer.parseInt(s_num_procs);
			num_threads=Integer.parseInt(s_num_threads);
		}
		catch(NumberFormatException e){
			//fail
		}
		if (!(type.equals("I")||type.equals("C"))){
			//fail
		}
		
		if (!(duration.equals("S")||duration.equals("M")||duration.equals("L"))){
			//fail
		}
		
		//start processes
		// TODO call processes
	}

}
