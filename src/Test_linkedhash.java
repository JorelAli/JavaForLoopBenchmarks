import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Test_linkedhash {

	public static void main(String[] args) {
		final String input = args[0];

		final List<String> myList = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			myList.add("A" + i);
		}

		Map<String, Object> map = new LinkedHashMap<>();
		for (String s : myList) {
			map.put(s, new Object());
		}

		boolean found = false;

		long old = System.nanoTime();

		found = map.containsKey(input);

		System.out.println(System.nanoTime() - old);

		assert found; // Consume found
	}

}
