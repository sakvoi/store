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
var showProducts = new Vue({
	el:'#showProducts',
	data:{
		products:null,
		categoryseconds:null
	},
	methods:{
		findAll:function(){
			this.$http.get('/product/findAll').then(function(res){
				this.products = res.body;
				this.$http.get('/categorysecond/findAll').then(function(res){
					this.categoryseconds = res.body
				});
			},function(){
				console.log('请求失败处理');
			});
		}
	},
	mounted:function(){
		this.findAll();
	}
});
