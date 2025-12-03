package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.example.dao.BaseDao;
import com.example.dao.UserDao;
import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.AuthService;
import com.example.strategy.AuthenticationStrategy;
import com.example.strategy.DatabaseAuthentication;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private BaseDao basedao;
	private final UserDao userDao = new UserDao(basedao);
	private final AuthService authService = new AuthService(
	        new DatabaseAuthentication(userDao) // DatabaseAuthentication戦略を注入
	    );
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String forwardPath = "login_index.jsp";
		
		// 4. index.jspにフォワード（結果を渡しながら遷移）
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean loginSuccess = false;
		

		String UserName = request.getParameter("UserName");
		String mailAddress = request.getParameter("mailAddress");
	    String UserPassword = request.getParameter("UserPassword");
	    loginSuccess = authService.login(mailAddress, UserPassword);
	    
		//セッションからユーザーデータを取得
		HttpSession session           = request.getSession();
		User userInfoOnSession = (User)session.getAttribute("LOGIN_INFO");
	    
	    
		String forwardPath;	    
		if(userInfoOnSession != null) {
			response.sendRedirect("login");
		}
		
	    if(loginSuccess) {
	    	User loggedInUser = userDao.findUserName(mailAddress);
	    		if(loggedInUser != null) {
	    			String usernamefromdb = loggedInUser.getUserName();
	                // 【✨修正箇所✨】認証成功時: リダイレクトを使ってURLを変更する
	                
	                // 1. セッションにログイン状態を記録 (推奨)
	    	    	request.getSession().setAttribute("UserName", usernamefromdb);
	                request.getSession().setAttribute("isLoggedIn", true); 
	                request.getSession().setAttribute("mailAddress", mailAddress);
	                // 2. リダイレクトを実行
	                // request.getContextPath() で /ResavationPlatForm のようなコンテキストルートを取得
	                forwardPath = "/index.jsp"; 

	                // 3. フォワードを実行
	                RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
	                dispatcher.forward(request, response);

	                return;
	    		} else {
	    			
	    		}
	    }
	    
	  //ログイン失敗後の画面遷移は、そのまま
		forwardPath = "login_index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
	    dispatcher.forward(request, response);
	
	}

}
