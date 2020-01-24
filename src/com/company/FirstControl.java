package com.company;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        name = "FirstControl",
        urlPatterns = {"/first"},
        initParams = {
                @WebInitParam(name = "red", value = "red.html"),
                @WebInitParam(name = "yellow", value = "yellow.html"),
                @WebInitParam(name = "blue", value = "blue.html"),
        }
)
public class FirstControl extends HttpServlet {

    private Map<String,String> map=new HashMap();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String red = config.getInitParameter("red");//将相应文件取出来
        String yellow = config.getInitParameter("yellow");//将相应文件取出来
        String blue = config.getInitParameter("blue");//将相应文件取出来

        map.put("red",red);
        map.put("yellow",yellow);
        map.put("blue",blue);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        String path = map.get(action);

        RequestDispatcher dispatcher = request.getRequestDispatcher(path);//转向：是一个服务器行为，用户请求到达服务器之后，在服务器内部完成对请求的处理以及转发操作，然后将相应的资源返回给客户端

        dispatcher.forward(request,response);//java版的forward，将request、response两个对象传到页面（path），若没能传到，显示空白页面
    }
}
