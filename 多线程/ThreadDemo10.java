package 多线程;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: TL
 * Date: 2022-01-12
 * Time: 22:26
 */
public class ThreadDemo10 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    //System.out.println(Thread.Interrupted()); Thread静态方法
                    /**
                     *  print: false true true true...
                     *  t.interrupt被调用的时候，Thread.Interrupted()就能感知到，感知到一次以后，标记位就被清除了
                     */

                    //System.out.println(Thread.currentThread().isInterrupted()); 实例方法
                    /**
                     * print: false false false false...
                     * 仅仅是判定标记位，而不会修改标记位
                     */
                }
            }
        };
        t.start();

        t.interrupt();
    }
}