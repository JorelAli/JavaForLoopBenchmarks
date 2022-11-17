public class Test_NICR_one_liner {

	public static void main(String[] args) {
		final String input = args[0];

		final String[] myList = new String[10000];
		for (int i = 0; i < 10000; i++) {
			myList[i] = "A" + i;
		}

		boolean found = false;

		long old = System.nanoTime();

		for(int i = 0, size = myList.length; i < size && !(found = input.equals(myList[i])); i++) {}

		System.out.println(System.nanoTime() - old);

		assert found; // Consume found
	}

}
