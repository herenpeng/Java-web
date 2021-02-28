<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>所有订单</title>
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
	<div id="lefter">
		<div id="childNav">
			<h2>${user.username}</h2>
			<dl>
				<dt>订单管理</dt>
					<dd><a href="../OrderServlet?action=allorder&pageNum=1">所有订单</a></dd>
			</dl>
		</div>
	</div>
	<div id="main">
		<table>
			<tr class="firstLine">
				<td style="width:50px;">订单ID</td>
				<td style="width:220px;">订单商品</td>
				<td style="width:70px;">商品数量</td>
				<td style="width:80px;">商品总价</td>
				<td style="width:70px;">购买者</td>
				<td style="width:180px;">订单生成时间</td>
				<td style="width:100px;">订单状态</td>
				<td>更多...</td>
			</tr>
			<c:if test="${remainRow!=10}">
			<c:forEach var="order" items="${orderlist}">
				<tr>
					<td>${order.order_id}</td>	
					<td>
						<c:forEach var="product" items="${orderproductlist}">
							<c:if test="${order.order_productid==product.product_id }">
								${product.product_name}
							</c:if>
						</c:forEach>
					</td>
					<td>${order.order_productnumber}</td>
					<td>${order.order_sumprice}</td>
					<td>
						<c:forEach var="orderuser" items="${orderuserlist}">
							<c:if test="${order.order_userid==orderuser.id }">
								${orderuser.name}
							</c:if>
						</c:forEach>
					</td>
					<td>${order.order_datetime}</td>
					<td>
						<c:if test="${order.order_status==1}">买家未付款</c:if>
						<c:if test="${order.order_status==2}">买家已付款</c:if>
						<c:if test="${order.order_status==3}">卖家已发货</c:if>
						<c:if test="${order.order_status==4}">交易成功</c:if>
						<c:if test="${order.order_status==5}">申请退款</c:if>
						<c:if test="${order.order_status==6}">退款成功</c:if>
					</td>
					<td><a href="../OrderServlet?action=orderinfo&order_id=${order.order_id}">浏览详情</a></td>	
				</tr>
			</c:forEach>
			<c:forEach begin="1" end="${remainRow}" step="1">
				<tr class="lastLine">
					<td colspan="8"></td>
				</tr>
			</c:forEach>
			</c:if>
			<c:if test="${remainRow==10}">
				<tr class="lastLine">
					<td colspan="8" style="height:437px;">对不起！该页没有订单信息</td>
				</tr>
			</c:if>
			<tr class="lastLine">
				<td colspan="6"></td>
				<td colspan="2" align="right">
				<form action="../OrderServlet" method="post" onsubmit="return checkPageNumStatus()">
					<input type="hidden" name="action" value="allorder"/>
					<input type="submit" value="-" class="modifyButton" name="jumpminus"/>
					<input type="text" size="4" value="${pageNum}" name="pageNum"/>
					<input type="submit" value="+" class="modifyButton" name="jumpplus"/>
					<input type="submit" value="跳转" name="jump" class="button"/>
				</form>
				</td>
			</tr>
		</table>
	</div>
</div>

<%@include file="../front/bottom.jsp" %>
</body>
</html>