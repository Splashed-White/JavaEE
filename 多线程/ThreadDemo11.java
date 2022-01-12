package 多线程;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: TL
 * Date: 2022-01-12
 * Time: 22:38
 */

/**
 * 主线程和新线程 谁先执行 不一定
 * 所以join()方法 就是为了控制线程结束的先后顺序
 */
public class ThreadDemo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("我是新线程");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        while (true) {
            System.out.println("我是主线程");
            Thread.sleep(100);
        }
    }
}
