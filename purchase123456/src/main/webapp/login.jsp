<%--
  Created by IntelliJ IDEA.
  User: 张余良
  Date: 2021/9/8
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>采购系统登录页面</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
    <style>
        body{
            background: aliceblue;
        }
        .red{
            color: red;
            font-size: 12px;
        }
        .green{
            color: black;
            font-size: 12px;
        }
        .head{
            width: 600px;
            height: 80px;
            background: white;
            color: blue;
            position: relative;
            top: 100px;
        }
        .body{
            position: relative;
            top: 200px;
            width: 600px;
        }
        td{
            width: 170px;
            text-align: center;
            height: 75px;
        }
        .tp{
            width: 200px;
            height: 30px;
            border: 1px solid aqua;
        }

        .btn{
            background-image: linear-gradient(white,darkseagreen);
            color: black;
            width: 150px;
            border-radius: 15px;
            font-size: 20px;
            font-weight:bold ;

        }
        h1{
            position: relative;
            top: 3px;
            right: 20px;
        }
        h3{
            position: relative;
            top: 8px;
            right: 20px;
        }
        a{
            margin-left: 40px;
            margin-right: 40px;
            color: blue;
        }

    </style>
</head>
<body>
<div>
    <div class="layui-col-lg-offset4 layui-col-lg-4 head" align="center">
        <h1>采购管理系统</h1>
        <h3>登录页面</h3>
    </div>
    <div class="layui-col-lg-4 layui-col-lg-offset4 body" align="center">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" class="tp" name="sno" id="sno"></td>
                <td><span id="snomsg"></span></td>
            </tr>
            <tr>
                <td>密 &nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                <td><input type="password" class="tp" id="pwd" name="pwd"></td>
                <td><span id="pmsg"></span></td>
            </tr>
        </table>
        <input class="layui-btn btn" id="submit" type="button" value="登 录">

    </div>
</div>
<script>

    layui.use("table",function () {
        var $ = layui.$
        var layer = layui.layer
        $("#sno").focus(function () {
            $("#snomsg").text("请输入你的用户名").addClass("green")
        }).blur(function () {
            var sno = this.value
            var snoReg = /^[\u4e00-\u9fa5]{2,}$/
            if(snoReg.test(sno)){
                $("#snomsg").text("用户名格式正确").addClass("green")
            }else {
                $("#snomsg").text("用户名至少由2个汉字组成").removeClass("green").addClass("red")
            }
        })
        $("#pwd").focus(function () {
            $("#pmsg").text("请输入密码").addClass("green")
        }).blur(function () {
            var pwd = this.value
            var pwdReg = /^[0-9a-zA-Z]{6,18}$/
            if(pwdReg.test(pwd)){
                $("#pmsg").text("密码格式正确").addClass("green")
            }else {
                $("#pmsg").text("密码由6-18位数字、字母组成").removeClass("green").addClass("red")
            }
        })

        $("#submit").click(function () {
            if ("用户名格式正确"==$("#snomsg").text()){
                if ("密码格式正确"==$("#pmsg").text()){
                    $.ajax({
                        url:"/Login"
                        ,data:{"sno":$("#sno").val(),"pwd":$("#pwd").val()}
                        ,type:"post"
                        ,success:function (data) {
                            debugger
                            if (data == "true"){
                                window.location.href = "purchaseRemu.jsp"
                            }else {
                                layer.alert("用户名或密码错误")
                            }
                        }
                    })
                }else {
                    layer.msg("密码格式不正确")
                    $("#pwd").select()
                }
            }else {
                layer.msg("用户名格式不正确")
                $("#sno").select()
            }
        })
    })
</script>
</body>
</html>
