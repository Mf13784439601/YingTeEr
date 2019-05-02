package com.Service.Servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

/**
 * Servlet implementation class CheckCode
 */
@WebServlet("/CheckCode")
public class CheckCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CheckCode() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ValidateCode vCode=new ValidateCode(120, 35, 4, 9);
	  vCode.write(response.getOutputStream());
          	//CheckCode(request,response);
		request.getSession().setAttribute("checkcode",vCode.getCode());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     	//request.getSession().setAttribute("checkcode",CheckCode(response));
		doGet(request,response);
	}
	private void CheckCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int width = 80;
		int height = 30;
		//在内存中创建一个图像对象
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//创建一个画笔
		Graphics g = img.getGraphics();
		
		//给图片添加背景色
		g.setColor(Color.PINK);//设置一个颜色
		g.fillRect(1, 1, width-2, height-2);//填充颜色
		
		//给边框一个色
		g.setColor(Color.RED);
		g.drawRect(0, 0, width-1, height-1);//设置边框的显示坐标
		
		//设置文本样式
		g.setColor(Color.BLUE);
		g.setFont(new Font("宋体", Font.BOLD|Font.ITALIC, 15));
		
		//给图片添加文本
		Random rand = new Random();
		int position = 15;
		String checkcode = "";
		int random;
		for (int i = 0; i < 4; i++) {
			random=rand.nextInt(10);
			checkcode+=Integer.toString(random);
			g.drawString(random+"", position, 15);//给图片填充文本
			position+=15;
		}
		
		//添加9条干扰线
		for (int i = 0; i < 9; i++) {
			g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));
		}
		//将图片对象以流的方式输出的客户端
		request.getSession().setAttribute("checkcode",checkcode);
		ImageIO.write(img, "jpg", response.getOutputStream());
	   
	}
	
}
