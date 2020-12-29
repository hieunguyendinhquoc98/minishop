<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 12/8/2020
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
        <div id = "header" class="container-fluid">
            <nav class="navbar navbar-default none_nav">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href='<c:url value="/"/>'><img alt="icon_yame" src = '<c:url value="/resources/image/icon_shop.png"/> ' /></a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-center">
                            <li class="active"><a href='<c:url value="/"/>'>TRANG CHỦ</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">SẢN PHẨM<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <c:forEach var="productIndex" items="${listProductIndex}">
                                        <li><a href='<c:url value="/product/${productIndex.madanhmuc}/${productIndex.tendanhmuc}"/>'>${productIndex.tendanhmuc}</a></li>
                                        <li role="separator" class="divider"></li>
                                    </c:forEach>
                                </ul>
                            </li>
                            <li><a href="#">DỊCH VỤ</a></li>
                            <li><a href="#">LIÊN HỆ</a></li>

                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <c:choose>
                                <c:when test="${firstChar != null}">
                                    <li>
                                        <a class="circle-avatar" href="<c:url value="/login/"/>">
                                            <span>${firstChar}</span>
                                        </a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="<c:url value="/login/"/>">ĐĂNG NHẬP</a></li>
                                </c:otherwise>
                            </c:choose>
                            <li>
                                <a href="<c:url value="/cart/"/>"><img alt="icon_yame" src = '<c:url value="/resources/image/ic_shopping_cart.png"/> ' />
                                    <c:if test="${productQuantity > 0}">
                                        <div class="circle-cart"><span>${productQuantity}</span></div>
                                    </c:if>
                                    <c:if test="${productQuantity <=0 || productQuantity == null}">
                                        <div><span></span></div>
                                    </c:if>
                                </a>
                            </li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
            <div class="event_header container animate__animated animate__rubberBand">
                <span>Ngày 17/10 - 20/12/2020</span><br>
                <span style="font-size: 50px">MUA 1 TẶNG 1 </span><br>
                <button>XEM NGAY>></button>
            </div>
        </div>

        <div id="info" class="container-fluid">
            <div class="row">
                <div class="col-12 col-sm-4 col-md-4 animate__animated animate__fadeInLeft" style="animation-duration: 1s;animation-delay: 0.5s">
                    <img class="icon" alt="icon_quality" src = '<c:url value="/resources/image/icon_quality.png"/> ' /><br>
                    <span style="font-size: 32px; font-weight: 500">CHẤT LƯỢNG</span><br>
                    <span style="font-size: 18px">Chúng tôi cam kết mang đến cho bạn chất lượng sản phẩm tốt nhất.</span>
                </div>
                <div class="col-12 col-sm-4 col-md-4 animate__animated animate__fadeInDown" style="animation-duration: 1s; animation-delay: 1s">
                    <img class="icon" alt="icon_saving" src = '<c:url value="/resources/image/icon_saving.png"/> ' /><br>
                    <span style="font-size: 32px; font-weight: 500">TIẾT KIỆM CHI PHÍ</span><br>
                    <span style="font-size: 18px">Cam kết giá rẻ nhất Việt Nam. Chúng tôi giúp các bạn tiết kiệm hơn 20% cho từng sản phẩm.</span>
                </div>
                <div class="col-12 col-sm-4 col-md-4 animate__animated animate__fadeInUp " style="animation-duration: 1s; animation-delay: 2s">
                    <img class="icon" alt="icon_delivery" src = '<c:url value="/resources/image/icon_delivery.png"/> ' /><br>
                    <span style="font-size: 32px; font-weight: 500">GIAO HÀNG</span><br>
                    <span style="font-size: 18px">Cam kết giao hàng tận nơi trong ngày. Để mang sản phẩm đế khách hàng nhanh nhất.</span>
                </div>
            </div>
        </div>
        <div id="title_product" class="container">
                <span>SẢN PHẨM HOT</span>
                <div class="row" style="margin-top: 46px">
                    <c:forEach var="hotProduct" items="${listHotProduct}">
                        <div class="col-md-3">
                            <a href="<c:url value="/detail/${hotProduct.masanpham}"/>">
                                <div class="product animate__animated animate__zoomIn" style="animation-delay: 1s">
                                    <img alt="img" src = '<c:url value="/resources/image/sanpham/${hotProduct.hinhsanpham}"/> ' /><br>
                                    <span>${hotProduct.tensanpham}</span><br>
                                    <span class="price">${hotProduct.giatien}đ</span>
                                </div>
                            </a>

                        </div>
                    </c:forEach>
                </div>
        </div>
        <div id="footer" class="container-fluid">
            <div class="row">
                <div class="col-sm-4 col-md-4 animate__animated animate__fadeInDown">
                    <p><span class="title-footer">THÔNG TIN SHOP</span></p>
                    <span>Yame là thương hiệu thời trang đầy uy tín, luôn đảm bảo chất lượng sản phẩm tốt nhất cho khách hàng</span>
                </div>
                <div class="col-sm-4 col-md-4 animate__animated animate__fadeInDown">
                    <p><span class="title-footer">LIÊN HỆ</span></p>
                    <span>43 Nguyễn Trãi, phường 12, quận 5, TP.HCM</span><br>
                    <a href="https://www.facebook.com/hieunguyendinhquoc98/" target="_blank">Đình Hiếu</a>
                    <span>0342996991</span>
                </div>
                <div class="col-sm-4 col-md-4 animate__animated animate__fadeInDown">
                    <p><span class="title-footer">GÓP Ý</span></p>
                    <form method="post">
                        <input class="material-text-input" style="margin-bottom:  8px" type="text" placeholder="Email">
                        <textarea rows="4" cols="50" placeholder="Nội dung góp ý" style="margin-bottom:  8px"></textarea>
                        <button class="material-primary-button">Gửi</button>
                    </form>
                </div>
            </div>
        </div>
</body>
<jsp:include page="footer.jsp"/>
</html>
