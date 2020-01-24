package com.company;
/*
* servlet的生命周期
*
* */
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "BasicServlet",
        urlPatterns = {"/basic","/basic1"}
        )
public class BasicServlet extends javax.servlet.http.HttpServlet {

    public BasicServlet() {//第1步，手写默认构造器（程序执行的第1步）
        System.out.println("执行至默认构造器");
    }

    //第2步，重写init方法（一般用第二个）（程序执行的第2步）
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("执行至init方法");
    }

    //自动生成（程序执行的第3步）
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request,response);
    }

    //自动生成（程序执行的第4步）
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");//告诉浏览器文件格式
        response.setCharacterEncoding("UTF-8");//告诉浏览器文件编码

        PrintWriter out = response.getWriter();//过滤输出以下内容

        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>hello world</h1>");
        out.println("</body>");
        out.println("</html>");

        out.flush();//flush方法强制将缓冲区所有的数据输出
        out.close();
    }

    //第3步，重写destroy方法（一般不用写，JVM自动垃圾回收机制）（程序执行的第5步）
    @Override
    public void destroy() {
        super.destroy();
    }
}
