<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ログアウト | 予約ナビ</title>
<link rel="stylesheet" href="./css/style.css">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;700&display=swap"
	rel="stylesheet">
<style>
/* ログイン画面専用のスタイルを流用 */
.logout-container {
	max-width: 450px;
	margin: 80px auto; [cite_start]/* login_index.jspを参考に設定 [cite: 2] */
	background-color: white;
	padding: 40px;
	border-radius: 15px;
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
	text-align: center;
}

.logout-container h2 {
	margin-bottom: 30px;
	color: #e91e63; [cite_start]/* ポップなピンク [cite: 3] */
}

.logout-btn {
	width: 100%;
	padding: 15px;
	margin-top: 20px;
	background-color: #f44336; /* ログアウトは警告色 (赤系) に変更 */
	color: white;
	border: none;
	border-radius: 8px;
	font-size: 1.1em;
	font-weight: 700; [cite_start]/* login_index.jspを参考に設定 [cite: 6] */
	cursor: pointer;
	transition: background-color 0.3s;
}

.logout-btn:hover {
	background-color: #d32f2f;
}

.return-link {
    margin-top: 25px;
    font-size: 0.95em;
}

.return-link a {
	color: #e91e63; [cite_start]/* ポップなピンク [cite: 7] */
	text-decoration: none;
	font-weight: 700;
}
</style>
</head>
<body>

	<header class="pop-header">
		<h1>🍣 日野ナビ</h1>
		<nav class="nav-bar">
			<a href="index.html">ホーム</a> <a href="#">ランキング</a>
		</nav>
	</header>

	<main class="container">

		<div class="logout-container">
			<h2>🚪 ログアウト確認</h2>

			<%-- ログアウト処理を実行するサーブレットにリクエストを送るフォーム --%>
			<form action="LogoutServlet" method="POST">
                <%-- ログアウト時の確認メッセージ（必要に応じて） --%>
                <p style="margin-bottom: 30px;">現在ログイン中です。ログアウトしますか？</p>
                
				<button type="submit" class="logout-btn">ログアウトする</button>
                
                <%-- ログアウトサーブレットからメッセージが渡された場合、それを表示 --%>
                <%-- ログアウト処理後のメッセージやエラーメッセージの表示に使用 --%>
                <p style="color: #4CAF50; margin-top: 15px;">${logoutMessage}</p>
			</form>

			<div class="return-link">
				<p>または</p>
                <%-- ログイン画面に戻るためのリンク --%>
				<a href="/LoginServlet">ログイン画面に戻る</a>
			</div>

		</div>

	</main>

	<footer class="pop-footer">
		<p>&copy; [cite_start]2025 日野ナビ予約システム</p> [cite: 8]
	</footer>

</body>
</html>