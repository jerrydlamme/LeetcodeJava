
public class BulbSwitcher {
	 public int bulbSwitch(int n) {
	        double sq = Math.sqrt(n);
	        int i = (int)Math.round(sq);
	        
	        if (i > sq) i--;
	        
	        return i;
	    }
}
