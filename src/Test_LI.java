import java.util.LinkedList;
import java.util.List;

public class Test_LI {

	public static void main(String[] args) {
		final String input = args[0];

		final List<String> myList = new LinkedList<>();
		for (int i = 0; i < 10000; i++) {
			myList.add("A" + i);
		}

		boolean found = false;

		long old = System.nanoTime();

		for (int i = 0; i < myList.size(); i++) {
			found = input.equals(myList.get(i));
		}

		System.out.println(System.nanoTime() - old);

		assert found; // Consume found
	}

}
