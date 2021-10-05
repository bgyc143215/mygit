<%--
  Created by IntelliJ IDEA.
  User: 张余良
  Date: 2021/9/15
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>采购列表</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
    <style>
        #bookTab{
            text-align: center;
        }
        #div1{
            margin-top: 50px;
        }
        #div2{
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div>
    <div style="text-align: center" id="div1">
        <h2>欢迎访问采购信息列表</h2>
    </div>
    <div class="layui-row" id="div2">
        <div class="layui-col-md-offset1">
            <div class="layui-form-item">
                <label class="layui-form-label">申请人</label>
                <div class="layui-input-inline">
                    <input type="text" id="filter" required  placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
                <label class="layui-form-label">申请类型</label>
                <div class="layui-input-inline">
                    <select id="type" required autocomplete="off" class="layui-input">
                        <option value="">请选择</option>
                        <option value="普通办公用品">普通办公用品</option>
                        <option value="高级办公用品">高级办公用品</option>
                        <option value="招待客户用品">招待客户用品</option>
                    </select>
                </div>
                <div class="layui-input-inline"><input type="button" id="btnQuery" value="查询" class="layui-btn">
                <input type="reset" id="reBtn" class="layui-btn" value="重置"></div>
            </div>
        </div>
        <div class="layui-col-md-offset8">
            <div class="layui-input-inline"><input type="button" id="btnAdd" value="新增" class="layui-btn">
            <input type="reset" id="btnEdit" class="layui-btn" value="编辑">
            <input type="reset" id="btnDel" class="layui-btn" value="删除"></div>
        </div>
    </div>
    <div class="layui-row">
    <div class="layui-col-md-offset1">
        <table id="purchaseTab">

        </table>
    </div>
</div>
</div>


<script>
    layui.use("table",function () {
        var table = layui.table;
        var layer = layui.layer;
        $ = layui.jquery;
        table.render({
            id: "purchaseList"//表格的js的唯一标识
            , elem: '#purchaseTab'
            , width: 920
            , height: 300
            , url: '/getPurchase' //数据接口，后台servlet的url
            //一旦开启分页，自动向后台传递两个参数，一个叫page，一个叫limit
            , page: true //开启分页
            , limit: 5//每页显示条数
            , limits: [5, 10, 15]//设置分页的条数
            , cols: [[ //表头
                //field对应的是对象的属性名称
                {type: 'checkbox'}
                ,{type:'numbers',title:'序号'}
                , {field: 'id', title: 'id', width: 80, hide:true}
                , {field: 'applyUser', title: '申请人', width: 90}
                , {field: 'applyDate', title: '申请日期', width: 120, sort: true}
                , {field: 'purchaseType', title: '采购类型', width: 135, sort: true}
                , {field: 'preCost', title: '预估金额', width: 100, sort: true}
                , {field: 'purchaseReason', title: '采购说明', width: 120, sort: true}
                , {field: 'deptAuti', title: '部门审核', width: 120, sort: true}
                , {field: 'companyAuti', title: '公司审核', width: 120, sort: true}
            ]]
        });

        $("#btnQuery").click(function () {
            var pname = $("#filter").val();
            var type = $("#type").val();
            table.reload("purchaseList", {
                where: {pnameFilter: pname,typeFilter:type}
            })
        })
        $("#reBtn").click(function () {
            $("#filter").val("");
            $("#type").val("");
            table.reload("purchaseList",{
                where: {pnameFilter: "",typeFilter:""}
            })
        })
        $("#btnAdd").click(function () {
            window.location.href = "getId"
        })

        $("#btnEdit").click(function () {
            var checkDate = table.checkStatus("purchaseList")
            if(checkDate.data.length==0){
                layer.msg("请选择要编辑的信息")
                return;
            }else if (checkDate.data.length>1){
                layer.msg("一次只能编辑一条信息")
                return;
            }
            var id = checkDate.data[0].id

            window.location.href = "getPurchaseById?id="+id

        })
           
        
        $("#btnDel").click(function () {
            var checkDate = table.checkStatus("purchaseList")
            if(checkDate.data.length==0){
                layer.msg("请选择要删除的信息")
                return
            }
            layer.msg("确定要删除所选信息吗",{
                time:0,
                btn:["确定","取消"],
                yes:function () {
                    var id = ""
                    $(checkDate.data).each(function (i,purchase) {
                        id += purchase.id+","
                    })
                    id = id.substring(0,id.length-1)
                    window.location.href="delete?id="+id
                }
            })
        })
    })
</script>
</body>
</html>
