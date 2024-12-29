<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>GET 和 POST 请求示例</title>
        <script>
            function sendGetRequest() {
                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        document.getElementById("result").innerHTML = xhr.responseText;
                    }
                };
                xhr.open("GET", "XHRServlet", true);
                xhr.send();
            }

            function checkUsername() {
                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        var result = document.getElementById("result");
                        result.innerHTML = xhr.responseText;
                        result.style.color = xhr.responseText === "用户名可用" ? "green" : "red";
                        document.getElementById("registerBtn").disabled = xhr.responseText !== "用户名可用";
                    }
                };
                xhr.open("POST", "XHRServlet", true);
                xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                xhr.send("todo=check&username=" + document.getElementById("username").value);
            }

            function register() {
                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        document.getElementById("result").innerHTML = xhr.responseText;
                    }
                };
                xhr.open("POST", "XHRServlet", true);
                xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                xhr.send("todo=register&username=" + document.getElementById("username").value);
            }
        </script>
    </head>

    <body>
        <h1>GET 和 POST 请求示例</h1>

        <!-- GET 请求部分 -->
        <section>
            <h2>GET 请求</h2>
            <button onclick="sendGetRequest()">发送 GET 请求</button>
        </section>

        <!-- POST 请求部分 -->
        <section>
            <h2>POST 请求</h2>
            <input type="text" id="username" onblur="checkUsername()" placeholder="请输入用户名">
            <button id="registerBtn" onclick="register()" disabled>注册</button>
        </section>

        <!-- 通用结果展示 -->
        <div id="result" style="margin-top: 20px; font-size: 16px; color: blue;"></div>
    </body>

    </html>