package monitor.scheduler.test;

public class Counter {
	
	private int count;
	private int sleep;
	
	public Counter(int sleep) {
		this.sleep = sleep;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		this.count = count;
	}
	
}
