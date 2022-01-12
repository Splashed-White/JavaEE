package 多线程;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: TL
 * Date: 2022-01-12
 * Time: 16:19
 */

/**
 * 中断一个线程 可能有两种情况：
 * 已经把任务执行完了 使用标志位终止线程
 * 任务执行了一半被强制结束：调用 interrupt() 方法
 */
public class ThreadDemo7 {
    private static boolean isQuit = false; //false说明当前线程没有结束

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (!isQuit) {
                    System.out.println("线程继续执行");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程执行被终止.");
            }
        };
        t.start();

        Thread.sleep(5000);  //哪个线程调用sleep,哪个线程就停下来
        System.out.println("终止执行任务!!!");
        isQuit = true;
    }
}

