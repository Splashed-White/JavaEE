import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:POST方法，获取body参数   String getParameter(String name)
 * User: TL
 * Date: 2022-03-08
 * Time: 21:22
 */
@WebServlet("/postparameter")
public class PostParameterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setContentType("text?html;charset=utf-8");
        /**
         * form表单： application/x-www-form-urlencoded
         * body格式 形如：?username=123&password=456
         * String getParameter(String name)方法获取query string的参数，若参数不存在则返回null
         */
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.getWriter().write("username=" + username + "<br>" + "password=" + password);
    }
}
