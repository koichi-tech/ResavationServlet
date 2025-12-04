package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LogOutServlet
 */

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 既存セッションの取得 (セッションがなければ新規作成しないよう false を指定)
		HttpSession session = request.getSession(false); 
		
		// 2. セッションが存在する場合、セッションを無効化する（ログアウト処理の核）
		if (session != null) {
		    // セッションを破棄し、セッションに保存されていた情報をすべて削除する
		    session.invalidate(); 
		}
		
		// 3. ログインページへリダイレクト
		// LoginServlet の URL または ログイン画面の JSP へリダイレクトする
		response.sendRedirect(request.getContextPath() + "/LoginServlet");
        
        // 処理が完了したので return
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// ログアウトは通常 GET で処理するため、doPost は空または削除して良い
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 基本的に doGet で処理するため、ここでは doGet に処理を委譲するか、空にしておく
		doGet(request, response);
	}

}
