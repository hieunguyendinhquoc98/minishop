$(function (){
    $("#btnDangNhap").on("click",function (){
        var ten = $("#email").val();
        var pw = $("#matkhau").val();
        $.ajax({
            url: "/minishop/api/HandleLogin",
            type: "GET",
            cache: false,
            data: {
                email: ten,
                matkhau: pw
            },
            success: function (value) {//not affect functionality, just brackets[]
                if(value == "true"){
                    url = window.location.href;
                    url = url.replace("login/","");
                    $("#ketqua").text("Đăng nhập thành công!");
                    window.location = url;
                }else{
                    $("#ketqua").text("Đăng nhập thất bại!")
                }
            }
        })
    });
    $("#loginText").on("click",function () {
        $(this).addClass("actived");
        $("#signupText").removeClass("actived");
        $(".container-login-field").show();
        $(".container-signup-field").css("display","none");
    });
    $("#signupText").on("click",function () {
        $(this).addClass("actived");
        $("#loginText").removeClass("actived");
        $(".container-login-field").hide();
        $(".container-signup-field").show();
    });
    $(".btn-cart").on("click",function (){

        var masp = $(this).closest("tr").find(".mau").attr("data-masp");
        var mamau  = $(this).closest("tr").find(".mau").attr("data-mamau");
        var tenmau = $(this).closest("tr").find(".mau").text();
        var masize = $(this).closest("tr").find(".size").attr("data-masize");
        var soluong = $(this).closest("tr").find(".soluong").text();
        var tensize = $(this).closest("tr").find(".size").text();
        var tensp = $("#tensp").text();
        var giatien = $("#giatien").attr("data-value");
        var machitiet = $(this).attr("data-machitiet");
        $.ajax({
            url: "/minishop/api/AddCart",
            type: "GET",
            cache: false,
            data: {
                masp: masp,
                masize: masize,
                mamau: mamau,
                tensp: tensp,
                giatien: giatien,
                tenmau: tenmau,
                tensize: tensize,
                soluong: soluong,
                machitiet: machitiet
            },
            success: function (value) {//not affect functionality, just brackets[]
                $("#cart").find("div").addClass("circle-cart")
                $("#cart").find("div").html("<span>" + value + "</span>");
            }
        });
    });

    var _formatCurrency = function(amount) {
        return parseFloat(amount).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
    };
    getCheckOutSum();
    function getCheckOutSum(isEventChanged){
        var checkOutSum = 0;
        var i = 0;
        $(".giatien").each(function () {
            var soluong = $(this).closest("tr").find(".cart-quantity").val();
            var giatien = $(this).text();
            i = i+1;
            var format =  _formatCurrency(giatien);
            if(!isEventChanged){
                $(this).html(format);
                var sum = soluong * parseFloat(giatien);
            }else{
                var sum = parseFloat(giatien.replace(/[^0-9.-]+/g,""));
            }
            checkOutSum = checkOutSum + sum;
        })
        var formatCheckOut = _formatCurrency(checkOutSum);
        $("#sum").html(formatCheckOut);
    }

    $(".cart-quantity").on("change",function () {
        var soluong = $(this).val();
        var giatien = $(this).closest("tr").find(".giatien").attr("data-value");

        var sum = soluong * parseFloat(giatien);
        var format = _formatCurrency(sum);
        $(this).closest("tr").find(".giatien").html(format);
        getCheckOutSum(true);

        var masp = $(this).closest("tr").find(".tensanpham").attr("data-masp");// we should binding this by using $(this), because in cart.jsp is a forEeach function so the class and value should over the time forEach called
        var mamau  = $(this).closest("tr").find(".mau").attr("data-mamau");
        var masize = $(this).closest("tr").find(".size").attr("data-masize");
        $.ajax({
            url: "/minishop/api/UpdateCart",
            type: "GET",
            cache: false,
            data: {
                masp: masp,
                masize: masize,
                mamau: mamau,
                soluong: soluong
            },
            success: function (value) {
            }
        });
    });
    $(".btn-delete-cart").on("click", function () {
        var self = $(this);
        var masp = $(this).closest("tr").find(".tensanpham").attr("data-masp");// we should binding this by using $(this), because in cart.jsp is a forEeach function so the class and value should over the time forEach called
        var mamau  = $(this).closest("tr").find(".mau").attr("data-mamau");
        var masize = $(this).closest("tr").find(".size").attr("data-masize");
        $.ajax({
            url: "/minishop/api/DeleteCart",
            type: "GET",
            cache: false,
            data: {
                masp: masp,
                masize: masize,
                mamau: mamau,
            },
            success: function (value) {
                self.closest("tr").remove();
                getCheckOutSum(true);
                if(value == 0)
                {
                    $("#cart").find("div").removeClass("circle-cart");
                    $("#cart").find("div").html("<span>" +" " + "</span>");
                }
                $("#cart").find("div").addClass("circle-cart")
                $("#cart").find("div").html("<span>" + value + "</span>");
            }
        });
    });
    $(".paging-item").on("click", function () {
        var numberOfPage = ($(this).text()- 1 )*5;
        $.ajax({
            url: "/minishop/api/LoadProductAdmin",
            type: "GET",
            cache: false,
            data: {
                soluong: numberOfPage
            }, success: function (value){
                var tbody = $("#product-table").find("tbody");
                tbody.empty();
                tbody.append(value);
            }
        })
    });
    ///jQuery 1.5.x and below using attr
    $("#check-all").on("change", function (){
        if(this.checked){
            $("#product-table input").each(function (){
                $(this).prop("checked",true);
            })
        }else{
            $("#product-table input").each(function (){
                $(this).prop("checked",false);
            })
        }
    });
    $("#btn-delete-product-admin").on("click",function (){
        $("#product-table > tbody input:checked").each(function (){
            var masanpham= $(this).val();
            var This = $(this);
            $.ajax({
                url: "/minishop/api/DeleteProductAdmin",
                type: "GET",
                cache: false,
                data: {
                    masanpham: masanpham
                }, success: function (value){
                    if(value == "true"){
                        This.closest("tr").remove();
                    }
                }
            })
        })
    });
    var files = [];
    var tenhinh ="";
    $("#image-new-product").on("change",function (events){
        files = events.target.files;
        tenhinh = files[0].name;
        forms = new FormData();
        forms.append("file",files[0]);
        $.ajax({
            url: "/minishop/api/UploadFile",
            type: "POST",
            cache: false,
            data: forms,
            contentType: false,
            processData: false,
            enctype: "multipart/form-data",
            success: function (value){
            }
        })
    });
    $("body").on("click",".btn-chitiet",function (){
        $(this).remove();
        var chitietClone = $("#chi-tiet-san-pham-admin").clone().removeAttr("id").addClass("chitiet-sanpham");
        $("#container-chitiet-sanpham").append(chitietClone);
    });


    $("#btn-themsp").on("click", function (event){
        event.preventDefault();//prevent from load form
        var fields = $( "#form-sanpham" ).serializeArray();
        var json = {}; //json object
        var detailedProArr = [];

        $.each(fields, function(i, field){
            if(field.name !== "mausanpham" && field.name !=="sizesanpham" && field.name !=="soluong")
                json[field.name] = field.value;
        });
        $("#container-chitiet-sanpham > .chitiet-sanpham").each(function (){
            var detailProObject = {};
            mausanpham = $(this).find('select[name="mausanpham"]').val();
            sizesanpham = $(this).find('select[name="sizesanpham"]').val();
            soluong = $(this).find('input[name="soluong"]').val();
            detailProObject["mauSanPham"] = mausanpham;
            detailProObject["sizeSanPham"] = sizesanpham;
            detailProObject["soluong"] = soluong;
            detailedProArr.push(detailProObject);

        })
        json["chitietsanpham"] = detailedProArr;
        json["hinhsanpham"] = tenhinh;
        $.ajax({
            url: "/minishop/api/AddProductAdmin",
            type: "POST",
            cache: false,
            data: { dataJson: JSON.stringify(json)
            },
            success: function (value){
                if(value == "true") {
                    alert("them sp thanh cong!");
                    url = window.location.href;
                    window.location = url;
                }
            }
        })
    });

    $("#btn-cap-nhat-san-pham").on("click", function (event){
        event.preventDefault();//prevent from load form
        var fields = $( "#form-sanpham" ).serializeArray();
        var json = {}; //json object
        var detailedProArr = [];

        $.each(fields, function(i, field){
            if(field.name !== "mausanpham" && field.name !=="sizesanpham" && field.name !=="soluong")
                json[field.name] = field.value;
        });
        $("#container-chitiet-sanpham > .chitiet-sanpham").each(function (){
            var detailProObject = {};
            mausanpham = $(this).find('select[name="mausanpham"]').val();
            sizesanpham = $(this).find('select[name="sizesanpham"]').val();
            soluong = $(this).find('input[name="soluong"]').val();
            detailProObject["mauSanPham"] = mausanpham;
            detailProObject["sizeSanPham"] = sizesanpham;
            detailProObject["soluong"] = soluong;
            detailedProArr.push(detailProObject);

        })
        json["chitietsanpham"] = detailedProArr;
        json["hinhsanpham"] = tenhinh;
        json["masanpham"] = masp;
        $.ajax({
            url: "/minishop/api/UpdateProductAdmin",
            type: "POST",
            cache: false,
            data: { dataJson: JSON.stringify(json)
            },
            success: function (value){
                if(value == "true") {
                    alert("cap nhat sp thanh cong!");
                    url = window.location.href;
                    window.location = url;
                }
            }
        })
    });
    $("#btn-thoat").on("click",function (){
        $("#btn-themsp").removeClass("hidden");
        $("#btn-cap-nhat-san-pham").addClass("hidden");
        $("#btn-thoat").addClass("hidden");
    });
    var  masp = 0;
    $("body").on("click",".capnhatsanpham" ,function (){
        var masanpham = $(this).attr("data-id");

        $("#btn-cap-nhat-san-pham").removeClass("hidden");
        $("#btn-thoat").removeClass("hidden");
        $("#btn-themsp").addClass("hidden");

        $.ajax({
            url: "/minishop/api/GetProductById",
            type: "POST",
            cache: false,
            data: {
                masanpham: masanpham,
            },
            success: function (value){
                masp = value.masp;
                console.log(value);
                $("#product-name").val(value.tensanpham);
                $("#price").val(value.giatien);
                $("#description").val(value.mota);

                if(value.gianhcho === "nam"){
                    $("#rd-nam").prop('checked', true);
                }else{
                    $("#rd-nu").prop('checked', true);
                }
                $("#index").val(value.danhMucSanPham.madanhmuc);

                $("#container-chitiet-sanpham").empty();
                for(i = 0; i < value.chitietsanpham.length; i++){
                    var chitietClone = $("#chi-tiet-san-pham-admin").clone().removeAttr("id");
                    if(i < value.chitietsanpham.length - 1){
                        chitietClone.find(".btn-chitiet").remove();
                    }
                    chitietClone.find("#mau").val(value.chitietsanpham[i].mausanpham.mamau);
                    chitietClone.find("#size").val(value.chitietsanpham[i].sizeSanPham.masize);
                    chitietClone.find("#soluong").val(value.chitietsanpham[i].soluong);
                    $("#container-chitiet-sanpham").append(chitietClone);
                }
            }
        })
    });
})