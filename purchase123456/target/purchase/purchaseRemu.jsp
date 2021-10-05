<%--
  Created by IntelliJ IDEA.
  User: 张余良
  Date: 2021/9/15
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>采购管理系统</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
    <style>
        .th{
            font-size: 15px;
        }
        .td{
            font-size: 10px;
        }
    </style>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">采购管理系统</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="">
                    <img src="static/images/01.jpeg" class="layui-nav-img">
                    ${sessionScope.name}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="login.jsp">退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll left">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item">
                    <a href="javascript:;" class="th">采购信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="purchaseList.jsp" class="td">采购信息列表</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <%--        使用iframe实现页面显示--%>
        <iframe id="iframe-body" src="purchaseList.jsp" frameborder="0" style="width: 100%;height: 100%"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->

    </div>
</div>

<script>
    //JS
    layui.use(['element', 'layer', 'util'], function(){
        var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,$ = layui.$;

        //改变a标签原有的动作，手动给他添加动作，让a标签指向的路径显示在iframe层中
        $(".left a").click(function (e) {
            e.preventDefault()

            //动态改变iframe的src属性
            $("#iframe-body").attr("src",$(this).attr('href'))
        })
        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function(othis){
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            ,menuRight: function(){
                layer.open({
                    type: 1
                    ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    ,area: ['260px', '100%']
                    ,offset: 'rt' //右上角
                    ,anim: 5
                    ,shadeClose: true
                });
            }
        });

    });
</script>
</body>
</html>