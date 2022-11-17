public class Test_NE {

	public static void main(String[] args) {
		final String input = args[0];

		final String[] myList = new String[10000];
		for (int i = 0; i < 10000; i++) {
			myList[i] = "A" + i;
		}

		boolean found = false;

		long old = System.nanoTime();

		for (String value : myList) {
			found = input.equals(value);
		}

		System.out.println(System.nanoTime() - old);

		assert found; // Consume found
	}

}
