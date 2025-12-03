<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ログイン | 予約ナビ</title>
<link rel="stylesheet" href="./css/style.css">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;700&display=swap"
	rel="stylesheet">
<style>
/* ログイン画面専用のスタイル調整 */
.login-container {
	max-width: 450px;
	margin: 80px auto;
	background-color: white;
	padding: 40px;
	border-radius: 15px;
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
	text-align: center;
}

.login-container h2 {
	margin-bottom: 30px;
	color: #e91e63; /* ポップなピンク */
}

.form-group {
	margin-bottom: 20px;
	text-align: left;
}

.form-group label {
	display: block;
	font-weight: 700;
	margin-bottom: 5px;
	color: #333;
}

.form-group input {
	width: 100%;
	padding: 12px;
	border: 1px solid #ffcdd2;
	border-radius: 8px;
	box-sizing: border-box;
	font-size: 1em;
}

.login-btn {
	width: 100%;
	padding: 15px;
	margin-top: 20px;
	background-color: #00bcd4; /* ポップな水色 */
	color: white;
	border: none;
	border-radius: 8px;
	font-size: 1.1em;
	font-weight: 700;
	cursor: pointer;
	transition: background-color 0.3s;
}

.login-btn:hover {
	background-color: #0097a7;
}

.signup-link {
	margin-top: 25px;
	font-size: 0.95em;
}

.signup-link a {
	color: #e91e63;
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

		<div class="login-container">
			<h2>🔐 ログイン</h2>

			<form action="LoginServlet" method="POST">
				<div class="form-group">
					<label for="mailAddress">メールアドレス</label> <input type="email"
						id="mailAddress" name="mailAddress" required
						placeholder="example@domain.com">
				</div>

				<div class="form-group">
					<label for="Userpassword">パスワード</label> <input type="password"
						id="UserPassword" name="UserPassword" required
						placeholder="パスワードを入力してください">
				</div>

				<button type="submit" class="login-btn">ログイン</button>
			</form>

			<div class="signup-link">
				<p>アカウントをお持ちでない方へ</p>
				<a href="signup.html">新規会員登録はこちら</a>
			</div>

		</div>

	</main>

	<footer class="pop-footer">
		<p>&copy; 2025 日野ナビ予約システム</p>
	</footer>

</body>
</html>