<%--
  Created by IntelliJ IDEA.
  User: 张余良
  Date: 2021/9/16
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改采购信息</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
    <style>
        #div1{
            background: aliceblue;
            height: 30px;
            width: 600px;
        }
        .t1{
            width: 300px;

        }
        .t2{
            width: 300px;
            height: 75px;
        }
        .top{
            margin-top: 10px;
        }
        .t3{
            width: 80px;
        }
    </style>
</head>
<body>
    <div>
        <form action="updatePurchase" method="post">
        <div class="layui-col-md-offset2">
            <div id="div1" class="layui-inline">
                <h2>采购申请</h2>
            </div>
            <div class="layui-input-inline"><input type="button" id="btnOk" class="layui-btn" value="保存">
                    <input type="submit" id="btnPost" class="layui-btn" value="提交"></div>
        </div>
        <div class="layui-form-item top layui-col-md-offset3">
            <label class="layui-form-label">申请单号</label>
            <div class="layui-input-block">
                <input type="text" id="id" name="id" readonly value="${purchase.id}" autocomplete="off" class="t1 layui-input">
            </div>
        </div>
        <div class="layui-form-item top layui-col-md-offset3">
            <label class="layui-form-label">申请人</label>
            <div class="layui-input-block">
                <input type="text" name="applyUser" readonly value="${purchase.applyUser}" autocomplete="off" class="t1 layui-input">
            </div>
        </div>
        <div class="layui-form-item top layui-col-md-offset3">
            <label class="layui-form-label">申请日期</label>
            <div class="layui-input-block">
                <input type="text" id="date" name="applyDate" value="${purchase.applyDate}" autocomplete="off" class="t1 layui-input">
            </div>
        </div>
        <div class="layui-form-item top layui-col-md-offset3">
            <label class="layui-form-label">申请类型</label>
            <div class="layui-input-block">
                <select id="type" required name="purchaseType" autocomplete="off" class="layui-input t1">
                    <option value="${purchase.purchaseType}">${purchase.purchaseType}</option>
                    <option value="普通办公用品">普通办公用品</option>
                    <option value="高级办公用品">高级办公用品</option>
                    <option value="招待客户用品">招待客户用品</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item top layui-col-md-offset3">
            <label class="layui-form-label">采购原因</label>
            <div class="layui-input-block">
                <textarea type="text" name="purchaseReason"  autocomplete="off" class="t2 layui-input">${purchase.purchaseReason}</textarea>
            </div>
        </div>
        <div class="layui-form-item top layui-col-md-offset3">
            <label class="layui-form-label">部门审核</label>
            <div class="layui-input-block">
                <textarea type="text" name="deptAuti"  autocomplete="off" class="t2 layui-input">${purchase.deptAuti}</textarea>
            </div>
        </div>
        <div class="layui-form-item top layui-col-md-offset3">
            <label class="layui-form-label">公司审核</label>
            <div class="layui-input-block">
                <textarea type="text" name="companyAuti"  autocomplete="off" class="t2 layui-input">${purchase.companyAuti}</textarea>
            </div>
        </div>
        <div class="layui-col-md-offset8">
            <div class="layui-input-inline"><input type="button" id="btnAdd" value="新增" class="layui-btn">
                <input type="button" id="btnDel" class="layui-btn" value="删除"></div>
        </div>
        <div class="layui-row">
            <div class="layui-col-md-offset2">
                <table id="itemList" class="layui-table" lay-data="{ width: 782, limits: [5, 10, 15], limit: 5 ,id:'itemList'}" lay-filter="itemList">
                    <thead>
                    <tr>
                        <th lay-data="{type:'checkbox'}"></th>
                        <th lay-data="{type:'numbers',field:'index'}">序号</th>
                        <th lay-data="{field: 'id',  width: 80, hide:true}">id</th>
                        <th lay-data="{field: 'purchaseId', width: 140}">采购信息ID</th>
                        <th lay-data="{field: 'materialName', edit: 'text', width: 120, sort: true}">物料名称</th>
                        <th lay-data="{field: 'calcUnit', edit: 'text',width: 100, sort: true}">计量单位</th>
                        <th lay-data="{field: 'uintPrice', edit: 'text',width: 80, sort: true}">单价</th>
                        <th lay-data="{field: 'purchaseNumber', edit: 'text',width: 120, sort: true}">采购数量</th>
                        <th lay-data="{field: 'remark', edit: 'text',width: 120, sort: true}">备注</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
        <div class="layui-form-item top layui-col-md-offset8">
            <label class="layui-form-label">预估金额</label>
            <div class="layui-input-block">
                <input type="text" id="preCost" name="preCost" value="${purchase.preCost}" readonly autocomplete="off" class="t3 layui-input">
            </div>
        </div>
        </form>
    </div>
    <script>
        layui.use(["laydate","table"],function () {
            var laydate = layui.laydate
            var layer = layui.layer
            var table = layui.table
            var $ = layui.$

            laydate.render({
                elem:"#date"
                ,trigger:"click"
            })


            $("#btnOk").click(function () {
                debugger
                var date = table.cache.itemList
                var id = ""
                var purchaseId = ""
                var calcUnit = ""
                var materialName = ""
                var purchaseNumber = ""
                var remark = ""
                var uintPrice = ""
                for (var i = 0; i <date.length ; i++) {
                    id += date[i].id+","
                    purchaseId += date[i].purchaseId+","
                    calcUnit += date[i].calcUnit+","
                    materialName += date[i].materialName+","
                    purchaseNumber += date[i].purchaseNumber+","
                    remark += date[i].remark+","
                    uintPrice += date[i].uintPrice+","
                }
                debugger
                id = id.substring(0,id.length-1)
                purchaseId = purchaseId.substring(0,purchaseId.length-1)
                calcUnit = calcUnit.substring(0,calcUnit.length-1)
                materialName = materialName.substring(0,materialName.length-1)
                purchaseNumber = purchaseNumber.substring(0,purchaseNumber.length-1)
                remark = remark.substring(0,remark.length-1)
                uintPrice = uintPrice.substring(0,uintPrice.length-1)
                $.ajax({
                    url:"gettable"
                    ,data:{'id':id,"purchaseId":purchaseId,"calcUnit":calcUnit,"materialName":materialName,
                    "purchaseNumber":purchaseNumber,"remark":remark,"uintPrice":uintPrice}
                    ,type:"post"
                    ,success:function (data) {
                        $("#preCost").val(data)
                    }
                })
            })
            $("#btnAdd").click(function () {
                debugger
                var dateBak = [];
                var tableBak = table.cache.itemList;
                for (var i = 0; i < tableBak.length; i++) {
                    dateBak.push(tableBak[i]);      //将之前的数组备份
                }
                dateBak.push({
                    calcUnit: ""
                    ,id: 0
                    ,materialName: ""
                    ,purchaseId: $("#id").val()
                    ,purchaseNumber: 0
                    ,remark: ""
                    ,uintPrice: 0.0
                });
                table.reload("itemList",{
                    url:"",
                    data:dateBak  // 将新数据重新载入表格
                })
            })
            table.reload("itemList",{
                url:'/itemList?id='+$("#id").val()
            })


            $("#btnDel").click(function () {
                debugger
                var checkDate = table.checkStatus("itemList")
                if(checkDate.data.length==0){
                    layer.msg("请选择要删除的数据")
                    return
                }
                var dateBak = [];
                var tableBak = table.cache.itemList;
                for (var i = 0; i < tableBak.length; i++) {
                    if (!tableBak[i].LAY_CHECKED){
                        dateBak.push(tableBak[i]);
                    }
                          //将之前的数组备份
                }
                table.reload("itemList",{
                    url:"",
                    data:dateBak  // 将新数据重新载入表格
                })

                // var tableBak = table.cache.itemList
                // table.reload("itemList",{
                //     url:"",
                //     data:tableBak  // 将新数据重新载入表格
                // })

            })

        })
    </script>
</body>
</html>
