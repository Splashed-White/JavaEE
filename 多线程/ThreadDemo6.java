package 多线程;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: TL
 * Date: 2022-01-12
 * Time: 15:58
 */
public class ThreadDemo6 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread("张三线程") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    //Thread.currentThread() 获取到当前线程的实例 在当前代码中，相当于this
                    System.out.println(Thread.currentThread().getName()); //获取线程名字
                    /**
                     * 如果是使用继承Thread的方式 Thread.currentThread() 相当于 this
                     * 但若是使用 Runnable接口/lambda表达式 的方式，this指向的是Runnable接口的实例，就不是线程实例了
                     */
                    // System.out.println(this.getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // run 方法的执行过程就代表着系统内线程的生命周期.
                // run 方法执行中, 内核的线程就存在.
                // run 方法执行完毕, 内核中的线程就随之销毁.
                System.out.println("线程要退出了!");
            }
        };

        // 这一组属性, 只要线程创建完毕, 属性就不变了.
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.isDaemon());
        System.out.println(t.getId());
        // 这俩属性会随着线程的运行过程而发生改变.
        System.out.println(t.isAlive());
        System.out.println(t.isInterrupted());
        System.out.println(t.getState());

        t.start();

        while (t.isAlive()) {
            System.out.println("张三线程正在运行!");
            System.out.println(t.getState());
            System.out.println(t.isInterrupted());
            Thread.sleep(300);
        }
    }
}
