<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>订单修改页面</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css"/>
	<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="../js/javascript.js"></script>
</head>
<body>
<%@include file="top.jsp" %>

<div id="middle">
	<div id="position">
		您现在的位置是&nbsp;&gt;&nbsp;<a href="index.jsp">网上商城</a>&nbsp;&gt;&nbsp;订单管理
	</div>
	<div id="orderproduct">
		<form action="../OrderServlet" method="post">
			<input type="hidden" name="action" value="modifyorder"/>
			<table>
				<tr>
					<td style="font-weight:bolder;">订单状态：
						<c:if test="${order.order_status==1}">买家未付款</c:if>
						<c:if test="${order.order_status==2}">买家已付款</c:if>
						<c:if test="${order.order_status==3}">卖家已发货</c:if>
						<c:if test="${order.order_status==4}">交易成功</c:if>
						<c:if test="${order.order_status==5}">申请退款中...</c:if>
						<c:if test="${order.order_status==6}">退款成功</c:if>
					</td>
					<td></td>
					<td colspan="2" align="right">订单编号：${order.order_id}</td>
				</tr>
				<tr>
					<td rowspan="4" style="width:220px;"><img src="../images/productImg/${order_product.product_imgurl}"/></td>
					<td style="width:200px;">${order_product.product_name}</td>
					<td style="width:150px;">￥${order_product.product_price}&nbsp;&nbsp;&nbsp;×${order.order_productnumber}</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="3">${order_product.product_describe}</td>
				</tr>
				<tr>
					<td><span>七天无理由退换</span></td>
					<td colspan="2" align="right">共${order.order_productnumber}件&nbsp;订单总价：￥${order.order_sumprice}元</td>		
				</tr>
				<tr>
					<td>配送方式：普通配送</td>
					<td colspan="2" align="right" style="font-weight:bolder;">
						<c:if test="${order.order_status==1}">需付款：￥${order.order_sumprice}元</c:if>
						<c:if test="${order.order_status>1}">实付款：￥${order.order_sumprice}元</c:if>
					</td>
				</tr>
				<tr>
					<td colspan="2">收货地址：<input type="text" size="45" value="${order.order_address}" name="order_address"/></td>
					<td>收货人：${order_user.name}</td>
					<td align="right">联系方式：${order_user.phone}</td>
				</tr>
				<tr>
					<td colspan="2">订单创建时间：${order.order_datetime}</td>
					<td colspan="2" align="right">
						<input type="submit" value="修改订单地址" class="button"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>

<%@include file="../front/bottom.jsp" %>
</body>
</html>