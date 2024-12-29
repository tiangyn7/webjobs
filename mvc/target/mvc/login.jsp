<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>用户登录</title>
        </head>

        <body>
            <h2>用户登录</h2>
            <form action="${pageContext.request.contextPath}/login" method="post">
                用户名：<input type="text" name="userName" /><br />
                密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" /><br />
                <input type="submit" value="登录" />
            </form>
            <c:if test="${not empty errorMsg}">
                <p style="color:red;">${errorMsg}</p>
            </c:if>
        </body>

        </html>