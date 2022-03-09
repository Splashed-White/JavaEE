import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:doGET方法重写
 * User: TL
 * Date: 2022-03-08
 * Time: 15:15
 */
@WebServlet("/hello")
public class Hello_Servlet extends HttpServlet {
    //收到请求为GET方法时调用
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        /**
         * 关于乱码问题：通过resp.setContentType()显示指定响应的编码方式
         * IDEA使用的编码方式的UTF-8，浏览器的编码方式决定于系统（win10系统的编码是gbk）
         * 所以需要保证数据的解析和构造都是同一种编码方式~
         *
         */
        resp.setContentType("text/html;charset=utf-8");//告诉浏览器，body的内容是text/html,编码方式是utf-8
        /**
         * PrintWriter getWriter() : 用于往 body 中写入文本格式数据;
         * 返回类型是 PrintWriter，这是一个打印输出流
         *
         * response.getWriter().print()：不仅可以打印输出文本格式的（包括html标签），还可以将一个对象以默认的编码方式转换为二进制字节输出
         * response.getWriter().writer()：只能打印输出文本格式的（包括html标签），不可以打印对象
         */
        resp.getWriter().write("你好 Servlet");
    }
}