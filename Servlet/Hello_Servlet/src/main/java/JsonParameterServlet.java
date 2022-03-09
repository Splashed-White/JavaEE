import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: TL
 * Date: 2022-03-09
 * Time: 13:58
 */
class UserInfo{
    public String username;
    public String password;
}
@WebServlet("/jsonParameter")
public class JsonParameterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        /**
         * 约定 HTTP请求 格式为 POST/jsonParameter
         * {
         *      username:"123",
         *      password:"456"
         * }
         */
        resp.setContentType("text/html;charset=utf-8");

        //1. 先将整个请求的 body 都取出来
        String body = readBody(req);
        System.out.println(body);
        //2. 再按照 json 的格式进行解析
        // json反序列化 - json 转 java类
        /**
         * 第三方库jackson
         * 对于 json 的解析，java标准库中没有内置的方法，Servlet也没有相应的方法，所以需要引入第三方库jackson[spring官方推荐]
         * 针对 json 数据进行解析，将其变成键值对的结构/对象
         * ObjectMapper是 json 操作的核心，Jackson的所有 json 操作都是在ObjectMapper中实现。
         */
        ObjectMapper objectMapper = new ObjectMapper();
        UserInfo userInfo = objectMapper.readValue(body,UserInfo.class);
        resp.getWriter().write("username = " + userInfo.username + "<br>" + "password = " + userInfo.password);

    }

    //通过该方法取出请求的整个body
    private String readBody(HttpServletRequest req) throws IOException {
        //1. 先拿到 body 的长度，
        // getContentLength()以字节为单位返回请求 body 的长度，并提供输入流
        int contentLength = req.getContentLength();
        //2. 创建一个字节数组，来存放 body的内容
        byte[] buffer = new byte[contentLength];
        //3. 获取到InputStream 对象
        //InputStream getInputStream():用于读取请求的 body 内容.
        // 返回一个 InputStream 对象(文件操作).
        InputStream inputStream = req.getInputStream();
        //4.读取文件:从InputStream对象中，读取数据，放到buffer这个字节数组中
        inputStream.read(buffer);
        //5. 得到的结果构造成一个String
        return new String(buffer, "UTF-8");
    }
}
