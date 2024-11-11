import java.util.HashSet;
	 
import java.util.concurrent.Executors;
	import java.util.concurrent.ScheduledExecutorService;
	import java.util.concurrent.TimeUnit;
public class H {
	

	
	    public static void main(String[] args) {
	        
	        HashSet<String> stringSet = new HashSet<>();
	        stringSet.add("java");
	        stringSet.add("python");
	        stringSet.add("aws");
	        stringSet.add("html");
	        stringSet.add("c++");
	        stringSet.add("css");
	        
	        stringSet.add("react");
	        
	        

	       
	        ScheduledExecutorService eS = Executors.newScheduledThreadPool(1);

	        
	        Runnable task = () -> {
	            if (!stringSet.isEmpty()) {
	                String element = stringSet.iterator().next();
	                System.out.println("Pulled: " + element);
	                stringSet.remove(element);
	            } else {
	                System.out.println("HashSet is empty.");
	                eS.shutdown(); 
	            }
	        };

	       
	        eS.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
	    }
	}


