/**
**修饰类
*/
class SyncThread implements Runnable {
   private static int count;
 
   public SyncThread() {
      count = 0;
   }
 
   public static void method() {
      synchronized(SyncThread.class) {
         for (int i = 0; i < 5; i ++) {
            try {
               System.out.println(Thread.currentThread().getName() + ":" + (count++));
               Thread.sleep(100);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }
   }
 
   public synchronized void run() {
      method();
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
*/
