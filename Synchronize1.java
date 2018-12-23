/**
** synchronize修饰一个代码块
** 一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞
*/
class SyncThread implements Runnable {
	   private static int count;
 
	   public SyncThread() {
	      count = 0;
	   }
 
	   public  void run() {
	      synchronized(this) {
	         for (int i = 0; i < 10; i++) {
	            try {
	               System.out.println(Thread.currentThread().getName() + ":" + (count++));
	               Thread.sleep(100);
	            } catch (InterruptedException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	   }
  public int getCount(){
    return count;
 
}
 
public class Demo00 {
	public static void main(String args[]){
//test01
//		SyncThread s1 = new SyncThread();
//		SyncThread s2 = new SyncThread();
//		Thread t1 = new Thread(s1);
//		Thread t2 = new Thread(s2);
//test02		
		SyncThread s = new SyncThread();
		Thread t1 = new Thread(s);
		Thread t2 = new Thread(s);
		
		t1.start();
		t2.start();
	}
}

/**
输出结果：
Thread-0:0
Thread-0:1
Thread-0:2
Thread-0:3
Thread-0:4
Thread-1:5
Thread-1:6
Thread-1:7
Thread-1:8
Thread-1:9

当两个并发线程(thread1和thread2)访问同一个对象(syncThread)中的synchronized代码块时，在同一时刻只能有一个线程得到执行，另一个线程受阻塞，
必须等待当前线程执行完这个代码块以后才能执行该代码块
*/

