<%--
  Created by IntelliJ IDEA.
  User: NIG4HC
  Date: 1/21/2021
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Add Product</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Pooled Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel='stylesheet' type='text/css' />
    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/style.css"/>"  rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="<c:url value="/resources/css/morris.css"/>"  type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/resources/styles/styles.css"/>"  type="text/css"/>
    <!-- Graph CSS -->
    <link href="<c:url value="/resources/css/font-awesome.css"/>"  rel="stylesheet">
    <!-- jQuery -->
    <script src="<c:url value="/resources/js/jquery-3.2.1.min.js"/>"></script>
    <script src="<c:url value="/resources/js/custom.js"/>"></script>

    <!-- //jQuery -->
    <link href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'/>
    <link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <!-- lined-icons -->
    <link rel="stylesheet" href="<c:url value="/resources/css/icon-font.min.css"/>" type='text/css' />
    <!-- //lined-icons -->
</head>
<body>
<div class="page-container">
    <div class="left-content">
        <div class="row">
            <h2>Sản phẩm</h2>
            <div class="col-md-5 col-sm-12 form-group">
                <form action="" id="form-sanpham">
                <label for="product-name">Tên sản phẩm:</label><br>
                <input id="product-name" name="tensanpham" class="form-control" type="text" placeholder="Nhập tên sản phẩm"/><br>

                <label for="price">Giá tiền:</label><br>
                <input id="price" name="giatien" class="form-control" type="number" placeholder="Nhập giá tiền"/><br>

                <span>Giành cho:</span><br>
                <label class="radio-inline"><input type="radio" name="gianhcho" value="nam">Nam</label>
                <label class="radio-inline"><input type="radio" name="gianhcho" value="nu">Nữ</label><br>

                <label for="index">Danh mục:</label>
                <select name="danhmucsanpham" class="form-control" id="index">
                    <c:forEach var="index" items="${listProductIndex}">
                        <option value="${index.madanhmuc}">${index.tendanhmuc}</option>
                    </c:forEach>
                </select><br>

                <label for="description">Mô tả:</label><br>
                <textarea rows="5"  name="mota" id="description" class="form-control" type="text" placeholder="Mô tả"></textarea><br>

                <label for="image-new-product">Hình ảnh:</label><br>
                <input id="image-new-product" class="form-control" type="file" placeholder=""/><br>

                <div id="container-chitiet-sanpham">
                    <div class="chitiet-sanpham">
                        <label>Chi tiết:</label><br>
                        <select name="sizesanpham" class="form-control" id="size">
                            <c:forEach var="index" items="${listSize}">
                                <option value="${index.masize}">${index.size}</option>
                            </c:forEach>
                        </select><br>

                        <select name="mausanpham" class="form-control" id="mau">
                            <c:forEach var="index" items="${listColor}">
                                <option value="${index.mamau}">${index.tenmau}</option>
                            </c:forEach>
                        </select><br>
                        <input min="1" value="1" name="soluong" id="soluong" class="form-control" type="number" placeholder="Số lượng"/><br>
                        <button class="btn-success btn btn-chitiet fa fa-plus-circle"> Thêm chi tiết</button>
                    </div>
                </div>
                </form>
                <div id="chi-tiet-san-pham-admin">
                        <label>Chi tiết:</label><br>
                        <select name="sizesanpham" class="form-control" id="size">
                            <c:forEach var="index" items="${listSize}">
                                <option value="${index.masize}">${index.size}</option>
                            </c:forEach>
                        </select><br>

                        <select name="mausanpham" class="form-control" id="mau">
                            <c:forEach var="index" items="${listColor}">
                                <option value="${index.mamau}">${index.tenmau}</option>
                            </c:forEach>
                        </select><br>
                        <input min="1" value="1" name="soluong" id="soluong" class="form-control" type="number" placeholder="Số lượng"/><br>
                        <button class="btn-success btn btn-chitiet fa fa-plus-circle"> Thêm chi tiết</button>
                </div>

                <br><br>
                <p>
                    <button id="btn-themsp" class="btn btn-success fa fa-cloud-upload btn-themsp">
                        Thêm sản phẩm
                    </button>
                </p>
            </div>
            <div class="col-md-7 col-sm-12">
                <!--/content-inner-->
                <table class="table" id="product-table">
                    <thead>
                    <tr>
                        <td>
                            <div class="checkbox">
                                <label><input type="checkbox" id="check-all" value=""></label>
                            </div>
                        </td>
                        <td><h4>Tên sản phẩm</h4></td>
                        <td><h4>Giá tiền</h4></td>
                        <td><h4>Giành cho</h4></td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${listSanPham}">
                        <tr>
                            <td><div class="checkbox"><label><input name="product-checkbox" type="checkbox" value="${product.masanpham}"></label></div></td>
                            <td class="tensp" data-masp="${product.masanpham}">${product.tensanpham}</td>
                            <td class="giatien" >${product.giatien}</td>
                            <td class="gianhcho">${product.gianhcho}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table><br>
                <div>
                    <button class="btn btn-danger fa fa-remove" id="btn-delete-product-admin">
                        Xoá
                    </button>
                </div>
                <ul class="pagination pagination-sm">
                    <c:forEach var="i" begin="1" end="${sumOfPage}">
                        <c:choose >
                            <c:when test="${i == 1}">
                                <li class="active paging-item"><a href="#">${i}</a></li>
                            </c:when>
                            <c:when test="${i > 1}">
                                <li class="paging-item"><a href="#">${i}</a></li>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </ul>

                <!--//content-inner-->
            </div>
        </div>



    </div>

    <!--/sidebar-menu-->
    <div class="sidebar-menu">
        <header class="logo1">
            <a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a>
        </header>
        <div style="border-top:1px ridge rgba(255, 255, 255, 0.15)"></div>
        <div class="menu">
            <ul id="menu" >
                <li><a href="<c:url value="/dashboard"/> "><i class="fa fa-tachometer"></i> <span>Dashboard</span><div class="clearfix"></div></a></li>


                <li id="menu-academico" ><a href="<c:url value="/ProductAdmin"/>"><i class="fa fa-picture-o"></i><span>Sản phẩm</span><div class="clearfix"></div></a></li>
                <li><a href="gallery.html"><i class="fa fa-picture-o" aria-hidden="true"></i><span>Gallery</span><div class="clearfix"></div></a></li>
                <li id="menu-academico" ><a href="charts.html"><i class="fa fa-bar-chart"></i><span>Charts</span><div class="clearfix"></div></a></li>
                <li id="menu-academico" ><a href="#"><i class="fa fa-list-ul" aria-hidden="true"></i><span> Short Codes</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
                    <ul id="menu-academico-sub" >
                        <li id="menu-academico-avaliacoes" ><a href="icons.html">Icons</a></li>
                        <li id="menu-academico-avaliacoes" ><a href="typography.html">Typography</a></li>
                        <li id="menu-academico-avaliacoes" ><a href="faq.html">Faq</a></li>
                    </ul>
                </li>
                <li id="menu-academico" ><a href="errorpage.html"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i><span>Error Page</span><div class="clearfix"></div></a></li>
                <li id="menu-academico" ><a href="#"><i class="fa fa-cogs" aria-hidden="true"></i><span> UI Components</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
                    <ul id="menu-academico-sub" >
                        <li id="menu-academico-avaliacoes" ><a href="button.html">Buttons</a></li>
                        <li id="menu-academico-avaliacoes" ><a href="grid.html">Grids</a></li>
                    </ul>
                </li>
                <li><a href="tabels.html"><i class="fa fa-table"></i>  <span>Tables</span><div class="clearfix"></div></a></li>
                <li><a href="maps.html"><i class="fa fa-map-marker" aria-hidden="true"></i>  <span>Maps</span><div class="clearfix"></div></a></li>
                <li id="menu-academico" ><a href="#"><i class="fa fa-file-text-o"></i>  <span>Pages</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
                    <ul id="menu-academico-sub" >
                        <li id="menu-academico-boletim" ><a href="calendar.html">Calendar</a></li>
                        <li id="menu-academico-avaliacoes" ><a href="signin.html">Sign In</a></li>
                        <li id="menu-academico-avaliacoes" ><a href="signup.html">Sign Up</a></li>


                    </ul>
                </li>
                <li><a href="#"><i class="fa fa-check-square-o nav_icon"></i><span>Forms</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
                    <ul>
                        <li><a href="input.html"> Input</a></li>
                        <li><a href="validation.html">Validation</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="clearfix"></div>
</div>
<script>
    var toggle = true;

    $(".sidebar-icon").click(function() {
        if (toggle)
        {
            $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
            $("#menu span").css({"position":"absolute"});
        }
        else
        {
            $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
            setTimeout(function() {
                $("#menu span").css({"position":"relative"});
            }, 400);
        }

        toggle = !toggle;
    });
</script>
<!--js -->
<script src="<c:url value="/resources/js/jquery.nicescroll.js"/>"></script>
<script src="<c:url value="/resources/js/scripts.js"/>" ></script>
<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" ></script>
<!-- /Bootstrap Core JavaScript -->
<!-- morris JavaScript -->
<script src="<c:url value="/resources/js/raphael-min.js"/>" ></script>
<script src="<c:url value="/resources/js/morris.js"/>" ></script>
<script>
    $(document).ready(function() {
        //BOX BUTTON SHOW AND CLOSE
        jQuery('.small-graph-box').hover(function() {
            jQuery(this).find('.box-button').fadeIn('fast');
        }, function() {
            jQuery(this).find('.box-button').fadeOut('fast');
        });
        jQuery('.small-graph-box .box-close').click(function() {
            jQuery(this).closest('.small-graph-box').fadeOut(200);
            return false;
        });

        //CHARTS
        function gd(year, day, month) {
            return new Date(year, month - 1, day).getTime();
        }

        graphArea2 = Morris.Area({
            element: 'hero-area',
            padding: 10,
            behaveLikeLine: true,
            gridEnabled: false,
            gridLineColor: '#dddddd',
            axes: true,
            resize: true,
            smooth:true,
            pointSize: 0,
            lineWidth: 0,
            fillOpacity:0.85,
            data: [
                {period: '2014 Q1', iphone: 2668, ipad: null, itouch: 2649},
                {period: '2014 Q2', iphone: 15780, ipad: 13799, itouch: 12051},
                {period: '2014 Q3', iphone: 12920, ipad: 10975, itouch: 9910},
                {period: '2014 Q4', iphone: 8770, ipad: 6600, itouch: 6695},
                {period: '2015 Q1', iphone: 10820, ipad: 10924, itouch: 12300},
                {period: '2015 Q2', iphone: 9680, ipad: 9010, itouch: 7891},
                {period: '2015 Q3', iphone: 4830, ipad: 3805, itouch: 1598},
                {period: '2015 Q4', iphone: 15083, ipad: 8977, itouch: 5185},
                {period: '2016 Q1', iphone: 10697, ipad: 4470, itouch: 2038},
                {period: '2016 Q2', iphone: 8442, ipad: 5723, itouch: 1801}
            ],
            lineColors:['#ff4a43','#a2d200','#22beef'],
            xkey: 'period',
            redraw: true,
            ykeys: ['iphone', 'ipad', 'itouch'],
            labels: ['All Visitors', 'Returning Visitors', 'Unique Visitors'],
            pointSize: 2,
            hideHover: 'auto',
            resize: true
        });
    });
</script>
</body>
</html>
