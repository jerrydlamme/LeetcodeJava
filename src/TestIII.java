import java.util.Comparator;

public class TestIII {
	public static void main () {
		
		
	}
	
	
	
	
	class Tuple implements Comparable<Tuple> {
		
		int val;

		public int compareTo(Tuple other) {
			return this.val - other.val;
		}
	}
	
	class Comp implements Comparator<Tuple> {
		public int compare(Tuple t1, Tuple t2) {
			return t1.val - t2.val;
		}
	}
}
