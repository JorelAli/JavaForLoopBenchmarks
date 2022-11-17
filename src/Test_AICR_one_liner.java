import java.util.ArrayList;
import java.util.List;

public class Test_AICR_one_liner {

	public static void main(String[] args) {
		final String input = args[0];

		final List<String> myList = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			myList.add("A" + i);
		}

		boolean found = false;

		long old = System.nanoTime();

		for(int i = 0, size = myList.size(); i < size && !(found = input.equals(myList.get(i))); i++) {}

		System.out.println(System.nanoTime() - old);

		assert found; // Consume found
	}

}
