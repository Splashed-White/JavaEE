package 多线程;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: TL
 * Date: 2022-01-12
 * Time: 22:44
 */

/**
 * 主线程和新线程 谁先执行 不一定
 * 所以join()方法 就是为了控制线程结束的先后顺序
 */
public class ThreadDemo12 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是线程1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是线程2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t1.start();
        t2.start();
        t1.join();  // join 起到的效果是等待线程结束. 当执行到这行代码是, 程序就阻塞了. 一直阻塞到 t1 结束, 才会继续执行.
        t2.join();
        System.out.println("主线程执行完毕了");
    }
}