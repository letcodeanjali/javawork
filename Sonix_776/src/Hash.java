import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class Hash {
	public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        
        // Populate the ConcurrentHashMap with data
        concurrentHashMap.put(1, "python");
        concurrentHashMap.put(2, "java");
        concurrentHashMap.put(3, "aws");
        concurrentHashMap.put(4, "html");
        
        // Create HashSet for integers
        HashSet<Integer> integerHashSet = new HashSet<>();
        
        // Create HashSet for strings
        HashSet<String> stringHashSet = new HashSet<>();
        
        // Merge the ConcurrentHashMap values into the respective HashSets
        concurrentHashMap.forEach((key, value) -> {
            integerHashSet.add(key);
            stringHashSet.add(value);
        });
        
        // Print the results
        System.out.println("HashSet of Integers: " + integerHashSet);
        System.out.println("HashSet of Strings: " + stringHashSet);
    }
}
