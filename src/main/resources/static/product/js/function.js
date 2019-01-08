$.get("/category/findAll",function(data1,status1){
	$.get("/categorysecond/findAll",function(data2,status2){
		var table = new Vue({
			el:'#flei',
			data:{
				categorys:data1,
				categoryseconds:data2,
			}
		});
	});
	
});
var topMenu = new Vue({
	el:'#topMenu',
	data:{
		categorys: null
	},
	methods:{
		findAll:function(){
			this.$http.post('/category/findAll').then(function(res){
				this.categorys=res.body
			},function(){
				console.log('请求失败处理');
			});
		},
	},
	mounted:function(){
		this.findAll();
    }
});
var init = new Vue({
	el:'#init',
	data:{
		categorys: null,
		categoryseconds:null
	},
	methods:{
		findAll:function(){
			this.$http.post('/category/findAll').then(function(res){
				this.categorys=res.body
			},function(){
				console.log('请求失败处理');
			});
			this.$http.post('/categorysecond/findAll').then(function(res){
				this.categoryseconds=res.body
			},function(){
				console.log('请求失败处理');
			});
		},
	},
	mounted:function(){
		this.findAll();
	}
});
function register() {
	var username = $("#username").val()
	var password = $("#password").val()
	var email = $("#email").val()
	$.ajax({
		data : JSON.stringify({
			"username" : username,
			"password" : password,
			"email" : email
		}),
		contentType : "application/json;charset=UTF-8",
		dataType : "JSON",
		isAsync : false,
		isCache : true,
		method : "POST",
		url : "customer/register",
		complete : function(rst) {
			var result = JSON.parse(rst.responseText);
			if (result.success) {
				alert("注册成功");
				location.href = "index.html"
			} else {
				alert("注册失败");
			}
		}
	})
	return false;
}