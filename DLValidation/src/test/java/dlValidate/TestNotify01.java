package dlValidate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestNotify01 {  
	  
    private Object monitor = new Object();  
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");  
    private String getTime(){  
        return format.format(Calendar.getInstance().getTime());  
    }  
  
    /**  
     * 0.首先获得对象的监视器  
     * 1.打印等待前后线程的名称和等待时间  
     * 2.线程开启  
     * @param thread  
     * @param ms  
     */  
    public void waitOnce(String thread, final Long ms) {  
        Thread waitThread = new Thread() {  
            public void run() {  
                // 对对象上锁，获得对象的监视器，用的第二种方式，对同步代码块进行上锁  
                synchronized (monitor) {  
                    try {  
                        System.out.println("Thread等待之前 " + Thread.currentThread().getName() + " Wait at" + getTime());  
                        monitor.wait(ms);  
                        System.out.println("Thread等待之后 " + Thread.currentThread().getName() + " Wait at" + getTime());  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        };  
        waitThread.setName(thread);  
        waitThread.start();  
    }  
      
    /**  
     * 0.获得对象的监视器  
     * 1.唤醒一个线程  
     * 2.睡眠两次  
     * 3.开启线程  
     * @param thread  
     * @param ms  
     */  
    public void awake(String thread, final Long ms) {  
        Thread notifyThread = new Thread() {  
            public void run() {  
                // 对对象上锁，获得对象的监视器，用的第一种方式  
                synchronized (monitor) {  
                    monitor.notify();  
                    System.out.println("Thread" + Thread.currentThread().getName() + " 唤醒 at " + getTime());  
                    try {  
                        Thread.sleep(ms);  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                }  
                try {  
                    Thread.sleep(ms);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            };  
        };  
        notifyThread.setName(thread);  
        notifyThread.start();  
    }  
      
    /**  
     * 唤醒全部线程  
     * @param thread  
     */  
    public void awakeAll(String thread) {  
        Thread notifyThread = new Thread() {  
            public void run() {  
                // 对对象上锁，获得对象的监视器，用的第一种方式  
                synchronized (monitor) {  
                    monitor.notifyAll();  
                    System.out.println("Thread" + Thread.currentThread().getName() + " 唤醒 at " + getTime());  
                }  
            };  
        };  
        notifyThread.setName(thread);  
        notifyThread.start();  
    }  
  
    public static void main(String[] args) {  
        /**  
         * 0.首先建立了一个对象  
         * 1.然后开启三个等待中的线程  
         * 2.睡眠两秒后唤醒一个线程，从线程的名称中可以看出，唤醒线程的顺序可能是按照线程开启时间来的.  
         */  
        TestNotify01 test = new TestNotify01();  
        test.waitOnce("1",Long.MAX_VALUE);  
        test.waitOnce("2",Long.MAX_VALUE);  
        test.waitOnce("3",Long.MAX_VALUE);  
        try {  
            Thread.sleep(2000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
       // test.awake("100",2000L);  
        test.awakeAll("100");  
    }  
}