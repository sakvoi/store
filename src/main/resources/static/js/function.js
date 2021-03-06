var orderDetail = new Vue({
	el:'#orderDetail',
	data:{
		orders:null,
		orderitems:null
	},
	methods:{
		calDate:function(time){
			var d = new Date(time);
			var times=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes() + ':' + d.getSeconds(); 
			return times;
		},
		findByUid:function(){
			this.$http.get('/order/findByUid?uid=1').then(function(res){
				this.orders = res.body
			},function(){
				console.log('请求失败处理');
			});
		},
		findByOid:function(oid){
			this.$http.get('/orderitem/findByOid?oid='+oid).then(function(res){
				this.orderitems = res.body
			},function(){
				console.log('请求失败处理');
			});
		}
	},
	mounted:function(){
		this.findByUid();
	}
});
var getUser = new Vue({
	el:'#getUser',
	data:{
		user:null
	},
	methods:{
		getUser:function(){
			this.$http.get('/customer/getUser').then(function(res){
				this.user=res.bodyText
			},function(){
				console.log('请求失败处理');
			});
		},
		logout:function(){
			this.$http.get('customer/removeUser').then(function(res){
				if(res.body.success){
					alert("注销成功！")
					location.href = "index.html"
				}else{
					alert("注销失败！")
					location.href = "index.html"
				}
			},function(){
				console.log("请求失败处理")
			});
		}
	},
	mounted:function(){
		this.getUser();
	}
});
var login = new Vue({
	el:'#login',
	data:{
		username:null,
		password:null
	},
	methods:{
		login:function(){
			this.$http.get('/customer/login',{params:{username:this.username,password:this.password}},{emulateJSON: true}).then(function(res){
				if (res.body.success) {
					alert("登录成功");
					location.href = "index.html"
				} else {
					alert("用户名或密码错误");
					location.href = "login.html"
				}
			},function(){
				console.log('请求失败处理');
			});
		}
	}
});
var topMenu = new Vue({
	el:'#topMenu',
	data:{
		categorys: null
	},
	methods:{
		findAll:function(){
			this.$http.get('/category/findAll').then(function(res){
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
			this.$http.get('/category/findAll').then(function(res){
				this.categorys=res.body
			},function(){
				console.log('请求失败处理');
			});
			this.$http.get('/categorysecond/findAll').then(function(res){
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
var register = new Vue({
	el:'#register',
	data:{
		username:null,
		password:null,
		email:null
	},
	methods:{
		register:function(){
			this.$http.post('/customer/register',{username:this.username,password:this.password,email:this.email}).then(function(res){
				if (res.body.success) {
					alert("注册成功");
					location.href = "index.html"
				} else {
					alert("注册失败");
				}
			},function(){
				console.log('请求失败处理');
			});
		}
	}
});
var personInfo = new Vue({
	el:'#personInfo',
	data:{
		customer:null
	},
	methods:{
		findOne:function(){
			this.$http.get('/customer/findOne?id=2').then(function(res){
				this.customer=res.body
			},function(){
				console.log('请求失败处理');
			});
		}
	},
	mounted:function(){
		this.findOne();
	}
})
