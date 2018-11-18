package shiyan3;

public class ThreadDemo {
	public static void main(String[] args) {
		Thread t = new TestThread();
		t.setDaemon(true);
		t.start();
		int i=0;
		while(true) {
			System.out.println("main()"+Thread.currentThread().getName()+" is running");
			if(i++ == 10000) {
				try {
					t.join(10000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class TestThread extends Thread{
	public void run() {
		while(true) {
			System.out.println("TestTread"+Thread.currentThread().getName()+" is running");
		}
	}
}
