import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * Description:查看请求中的各方面信息
 * User: TL
 * Date: 2022-03-08
 * Time: 17:40
 */
@WebServlet("/showRequest")
public class ShowRequsetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        //将所有信息都拼接到StringBuilder中
        StringBuilder html = new StringBuilder();
        html.append(req.getProtocol());//请求协议的名称和版本 - HTTP 1.1
        html.append("<br>");
        html.append(req.getMethod());//请求的HTTP方法 - GET
        html.append("<br>");
        html.append(req.getRequestURI());//URL
        html.append("<br>");
        html.append(req.getContextPath());//ContextPath
        html.append("<br>");
        html.append(req.getQueryString());//QueryString
        html.append("<br>");
        html.append("<br>");
        html.append("<br>");
        html.append("<br>");
        //请求的Header头中的所以头名，返回类型为枚举
        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) { //表示枚举的下一个元素
            String headerName = headers.nextElement();
            html.append(headerName);
            html.append(": ");
            html.append(req.getHeader(headerName));//返回指定请求头对应的的value值
            html.append("<br>");
        }
        resp.getWriter().write(html.toString());
    }
}

