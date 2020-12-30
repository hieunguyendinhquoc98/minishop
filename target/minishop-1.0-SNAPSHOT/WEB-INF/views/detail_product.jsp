<%--
  Created by IntelliJ IDEA.
  User: Hieu Nguyen Dinh Quoc
  Date: 12/23/2020
  Time: 12:29
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi Tiết</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div id="header-detail" class="container-fluid">
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
                <a class="navbar-brand" href='<c:url value="/"/>'><img alt="icon_yame" src = '<c:url value="/resources/image/icon_shop.png"/>'/></a>
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
                    <li id="cart">
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
</div>

<div class="container">
    <div class="row" style="margin-top: 16px">
        <div class="col-sm-2 col-md-2">
            <h2>Danh Mục</h2>
            <ul class="myMenu">
                <c:forEach var="productIndex" items="${listProductIndex}">
                    <li><a href='<c:url value="/product/${productIndex.madanhmuc}/${productIndex.tendanhmuc}"/>'>${productIndex.tendanhmuc}</a></li>
                    <li role="separator" class="divider"></li>
                </c:forEach>
            </ul>
        </div>
        <div class="col-sm-8 col-md-8">
            <div class="row">
                <div class= "col-sm-4 col-md-4">
                    <img id ="img-product-detail" src = '<c:url value="/resources/image/sanpham/${productById.hinhsanpham}"/> ' /><br>
                </div>
                <div class="col-sm-8 col-md-8">
                    <h3 id ="tensp">${productById.tensanpham}</h3>
                    <h4 id ="giatien" data-value="${productById.giatien}">${productById.giatien}đ</h4>
                    <table class="table">
                        <thead>
                        <tr>
                            <td><h4>Màu</h4></td>
                            <td><h4>Size</h4></td>
                            <td><h4>Số lượng</h4></td>
                        </tr>
                        </thead>
                        <c:forEach var="detailedProduct" items="${productById.chitietsanpham}">
                            <tbody>
                            <tr>
                                <td class="mau" data-mamau="${detailedProduct.mausanpham.mamau}" data-masp="${detailedProduct.sanpham.masanpham}">${detailedProduct.mausanpham.tenmau}</td>
                                <td class="size" data-masize="${detailedProduct.sizeSanPham.masize}">${detailedProduct.sizeSanPham.size}</td>
                                <td class="soluong">${detailedProduct.soluong}</td>
                                <td><button data-machitiet="${detailedProduct.machitietsanpham}" class="btn btn-success btn-cart">Giỏ hàng</button></td>
                            </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-sm-2 col-md-2">
            <span>
                ${productById.mota}
            </span>
        </div>
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

