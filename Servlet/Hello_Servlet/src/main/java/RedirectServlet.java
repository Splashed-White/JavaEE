import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:重定向，返回一个重定向HTTP响应，自动跳转至另一个页面
 * User: TL
 * Date: 2022-03-09
 * Time: 15:59
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setContentType("text/html;cgarset=utf-8");
        //用户访问这个路径的时候, 直接重定向到搜狗主页
//        resp.setStatus(302);
//        resp.setHeader("Location","https://www.sogou.com");
        resp.sendRedirect("https://www.sogou.com");//等同于上面两行代码的功能
    }
}
