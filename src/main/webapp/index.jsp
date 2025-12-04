<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>🍽️ ポップなレストラン予約ナビ</title>
    <link rel="stylesheet" href="./css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>

    <header class="pop-header">
        <h1>🍣 日野ナビ</h1>
        <nav class="nav-bar">
            <a href="${pageContext.request.contextPath}/ResavationPlatForm">ホーム</a>
            <a href="">ランキング</a>
            <a href="/mypage" id ="UserName" name="UserName">${sessionScope.LOGIN_INFO.userName}</a>
            <a href="${pageContext.request.contextPath}/LogoutServlet" id ="Logout" name="Logout">ログアウト</a>
        </nav>
    </header>

    <main class="container">

        <section class="recommendations">
            <h2>✨ おすすめのレストラン</h2>
            <div class="card-grid">
                <div class="restaurant-card">
                    <div class="card-image-placeholder"></div>
                    <p class="card-title">店舗A</p>
                </div>
                <div class="restaurant-card">
                    <div class="card-image-placeholder"></div>
                    <p class="card-title">店舗B</p>
                </div>
                <div class="restaurant-card">
                    <div class="card-image-placeholder"></div>
                    <p class="card-title">店舗C</p>
                </div>
            </div>
        </section>

        <hr>

        <section class="restaurant-list-section">
            <div class="list-header">
                <h2>🔍 レストラン一覧</h2>
                <div class="sort-controls">
                    <label for="sort">ソート機能:</label>
                    <select id="sort">
                        <option value="popular">人気順</option>
                        <option value="rating">評価順</option>
                        <option value="price">価格順</option>
                    </select>
                    <button class="search-btn">検索</button>
                </div>
            </div>

            <div class="restaurant-table">
                <div class="table-row header-row">
                    <div>店舗名</div>
                    <div>ジャンル</div>
                    <div>評価</div>
                    <div>予約</div>
                </div>
                <div class="table-row">
                    <div>わくわく食堂</div>
                    <div>和食</div>
                    <div>⭐4.5</div>
                    <button class="reserve-btn">予約する</button>
                </div>
                <div class="table-row">
                    <div>キラキラカフェ</div>
                    <div>カフェ</div>
                    <div>⭐4.2</div>
                    <button class="reserve-btn">予約する</button>
                </div>
                </div>
        </section>

    </main>

    <footer class="pop-footer">
        <p>&copy; 2025 日野ナビ予約システム</p>
    </footer>

</body>
</html>