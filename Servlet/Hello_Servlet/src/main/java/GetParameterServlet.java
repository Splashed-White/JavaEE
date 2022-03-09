import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description: GET方法，获取query string参数   String getParameter(String name)
 * User: TL
 * Date: 2022-03-08
 * Time: 20:59
 */
@WebServlet("/getparameter")
public class GetParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setContentType("text?html;charset=utf-8");
        /**
         * 约定query string的格式 形如：?username=123&password=456
         * String getParameter(String name)方法获取query string的参数，若参数不存在则返回null
         */
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.getWriter().write("username=" + username + "<br>" + "password=" + password);
    }
}
