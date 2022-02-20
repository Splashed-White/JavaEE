package 多线程;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: TL
 * Date: 2022-01-13
 * Time: 0:02
 */

/**
 * 线程状态
 * NEW Thread对象有了，但内核中的线程PCB还没有；任务布置了，但是还没开始执行
 * RUNNABLE 表示当前线程正在CPU上运行或者已经准备好随时上CPU. 有一个专门的就绪队列来维护
 * BLOCKED、WAITING、TIMED_WAITING 阻塞状态.当前线程暂时停了下来，不会继续到CPU上执行.等到时机成熟才有机会进行
 * TERMINATED 内核中的线程已经结束，对应PCB已经被销毁，但是代码中的Thread对象还在(这个对象得等GC来回收)
 *
 * isAlive 线程存活. 除了NEW和TERMINATED,其他状态都表示线程存活(看PCB是否存活)
 */
public class ThreadDemo13 {
    public static void main(String[] args) {
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }
    }
}