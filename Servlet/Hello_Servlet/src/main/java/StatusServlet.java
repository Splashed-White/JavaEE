import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:为响应设置状态码
 * User: TL
 * Date: 2022-03-09
 * Time: 15:06
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setContentType("text/html;charset=utf-8");
//      String status = req.getParameter("status");
        String status = "405";
        if(status != null){
            resp.setStatus(Integer.parseInt(status));
        }
        resp.getWriter().write("status = " + status);
    }
    //抓包后显示响应的状态码为405
}
