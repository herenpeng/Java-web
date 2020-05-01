<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>个人订单页面</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css"/>
	<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
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
		您现在的位置是&nbsp;&gt;&nbsp;<a href="index.jsp">网上商城</a>&nbsp;&gt;&nbsp;个人订单
	</div>
	<div id="findorder">
		<ul>			
			<li><a href="../OrderServlet?action=orderlist&order_status=1">待付款</a></li><!-- 1未支付 -->
			<li><a href="../OrderServlet?action=orderlist&order_status=2">待发货</a></li><!-- 2已支付 -->
			<li><a href="../OrderServlet?action=orderlist&order_status=3">待收货</a></li><!-- 3已发货 -->
			<li><a href="../OrderServlet?action=orderlist&order_status=4">待评价</a></li><!-- 4已收货 、交易成功-->
			<li><a href="../OrderServlet?action=orderlist&order_status=5">退款</a></li><!-- 5、6退款-->
		</ul>
	</div>
	<c:if test="${orderlist.size()==0}">
		<div style="height:450px;line-height:450px;text-align:center;color:#FF4000;">您还没有该类型的订单，去看看其他类型的订单吧！</div>
	</c:if>
	<c:forEach var="order" items="${orderlist}">
		<c:forEach var="product" items="${orderproductlist}">
			<c:if test="${order.order_productid==product.product_id}">
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
							<td rowspan="4" style="width:220px;"><img src="../images/productImg/${product.product_imgurl}"/></td>
							<td style="width:200px;">${product.product_name}</td>
							<td style="width:150px;">￥${product.product_price}&nbsp;&nbsp;&nbsp;×${order.order_productnumber}</td>
							<td></td>
						</tr>
						<tr>
							<td colspan="3">${product.product_describe}</td>
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
							<td>收货人：${user.name}</td>
							<td align="right">联系方式：${user.phone}</td>
						</tr>
						<tr>
							<td colspan="2">订单创建时间：${order.order_datetime}</td>
							<td colspan="2" align="right">
								<c:if test="${order.order_status==1}">
									<a href="../OrderServlet?action=deleteorder&order_id=${order.order_id}">
										<input type="button" value="取消订单" class="button">
									</a>
									<input type="button" value="去付款" class="button" onclick="toPay()">	
									<script>
										function toPay(){
											var paypassword = prompt("请输入您的支付密码？","");
											if("${user.password}" == paypassword){
												alert("支付成功！");
												location.href="../OrderServlet?action=changeorderstatus&order_id=${order.order_id}&order_status=2";
											}else{
												alert("密码错误，支付失败！");
											}		
										}
									</script>
								</c:if>
								<c:if test="${order.order_status==2}">
									<a href="../OrderServlet?action=changeorderstatus&order_id=${order.order_id}&order_status=5">
										<input type="button" value="申请退款" class="button">
									</a>
								</c:if>
								<c:if test="${order.order_status==3}">
									<a href="../OrderServlet?action=changeorderstatus&order_id=${order.order_id}&order_status=4&order_productnumber=${order.order_productnumber}&product_id=${product.product_id}">
										<input type="button" value="确认收货" class="button">
									</a>
									<a href="../OrderServlet?action=changeorderstatus&order_id=${order.order_id}&order_status=5">
										<input type="button" value="申请退款" class="button">
									</a>
								</c:if>
								<c:if test="${order.order_status==4}">
									<a href="../OrderServlet?action=deleteorder&order_id=${order.order_id}">
										<input type="button" value="删除订单" class="button">
									</a>
									<a href="../MessageServlet?action=messageproduct&product_id=${product.product_id}">
										<input type="button" value="我要评价" class="button">
									</a>
								</c:if>
								<c:if test="${order.order_status==6}">
									<a href="../OrderServlet?action=deleteorder&order_id=${order.order_id}">
										<input type="button" value="删除订单" class="button">
									</a>
								</c:if>
							</td>
						</tr>
					</table>
				</div>
			</c:if>
		</c:forEach>
	</c:forEach>
</div>

<%@include file="bottom.jsp" %>
</body>
</html>