
public class LockTest01 {

	
	static Object lock = new Object();
	static boolean b =true;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
		new Thread(){
			public void run() {
				synchronized (lock) {
					while (b){
						try {
							System.out.println("wait start");
							lock.wait();
							System.out.println("wait end");
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
				}
			};
		}.start();
		
		new Thread(){
			public void run() {
				synchronized (lock) {
					System.out.println("notify start");
					lock.notify();
					b = false;
					System.out.println("notify end");
				}
			};
		}.start();
			
	}

}
