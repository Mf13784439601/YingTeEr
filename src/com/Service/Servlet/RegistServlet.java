package com.Service.Servlet;



import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import com.Service.Bean.User;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		User user =new User();
		String username=request.getParameter("username");
		user.setUsername(username);
		System.out.println(user.getUsername());
		try {
			//BeanUtils.populate(user,request.getParameterMap());
			
			if(username.equals("root")) {
				String message2="不好意思，用户名已存在，请重新输入！！！";
				response.getWriter().write(message2);
				request.setAttribute("message2",message2);
				 response.setHeader("refresh","2;url="+request.getContextPath()+"/login.jsp");
				
			
			}else {//用户名已存在的情况下
				response.getWriter().write("注册成功！将在两秒后跳到登陆页面");
				System.out.println("注册成功\n");
		        response.setHeader("refresh","2;url="+request.getContextPath()+"/login.jsp");
			}
	
			
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
