
public class BillSingleton {
	private BillSingleton() {};
	
	private static class SingletonHelper {
		private static final BillSingleton instance = new BillSingleton();
	}
	
	public BillSingleton getInstance() {
		return SingletonHelper.instance;
	}
}