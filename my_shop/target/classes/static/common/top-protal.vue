<template>
	<div id="header">
		<div id="logo">网上商城</div>
		<div id="help">
			<a href="../front/login.html">登录</a>
			<a href="../front/register.html">注册</a>
			<a href="../manage/index-manage.html">去后台</a>
		</div>
		<div id="navigator">
			<ul>
				<li><a href="../front/index.html">首页</a></li>
				<li><a href="../front/product-list.html">商品</a></li>
				<li><a href="../OrderServlet?action=orderlist&order_status=1">个人订单</a></li>
				<li><a href="../ShopCarServlet?action=shopcarlist">购物车</a></li>
				<li><a href="set.jsp">设置</a></li>
			</ul>
			<input type="text" placeholder="搜索" size="30" name="search"/><a>搜索</a>
		</div>
	</div>
</template>



