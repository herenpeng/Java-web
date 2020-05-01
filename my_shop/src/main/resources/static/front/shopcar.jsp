<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>前台购物车页面</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css"/>
	<script type="text/javascript" src="../js/javascript.js"></script>
	<c:if test="${empty user.username}">
		<script type="text/javascript">
			alert("请先登录");
			location.href="../front/login.jsp";
		</script>
	</c:if>
</head>
<body>
<%@include file="top.jsp" %>

<div id="middle">
	<div id="position">
		您现在的位置是&nbsp;&gt;&nbsp;<a href="index.jsp">网上商城</a>&nbsp;&gt;&nbsp;购物车
	</div>
	<div id="shopcar">
		<table>
			<tr class="firstLine">
				<td colspan="6" id="shopcarword">我的购物车</td>
				<td><input type="button" value="删除所选" class="button" name="alldel" onclick="alldel()"/></td>
			</tr>
			<tr class="firstLine">
				<td style="width:60px;">全选<input type="checkbox" id="allck" onclick="allck()"/></td>
				<td style="width:300px;" colspan="2">商品</td>
				<td style="width:100px;">单价</td>
				<td style="width:150px;">数量</td>
				<td style="width:160px;">总价</td>
				<td>操作</td>
			</tr>
			<c:set var="row" value="6"></c:set>
			<c:if test="${shopcarlist.size()>0}">
				<c:forEach var="shopcarproduct" items="${shopcarlist}">
					<tr>
						<td><input type="checkbox" name="ck" onclick="ck(this)"/><input type="hidden" name="product_id" value="${shopcarproduct.product_id}"/></td>
						<td style="width:150px;"><img src="../images/productImg/${shopcarproduct.product_imgurl}" align="middle"/></td>
						<td>${shopcarproduct.product_name}</td>
						<td>￥<input type="text" value="${shopcarproduct.product_price}" size="6" disabled="disabled" class="num"/></td>
						<td>
							<input type="button" value="-" class="modifyButton" name="minus" onclick="minus(this)"/>
							<input type="text" size="4" value="1" disabled="disabled" class="num"/>
							<input type="button" value="+" class="modifyButton" name="plus" onclick="plus(this)"/>
						</td>
						<td>￥<input type="text" value="${shopcarproduct.product_price}" size="8" disabled="disabled" class="num"/></td>
						<td>
							<input type="button" value="删除" class="button" name="del" onclick="del()"/>
							<script>
							function del() {
								if(confirm("您确定要将该商品从您的购物车中移除吗？")) {
									location.href="../ShopCarServlet?action=delshopcar&product_id="+${shopcarproduct.product_id};
									pricesum();
								}
							}
							</script>
						</td>
					</tr>
					<c:if test="${row>0}">
						<c:set var="row" value="${row-1}"></c:set>
					</c:if>
				</c:forEach>
				<c:if test="${row>0}">
					<c:forEach begin="1" end="${row}" step="1">
						<tr class="lastLine">
							<td colspan="7"></td>
						</tr>
					</c:forEach>
				</c:if>
				<tr class="lastLine">
					<td colspan="5"></td>
					<td>商品总计￥<input type="text" size="8" name="pricesum" disabled="disabled" class="num"/></td>
					<td>
						<input type="submit" value="结算" class="button" onclick="account()"/>
						<script>
						function account(){
							var productidArr = "";
							var productnumberArr = "";
							var sumpriceArr = "";
							var flag = false;
							var ck = document.getElementsByName("ck");
							for(var i=0;i<ck.length;i++) {
								if(ck[i].checked) {
									var productid = ck[i].nextElementSibling.value*1;
									var productnumber = ck[i].parentElement.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.children[1].value*1;
									var sumprice = ck[i].parentElement.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.children[0].value*1;
									
									productidArr = productidArr +"/"+ productid;
									productnumberArr = productnumberArr +"/"+ productnumber;
									sumpriceArr = sumpriceArr +"/"+sumprice;
									flag = true;
								}
							}
							if(flag){
								location.href="../OrderServlet?action=tobuy&productidArr="+productidArr+"&productnumberArr="+productnumberArr+"&sumpriceArr="+sumpriceArr;
							}else{
								alert("请先选择商品！");
							}
						}
						</script>
					</td>					
				</tr>
			</c:if>
			<c:if test="${shopcarlist.size()<=0}">
				<tr class="lastLine">
					<td colspan="7" style="height:440px;color:#FF4000;">对不起，您还没有添加商品！</td>				
				</tr>
			</c:if>
		</table>
	</div>
</div>

<%@include file="bottom.jsp" %>
</body>
</html>