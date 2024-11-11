import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class SortingSecondChar {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
        set.add("Veera");
        set.add("Anjali");
        set.add("Abhi");
        set.add("Axar");
        set.add("Virat");
        set.add("Kohli");
        List<String> list = new ArrayList<>(set);
        Comparator<String> comparator = (str1, str2) -> {
            char char1 = str1.length() > 1 ? str1.charAt(1) : '\0';
            char char2 = str2.length() > 1 ? str2.charAt(1) : '\0';
            if (char1 != char2) {
                return Character.compare(char1, char2);
            } else {
                return str1.compareTo(str2);
            }
        };
        Collections.sort(list, comparator);
        for (String str : list) {
            System.out.println(str);
	}
	}

}

