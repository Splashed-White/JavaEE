package 多线程;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: TL
 * Date: 2022-01-12
 * Time: 14:29
 */
public class ThreadDemo4 {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("我是一个新线程");
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();
        /**
         * t.run() 只是一个普通的方法调用，没有创建新的线程，输出语句是在原线程中进行的
         * t.start() 这是创建了一个新线程，由新的线程来执行输出
         */
        // t.run();  //我是一个新线程
        t.start();  //我是一个新线程
    }
}












