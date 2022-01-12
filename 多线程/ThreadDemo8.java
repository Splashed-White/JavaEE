package 多线程;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: TL
 * Date: 2022-01-12
 * Time: 17:18
 */
/**
 * 中断一个线程 可能有两种情况：
 * 已经把任务执行完了 使用标志位终止线程
 * 任务执行了一半被强制结束：调用 interrupt() 方法
 */
public class ThreadDemo8 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                // 此处直接使用线程内部的标记位来判定.
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("线程继续执行");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                        //如果catch没有break相当于忽略了异常，
                        //如果break触发异常就会导致循环结束，线程也就结束了
                    }
                }
                System.out.println("线程执行被终止.");
            }
        };
        t.start();

        Thread.sleep(5000);
        System.out.println("终止执行任务!!!");
        t.interrupt();
    }
}
