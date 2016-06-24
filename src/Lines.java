import java.util.*;

class Pair {
	int t;
	double val;

	public Pair (int t, double val) {
		this.t = t;
		this.val = val;
	}
}

public class Lines {

	public List<Pair> mergeLine(List<Pair> a, List<Pair> b) {

		if (a == null || a.size() == 0) return b;
		if (b == null || b.size() == 0) return a;
			
		Pair pa1 = a.get(0), pa2;
		Pair pb1 = b.get(0), pb2;

		List<Pair> c = new LinkedList<Pair>();

		int i;
		int index_a, index_b;

		if (pa1.t > pb1.t) {
			i = pa1.t;
			pa2 = pa1;
			pb2 = b.get(1);
			index_a = 1;
			index_b = 2;			
		} else if (pa1.t < pb1.t) {
			i = pb1.t;
			pb2 = pb1;
			pa2 = a.get(1);
			index_b = 1;
			index_a = 2;
		} else {
			i = pa1.t;
			pa2 = pa1;
			pb2 = pb1;
			index_a = 1;
			index_b = 1;
		}


		for (; pb2 != null && pa2 != null; i++) {					
			double cval = 0;			
			cval = getVal(i, pa1, pa2) + getVal(i, pb1, pb2);

			Pair pc = new Pair(i, cval);																
			c.add(pc);

			if (pa2.t == i) {
				pa1 = pa2;
				if (index_a < a.size()) {
					pa2 = a.get(index_a++);
				} else {
					pa2 = null;
				}
				
			} 

			if (pb2.t == i) {
				pb1 = pb2;
				if (index_b < b.size()) {
					pb2 = b.get(index_b++); 
				} else {
					pb2 = null;
				}
				
			}
		}

		return c; 
	}

	double getVal(int i, Pair p1, Pair p2) {
		double ret = p1.val + (double)(i - p1.t)/(p2.t - p1.t)*(p2.val - p1.val);
		return ret;
	}
}