<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>提交订单页面</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css"/>
	<script type="text/javascript" src="../js/javascript.js"></script>
</head>
<body>
<%@include file="top.jsp" %>

<div id="middle">
	<div id="position">
		您现在的位置是&nbsp;&gt;&nbsp;<a href="index.jsp">网上商城</a>&nbsp;&gt;&nbsp;订单提交
	</div>
	<div id="orderuser">
		<table>
			<tr>
				<td style="width:180px;">${user.name}</td>
				<td>${user.phone}</td>
			</tr>
			<tr>
				<td colspan="2">收货地址：
					<c:set var="i" value="0"></c:set>
					<c:forEach var="address" items="${addressList}">
						<c:if test="${address!=null}">
							<c:set var="i" value="${i+1}"></c:set>
						</c:if>
					</c:forEach>
					<c:if test="${i==0}">
						<a href="../AddressServlet?action=findaddress&user_id=${user.id}">您还没有设置收货地址，请先去设置收货地址吧！</a>
					</c:if>
					<c:if test="${i!=0}">
						<select name="order_address">					
							<c:forEach var="address" items="${addressList}">
								<c:if test="${address!=null && !address.user_address.equals('')}">
									<option>${address.user_address}</option>
								</c:if>
							</c:forEach>
						</select>
					</c:if>
				</td>
			</tr>
		</table>
	</div>
	<c:set var="count" value="0"></c:set>
	<c:set var="total" value="0"></c:set>
	<c:forEach var="order" items="${orderlist}">
		<c:forEach var="product" items="${orderproductlist}">
			<c:if test="${order.order_productid==product.product_id}">
				<div id="orderproduct">
					<table>
						<tr>
							<td rowspan="4" style="width:220px;"><img src="../images/productImg/${product.product_imgurl}"/></td>
							<td style="width:150px;">${product.product_name}</td>
							<td>￥${product.product_price}&nbsp;&nbsp;&nbsp;×${order.order_productnumber}</td>
						</tr>
						<tr>
							<td colspan="2">${product.product_describe}</td>
						</tr>
						<tr>
							<td><span>七天无理由退换</span></td>
							<td></td>
						</tr>
						<tr>
							<td>配送方式：普通配送</td>
							<td align="right">共${order.order_productnumber}件&nbsp;小计：￥${order.order_sumprice}元</td>
							<c:set var="count" value="${count+order.order_productnumber}"></c:set>
							<c:set var="total" value="${total+order.order_sumprice}"></c:set>
						</tr>
					</table>
				</div>
			</c:if>
		</c:forEach>
	</c:forEach>
	<div id="ordersubmit">
		共${count}件&nbsp;合计：￥${total}元&nbsp;
		<input type="submit" name="ordersubmit" value="提交订单" onclick="submitOrder()"/>
		<script>
			function submitOrder(){
				var order_address = document.getElementsByName("order_address")[0].value;
				if(order_address == ""){
					alert("请选择收货地址！");
				}else{
					var order_status = 1;
					var paypassword = prompt("请输入您的支付密码？","");
					if("${user.password}" == paypassword){
						alert("支付成功！");
						order_status = 2;
					}else{
						alert("密码错误，支付失败！");
					}
					location.href="../OrderServlet?action=submitorder&order_address="+order_address+"&order_status="+order_status;
				}
			}
		</script>
	</div>
</div>

<%@include file="bottom.jsp" %>
</body>
</html>