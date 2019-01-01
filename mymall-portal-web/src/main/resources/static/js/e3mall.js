var E3MALL = {
	checkLogin : function(){
		var _ticket = $.cookie("MYMALL_TOKEN");
		if(!_ticket){
			return ;
		}
		$.ajax({
			url : "http://sso.mymall.com/user/token/" + _ticket,
			dataType : "jsonp",
			type : "GET",
			success : function(data){
				if(data.status == 200){
					var username = data.data.username;
					var html = username + "，欢迎来到我的商城购物网！<a href=\"http://www.mymall.com/user/logout.html\" class=\"link-logout\">[退出]</a>";
					$("#loginbar").html(html);
				}
			}
		});
	}
}

$(function(){
	// 查看是否已经登录，如果已经登录查询登录信息
	E3MALL.checkLogin();
});