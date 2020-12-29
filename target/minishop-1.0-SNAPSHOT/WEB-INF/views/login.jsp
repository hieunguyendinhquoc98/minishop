<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 12/9/2020
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <jsp:include page="header.jsp"/>
</head>
<body id = "body-login">
    <div id = "body-flex-login">
        <div id = "container-login">
            <div id = "container-login-left">
                <div id = "header-top-left" class="header-login">
                    <span id = "text-logo">Welcome</span><br>
                    <span id = "hint-text-logo">Make Your Style With MiniShop</span>
                </div>
                <div id = "header-bottom-left">
                    <p><img alt="icon_oval" src = '<c:url value="/resources/image/icon_oval.png"/> ' /><span>Luôn cập nhật xu hướng thời trang mới nhất</span></p>
                    <p><img alt="icon_oval" src = '<c:url value="/resources/image/icon_oval.png"/> ' /><span>Giảm hơn 50% tất cả các mặt hàng cho khách VIP</span></p>
                    <p><img alt="icon_oval" src = '<c:url value="/resources/image/icon_oval.png"/> ' /><span>Tận tình tư vấn để tạo nên phong cách của bạn</span></p>
                </div>
            </div>

            <div id = "container-login-right">
                <div id="header-top-right" class="header-login">
                    <span class="actived" id="loginText">Đăng nhập </span>/<span id="signupText"> Đăng ký</span>
                </div>
                <div>
                    <div class="container-login-field" id="container-center-login-right">
                        <input id="email" name="email" class="material-text-input input-icon-email" type="text" placeholder="Email"/><br><p></p>
                        <input id="matkhau" name="matkhau" class="material-text-input input-icon-password" type="password" placeholder="Password"/><br>
                        <input id="btnDangNhap" class="material-primary-button" type="submit" value="ĐĂNG NHẬP"/><br>
                    </div>
                    <div class="container-signup-field" id="container-center-signup-right">
                        <form action="" method="post">
                            <input id="email" name="email" class="material-text-input input-icon-email" type="text" placeholder="Email"/><br><p></p>
                            <input id="matkhau" name="matkhau" class="material-text-input input-icon-password" type="password" placeholder="Password"/><br><p></p>
                            <input id="nhaplaimatkhau" name="nhaplaimatkhau" class="material-text-input input-icon-password" type="password" placeholder="Retype Password"/><br>
                            <input id="btnDangKy" class="material-primary-button" type="submit" value="ĐĂNG KÝ"/><br>
                        </form>
                    </div>
                    <p></p>
                    <span id="ketqua" class="text-danger">Kết quả</span><br>
                    <span>${checkSignUp}</span>

                </div>
                <div id="container-social-login">
                    <img alt="icon_oval" src = '<c:url value="/resources/image/icon_facebook.png"/> ' href="https://www.facebook.com/hieunguyendinhquoc98"/>
                    <img alt="icon_oval" src = '<c:url value="/resources/image/icon_google.png"/> ' href="https://www.facebook.com/hieunguyendinhquoc98" />
                </div>
            </div>
        </div>
    </div>

</body>
<jsp:include page="footer.jsp"/>
</html>
