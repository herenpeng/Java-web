<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>订单详情页面</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css"/>
	<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="../js/javascript.js"></script>
</head>
<body>
<%@include file="top.jsp" %>

<div id="middle">
	<div id="position">
		您现在的位置是&nbsp;&gt;&nbsp;<a href="index.jsp">管理后台</a>&nbsp;&gt;&nbsp;订单管理
	</div>
	<div id="orderproduct">
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
				<td colspan="2">收货地址：${order.order_address}</td>
				<td>收货人：${order_user.name}</td>
				<td align="right">联系方式：${order_user.phone}</td>
			</tr>
			<tr>
				<td colspan="2">订单创建时间：${order.order_datetime}</td>
				<td colspan="2" align="right">
					<c:if test="${order.order_status==1}">
						<a href="modifyOrder.jsp"><input type="button" value="修改订单地址" class="button"></a>
					</c:if>
					<c:if test="${order.order_status==2}">
						<a href="modifyOrder.jsp"><input type="button" value="修改订单地址" class="button"></a>
						<input type="button" value="给买家发货" class="button" onclick="ship()">
						<script>
							function ship(){
								var order_id = ${order.order_id};
								var order_productnumber = ${order.order_productnumber};
								var product_stock = ${order_product.product_stock};
								var product_id = ${order_product.product_id};
								if(order_productnumber > product_stock) {
									alert("对不起，该商品库存不足，请增加库存或是联系买家取消订单！");
								}else {
									location.href="../OrderServlet?action=ship&order_id="+order_id+"&order_status=3&order_productnumber="+order_productnumber+"&product_id="+product_id;
								}
							}
						</script>
					</c:if>
					<c:if test="${order.order_status==3}">
						<a href="modifyOrder.jsp"><input type="button" value="修改订单地址" class="button"></a>
					</c:if>
					<c:if test="${order.order_status==5}">
						<a href="../OrderServlet?action=refund&order_id=${order.order_id}&order_status=6&order_productnumber=${order.order_productnumber}&product_id=${order_product.product_id}">
							<input type="button" value="同意退款申请" class="button">
						</a>
					</c:if>
				</td>
			</tr>
		</table>
	</div>
</div>

<%@include file="../front/bottom.jsp" %>
</body>
</html>