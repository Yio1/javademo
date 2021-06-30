package com.whpu.servlet;

import com.alibaba.fastjson.JSON;
import com.whpu.dao.UserDao;
import com.whpu.dao.UserDaoImpl;
import com.whpu.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UserLogServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //获取页面请求
        System.out.println("servlet执行操作");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //获取用户名
        String username = request.getParameter("username");// 前端页面中 表单中的 input 标签 name 属性的值,现需要提供name名称
        //获取密码
        String password = request.getParameter("password");
        //输出获取的信息
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        //一定要web.xml中配置 Servlet
        //响应页面结果
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType("text/html;charset=utf-8");


        //响应结果到页面
//        String userReg = "张明"; //模拟设置数据库中已注册的用户名和密码
//        String pwdReg = "123456";
//
//
//        if ( username.equals(userReg) && password.equals(pwdReg) ){ //用户名和密码一致
//            //响应登录成功
//            result = "登录成功！";
//        }else {
//            //响应失败
//            result = "登录失败！";
//        }


        String result = "";

        //根据输入的用户名和密码，数据库查询是否存在该用户
        //调用login（...）

        UserDao userDao = new UserDaoImpl();
        try { //运行正常时的操作
            User user = userDao.login(username, password);//实参、形参

//            System.out.println("user = " + user);

            if (user != null){ //对象的默认类型为 null
                result = JSON.toJSONString(user);
//                //跳转页面
//
//                //获取学生信息
//                StudentDao studentDao = new StudentDaoImpl();
//                List<Student> studentList = studentDao.selectAllStu();
//
//                //将数据放到请求域中，传递到页面
//                request.setAttribute("studentList",studentList);
//
//                //跳转到操作页面，同时需要传递数据（将所有学生信息）
//                request.getRequestDispatcher("jsp/showStudent.jsp").forward(request, response);
//                //请求转发
            }else {
                result = "";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        response.getWriter().print(result);

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("servlet消亡");
    }
    public void login(){

    }
}
