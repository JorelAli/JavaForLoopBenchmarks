

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForLoopTesting {
	
	public static void nop() {
		assert true;
	}
	
	public static boolean find(String x) {
		return "A5000".equals(x);
	}

	public static void main(String[] args) {
		
		final List<String> myList = new ArrayList<>();
//		final List<String> myList = new LinkedList<>();
		for(int i = 0; i < 10000; i++) {
			myList.add("A" + i);
		}
		
		{
			boolean found = false;
			long old = System.nanoTime();
			
			for(int i = 0, size = myList.size(); i < size; i++) {
				found |= find(myList.get(i));
			}
			
			System.out.println("For loop:      " + (System.nanoTime() - old) + "ns: " + found);
		}
		
		{
			boolean found = false;
			long old = System.nanoTime();
			
			for(int i = 0, size = myList.size(); i < size; i++) {
				found |= find(myList.get(i));
			}
			
			System.out.println("For loop:      " + (System.nanoTime() - old) + "ns: " + found);
		}
		
		{
			boolean found = false;
			long old = System.nanoTime();
			
			for(int i = 0, size = myList.size(); i < size && !found; i++) {
				found |= find(myList.get(i));
			}
			
			System.out.println("For loop fast:            " + (System.nanoTime() - old) + "ns: " + found);
		}
		
		{
			boolean found = false;
			long old = System.nanoTime();
			
			for(int i = 0, size = myList.size(); i < size && !found; i++) {
				found = find(myList.get(i));
			}
			
			// Using a print statement with more characters is probably slower.
			System.out.println("For loop nbw: " + (System.nanoTime() - old) + "ns: " + found);
		}
		
		{
			boolean found = false;
			long old = System.nanoTime();
			
			for(int i = 0, size = myList.size(); i < size && !(found = "A5000".equals(myList.get(i))); i++) {}
			
			System.out.println("For loop sfast: " + (System.nanoTime() - old) + "ns: " + found);
		}
		
		Map<String, String> map = new HashMap<>();
		for(String s : myList) {
			map.put(s, s);
		}
		
		{
			boolean found = false;
			long old = System.nanoTime();
			found = map.containsKey("A5000");
			
			System.out.println("Hash: " + (System.nanoTime() - old) + "ns: " + found);
		}
		
		{
			boolean found = false;
			long old = System.nanoTime();
			
			for(int i = 0, size = myList.size(); i < size && !(found = find(myList.get(i))); i++) {}
			
			System.out.println("For loop sfast2: " + (System.nanoTime() - old) + "ns: " + found);
		}
		
		{
			boolean found = false;
			long old = System.nanoTime();
			
			for(int i = 0, size = myList.size(); i < size; i++) {
				found = find(myList.get(i));
				if(found) {
					break;
				}
			}
			
			System.out.println("For loop if: " + (System.nanoTime() - old) + "ns: " + found);
		}
		
		{
			boolean found = false;
			long old = System.nanoTime();
			
			for(String value : myList) {
				found |= find(value);
				if(found) {
					break;
				}
			}
			
			System.out.println("For-each loop: " + (System.nanoTime() - old) + "ns: " + found);
		}

		
	}
	
}
