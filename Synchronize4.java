/**
 修饰一个静态的方法
*/
class SyncThread implements Runnable {
   private static int count;
 
   public SyncThread() {
      count = 0;
   }
 
   public synchronized static void method() {
      for (int i = 0; i < 5; i ++) {
         try {
            System.out.println(Thread.currentThread().getName() + ":" + (count++));
            Thread.sleep(100);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
 
   public synchronized void run() {
      method();
   }
}
 
public class Demo{
	
	public static void main(String args[]){
		SyncThread syncThread1 = new SyncThread();
		SyncThread syncThread2 = new SyncThread();
		Thread thread1 = new Thread(syncThread1, "SyncThread1");
		Thread thread2 = new Thread(syncThread2, "SyncThread2");
		thread1.start();
		thread2.start();
	}
}

/**
输出结果：
SyncThread2:0
SyncThread2:1
SyncThread2:2
SyncThread2:3
SyncThread2:4
SyncThread1:5
SyncThread1:6
SyncThread1:7
SyncThread1:8
SyncThread1:9

syncThread1和syncThread2是SyncThread的两个对象，但在thread1和thread2并发执行时却保持了线程同步。这是因为run中调用了静态方法method，
而静态方法是属于类的，所以syncThread1和syncThread2相当于用了同一把锁。
*/
