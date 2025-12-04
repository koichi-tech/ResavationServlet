package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
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


public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private BaseDao basedao;
	private UserDao userDao;
	private AuthService authService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    
	    // 1. BaseDaoのインスタンス化
	    this.basedao = new BaseDao();
	    
	    // 2. ★JDBCドライバのロードを実行（BaseDaoのメソッドを呼び出す）
	    this.basedao.loadDriver(); 
	    
	    // 3. 初期化済みの basedao を使って依存オブジェクトを初期化
	    this.userDao = new UserDao(this.basedao);
	    this.authService = new AuthService(
	            new DatabaseAuthentication(this.userDao) 
	    );
	}
	
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

		//ローカル変数定義
		String mailAddress = request.getParameter("mailAddress");
	    String UserPassword = request.getParameter("UserPassword");
		String forwardPath;	
	    
	    // 1. 既存セッションの有無を確認 (セッションがなければ null を返す)
	    User userInfoOnSession = null;
	    HttpSession existingSession = request.getSession(false);
	    if (existingSession != null) {
	    	userInfoOnSession = (User) existingSession.getAttribute("LOGIN_INFO");
	    }
	  	    
	    
	    // 2. 既存セッション（ログイン済み）の有無確認
	    if(userInfoOnSession != null) {
			// 既にログイン済みならリダイレクト
			response.sendRedirect(request.getContextPath() + "/ResavationPlatForm"); // 遷移先をコンテキストパス基準に修正
			return;
		}
	    
	    // 3. 認証処理実施
	    loginSuccess = authService.login(mailAddress, UserPassword);
	    
	    // 4. 認証処理結果判定
	    if(loginSuccess) {
	    	//User情報取得
	    	User loggedInUser = userDao.findUserName(mailAddress);
	    	if(loggedInUser != null) {
	    		
	    		// 【✨修正箇所✨】認証成功時: セッションを**取得（存在しない場合は新規作成）**する
	    		HttpSession session = request.getSession(); // getSession() は (true) と同等
	    		session.setAttribute("LOGIN_INFO", loggedInUser);
	    	    
	            // 2. リダイレクトを実行 (フォワードではなくリダイレクトが望ましい)
	            response.sendRedirect(request.getContextPath() + "/ResavationPlatForm");
	            return;
	    	} 
	    }
	    
	    // 5. ログイン失敗後の画面遷移
		request.setAttribute("errorMessage", "メールアドレスまたはパスワードが正しくありません。"); // エラーメッセージを追加
		forwardPath = "login_index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
	    dispatcher.forward(request, response);
	
	}
	
	
	

}
