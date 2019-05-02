package com.Service.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Service.Dao.UserDao;

/**
 * Servlet implementation class doLogin
 */
@WebServlet("/doLogin")
public class doLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  //   获取表单数据    处理业务逻辑  分发转向
	     request.setCharacterEncoding("UTF-8");
	     response.setContentType("text/html;charset=UTF-8");
	      PrintWriter out=response.getWriter();
			//分发转向  先校验验证码是否正确 在连接数据库校验是否有用户存在
			String username=  request.getParameter("username");
			
			String password=request.getParameter("password");
			String checkcode=(String) request.getSession().getAttribute("checkcode");
			String checkformcode=request.getParameter("checkcode");
		     UserDao userDao=new UserDao();
			try {	
				if(!checkformcode.equalsIgnoreCase(checkcode)) {//校验验证码是否正确
					String msg="验证码错误!";
					request.setAttribute("msg",msg);
					 request.setAttribute("checkcode1", checkcode);
					 request.setAttribute("checkcode2", checkformcode);
					 request.getRequestDispatcher("/login.jsp").forward(request, response);
				}else {//验证码正确
					if(userDao.isExit(username, password)){//校验用户是否存在
						request.getSession().setAttribute("u",username);//如果登录成功，就把manager对象放到session对象 中
						request.getRequestDispatcher("/convert.html").forward(request, response);
				}else{
					String message="用户名或密码错误！";
					request.setAttribute("message",message);
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
