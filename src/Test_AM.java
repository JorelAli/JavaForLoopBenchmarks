import java.util.ArrayList;
import java.util.List;

public class Test_AM {

	public static void main(String[] args) {
		final String input = args[0];

		final List<String> myList = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			myList.add("A" + i);
		}

		boolean found = false;

		long old = System.nanoTime();

		found = myList.stream().anyMatch(input::equals);

		System.out.println(System.nanoTime() - old);

		assert found; // Consume found
	}

}
