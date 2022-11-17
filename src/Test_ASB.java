import java.util.ArrayList;
import java.util.List;

public class Test_ASB {

	static boolean found = false;

	public static void main(String[] args) {
		final String input = args[0];

		final List<String> myList = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			myList.add("A" + i);
		}

		long old = System.nanoTime();

		myList.forEach(string -> {
			found |= input.equals(string);
		});

		System.out.println(System.nanoTime() - old);

		assert found; // Consume found
	}

}
