function allck(){
	var allck = document.getElementById("allck");
	var ck = document.getElementsByName("ck");
	for(var i=0;i<ck.length;i++){
		ck[i].checked = allck.checked;
	}
	pricesum();
}

function ck(input){
	var allck = document.getElementById("allck");
	var ck = document.getElementsByName("ck");
	var count = 0;
	if(input.checked) {
		for(var i=0;i<ck.length;i++) {
			if(ck[i].checked) {
				count++;
			}
		}
		if(count == ck.length) {
			allck.checked = true;
		}
	}
	else {
		allck.checked = false;
	}
	pricesum();
}

function minus(minusButton) {
	var value = minusButton.nextElementSibling.value;
	if(value > 1) {
		minusButton.nextElementSibling.value = value*1 - 1;

		var price = minusButton.parentElement.previousElementSibling.children[0].value;
		var quan = minusButton.nextElementSibling.value;
		minusButton.parentElement.nextElementSibling.children[0].value = price*quan;

		pricesum();
	}
}

function plus(plusButton) {
	var value = plusButton.previousElementSibling.value;
	plusButton.previousElementSibling.value = value*1 + 1;

	var price = plusButton.parentElement.previousElementSibling.children[0].value;
	var quan = plusButton.previousElementSibling.value;
	plusButton.parentElement.nextElementSibling.children[0].value = price*quan;

	pricesum();
}

function alldel(){
	if(confirm("您确定要删除您所选中的所有商品吗？")) {
		var ck = document.getElementsByName("ck");
		for(var i=ck.length-1;i>=0;i--) {
			if(ck[i].checked) {
				var tr = ck[i].parentElement.parentElement;
				var trparent = tr.parentElement;
				trparent.removeChild(tr);
			}
		}
	}
	pricesum();
}

function pricesum(){
	var sum = 0;
	var ck = document.getElementsByName("ck");
	for(var i=0;i<ck.length;i++) {
		if(ck[i].checked == true) {
			sum = sum + ck[i].parentElement.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.children[0].value*1;
		}
	}
	document.getElementsByName("pricesum")[0].value = sum;
}
/**
 * 这一部分是注册页面和登录页面、还有用户信息修改页面验证内容的js代码
 */
function checkItem(input){
	input.parentElement.nextElementSibling.children[0].style.display = "block";
	//这里显示或者css样式里面隐藏写一个，否则在提示出现的时候，会有一点点的div移动
	//后面的提示字最多不能超过10个汉字，共计20个字节，否则会改变div样式
	switch(input.name)
	{
		case "username":
			if(input.value == "") {
				input.parentElement.nextElementSibling.children[0].innerHTML = "用户名不能为空！";
				return false;
			}
			else {
				input.parentElement.nextElementSibling.children[0].innerHTML = "";
			}
			break;
		case "password":
			if(input.value == "") {
				input.parentElement.nextElementSibling.children[0].innerHTML = "密码不能为空！";
				return false;
			}
			else {
				input.parentElement.nextElementSibling.children[0].innerHTML = "";
			}
			break;
		case "repassword":
			if(input.value == "") {
				input.parentElement.nextElementSibling.children[0].innerHTML = "确认密码不能为空！";
				return false;
			}
			else if(input.value != document.getElementsByName("password")[0].value) {
				input.parentElement.nextElementSibling.children[0].innerHTML = "确认密码与密码不同！"
				return false;
			}
			else {
				input.parentElement.nextElementSibling.children[0].innerHTML = "";
			}
			break;
		case "name":
			if(input.value == "") {
				input.parentElement.nextElementSibling.children[0].innerHTML = "真实姓名不能为空！";
				return false;
			}
			else {
				input.parentElement.nextElementSibling.children[0].innerHTML = "";
			}
			break;
		case "sex":
			var sex = document.getElementsByName("sex");
			if(sex[0].checked == false && sex[1].checked == false) {
				input.parentElement.nextElementSibling.children[0].innerHTML = "请选择性别！";
				return false;
			}
			else {
				input.parentElement.nextElementSibling.children[0].innerHTML = "";
			}
			break;
		case "birthdate":
			if(input.value == "") {
				input.parentElement.nextElementSibling.children[0].innerHTML = "出生日期不能为空！";
				return false;
			}
			else {
				input.parentElement.nextElementSibling.children[0].innerHTML = "";
			}
			break;
		case "phone":
			var regex = /^[1][3456789]\d{9}$/;//验证手机号格式是否正确
//					var re = new RegExp(regex);
			if(input.value == "") {
				input.parentElement.nextElementSibling.children[0].innerHTML = "手机号码不能为空！";
				return false;
			}
			else if(!regex.test(input.value)) {
				input.parentElement.nextElementSibling.children[0].innerHTML = "手机号码格式错误！";
				return false;
			}
			else {
				input.parentElement.nextElementSibling.children[0].innerHTML = "";
			}
			break;
		case "photo":
			if(input.value == "") {
				input.parentElement.nextElementSibling.children[0].innerHTML = "请选择要上传的头像！";
				return false;
			}
			else {
				input.parentElement.nextElementSibling.children[0].innerHTML = "";
			}
			break;
		case "verification":

			break;
	}
	return true;
}

function checkSubmit() {
	var inputs = document.getElementsByTagName("input");
	var count = 0;
	for(var i=2;i<inputs.length;i++) {
		if(!checkItem(inputs[i])) {//统计校验失败的次数
			count++;
		}
	}
	if(count > 0) {
		return false;
	}
}

/**
 * 这一部分是中央轮播图的js代码
 */
let changenum = 1;

function changeImg(){
	let i;
	const changeimg = document.getElementsByName("changeimg");
	const changepoint = document.getElementsByClassName("changepoint");
	for(i = 0; i<changeimg.length; i++) {
		changeimg[i].style.display = "none";
	}
	for(i = 0; i<changepoint.length; i++) {
		changepoint[i].style.backgroundColor = "gray";
		changepoint[i].style.opacity = "0.5";
	}
	changeimg[changenum].style.display = "block";
	changepoint[changenum].style.backgroundColor = "red";
	changepoint[changenum].style.opacity  = "0.9";
	changenum++;
	if(changenum == changeimg.length) {
		changenum = 0;
	}
}

const change = setInterval("changeImg()", 1000);

$(function(){
	//中央轮播图鼠标移入移出悬停事件
	const imgList = document.getElementById("imgList");
	imgList.onmouseover = function() {
		clearInterval(change);
	}
	imgList.onmouseout = function() {
		const change = setInterval("changeImg()",1000);
	}
	//	轮播点点击事件
	const changepoint = document.getElementsByClassName("changepoint");
	for(let i=0; i<changepoint.length; i++)
	{
		changepoint[i].onclick = function() {
			changenum = this.innerHTML;
			changeImg();
		}
	}

	const changeimg = document.getElementsByName("changeimg");
	const changeleft = document.getElementsByClassName("changeleft");
	changeleft[0].onclick = function(){
		if(changenum > 1) {
			changenum = changenum -2;
		}
		else if(changenum == 1) {
			changenum = changeimg.length - 1;
		}
		else if(changenum == 0) {
			changenum = changeimg.length - 2;
		}
		changeImg();
	}
	const changeright = document.getElementsByClassName("changeright");
	changeright[0].onclick = function(){
		changeImg();
	}

	//定时时钟函数
	clock();
	setInterval("clock()",1000);
});

function clock(){
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	var hours = date.getHours();
	var minutes = date.getMinutes();
	var seconds = date.getSeconds();
	var week = date.getDay();
	switch(week)
	{
		case 0:	week="星期日";
			break;
		case 1:	week="星期一";
			break;
		case 2:	week="星期二";
			break;
		case 3:	week="星期三";
			break;
		case 4:	week="星期四";
			break;
		case 5:	week="星期五";
			break;
		case 6:	week="星期六";
			break;
	}
	document.getElementById("clock").innerHTML = "现在时间是："+hours+":"+minutes+":"+seconds;
	document.getElementById("week").innerHTML = "今天是："+year+"-"+month+"-"+day+" "+week;
}

$(function(){
	//子导航栏商品导航点击现实隐藏事件
	$("#childNav dl dt").click(function(){
		$(this).nextUntil("dt").toggle();
	});
});




