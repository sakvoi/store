/***
 * changePwd
 */
var changePwd = new Vue({
	el:'changePwd',
	data:{
		id : null,
		admin : []
	},
	methods:{
		getInfo:function(){
			this.$http.get('/admin/findOne',{params:{id:1}},{emulateJSON: true}).then(function(res){
				this.admin = res.body
			},function(){
				console.log('请求失败处理');
			});
		},
		updatePwd:function(){
			this.$http.post('/admin/update',{admin:this.admin}).then(function(res){
				if (res.body.success) {
					alert("修改成功");
					location.href = "index.html"
				} else {
					alert("修改失败");
					location.href = "login.html"
				}
			},function(){
				console.log('请求失败处理');
			});
		}
	},
	mounted:function(){
		this.getInfo();
	}
});
/***
 * Login
 */
var login = new Vue({
	el:'#login',
	data:{
		username:null,
		password:null
	},
	methods:{
		login:function(){
			this.$http.get('/admin/login',{params:{username:this.username,password:this.password}},{emulateJSON: true}).then(function(res){
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
/***
 * Customer
 */
var customer = new Vue({
	el:'#customerList',
	data:{
		customers : null,
		user : []
	},
	methods:{
		del:function(id){
			var ids=[];
			ids=id
			this.$http.post('/customer/delete?ids='+ids).then(function(res){
				if(res.body.success){
					alert("删除成功！");
					location.href="customerList.html";
				}else{
					alert("删除失败！");
					location.href="customerList.html";
				}
			},function(){
				console.log('请求失败处理');
			});
		},
		findAll:function(){
			this.$http.get('/customer/findAll').then(function(res){
				this.customers = res.body
			},function(){
				console.log('请求失败处理');
			});
		},
		findOne:function(uid){
			this.$http.get('/customer/findOne?id='+uid).then(function(res){
				this.user=res.body
			},function(){
				console.log('请求失败处理');
			});
		}
	},
	mounted:function(){
        this.findAll();
    }
});
/***
 * SellerList
 */
var sellerList = new Vue({
	el:'#sellerList',
	data:{
		sellers : null,
		seller : []
	},
	methods:{
		del:function(id){
			var ids = [];
			ids = id
			this.$http.post('/seller/delete?ids='+ids).then(function(res){
				if(res.body.success){
					alert("删除成功！");
					location.href="sellerList.html";
				}else{
					alert("删除失败！");
					location.href="sellerList.html";
				}
			},function(){
				console.log('请求失败处理');
			});
		},
		findAll:function(){
			this.$http.get('/seller/findAll').then(function(res){
				this.sellers = res.body
			},function(){
				console.log('请求失败处理');
			});
		},
		findOne:function(sid){
			this.$http.get('/seller/findOne?id='+sid).then(function(res){
				this.seller = res.body
			},function(){
				console.log('请求失败处理');
			});
		}
	},
	mounted:function(){
        this.findAll();
    }
});
/***
 * Category
 */
var category = new Vue({
	el:'#category',
	data:{
		categorys : null,
		cEdit : []
	},
	methods:{
		add:function(){
			var cname = $("#cname").val();
			this.$http.post('/category/add',{cname:cname}).then(function(res){
				if(res.body.success){
					alert("添加成功！");
					location.href="category.html";
				}else{
					alert("添加失败！");
					location.href="category.html";
				}
			});
		},
		edit:function(){
			var editId = $("#editId").val();
			var editName = $("#editName").val();
			this.$http.post('/category/update',{cid:editId,cname:editName}).then(function(res){
				if(res.body.success){
					alert("修改成功！");
					location.href="category.html";
				}else{
					alert("修改失败！");
					location.href="category.html";
				}
			});
		},
		del:function(id){
			var ids=[];
			ids=id
			this.$http.post('/category/delete?ids='+ids).then(function(res){
				if(res.body.success){
					alert("删除成功！");
					location.href="category.html";
				}else{
					alert("删除失败！");
					location.href="category.html";
				}
			},function(){
				console.log('请求失败处理');
			});
		},
		findAll:function(){
			this.$http.get('/category/findAll').then(function(res){
				this.categorys=res.body
			},function(){
				console.log('请求失败处理');
			});
		},
		findOne:function(cid){
			this.$http.get('/category/findOne?id='+cid).then(function(res){
				this.cEdit = res.body
			},function(){
				console.log('请求失败处理');
			});
		}
	},
	mounted:function(){
        this.findAll();
    }
});
/***
 * CategorySecond
 */
var categorysecond = new Vue({
	el:'#categorysecond',
	data:{
		categoryseconds :  null,
		csecondEdit : [],
		category : null
	},
	methods:{
		update:function(){
			var cname = $("#cnameEdit").val();
			this.$http.get('/category/findByName?cname='+cname).then(function(res){
				this.$http.post('/categorysecond/update',{csid:this.csecondEdit.csid,csname:this.csecondEdit.csname,cid:res.body.cid}).then(function(res){
					if(res.body.success){
						alert("修改成功！");
						location.href="categorySecond.html";
					}else{
						alert("修改失败！");
						location.href="categorySecond.html";
					}
				},function(){
					console.log('请求失败处理');
				});
			},function(){
				console.log('请求失败处理');
			});
			this.$http.get('/category/findAll').then(function(res){
				this.category=res.body
			},function(){
				console.log('请求失败处理');
			});
		},
		del:function(id){
			var ids = [];
			ids = id
			this.$http.post('/categorysecond/delete?ids='+ids).then(function(res){
				if(res.body.success){
					alert("删除成功！");
					location.href="categorySecond.html";
				}else{
					alert("删除失败！");
					location.href="categorySecond.html";
				}
			},function(){
				console.log('请求失败处理');
			});
		},
		findAll:function(){
			this.$http.get('/categorysecond/findAll').then(function(res){
				this.categoryseconds=res.body
			},function(){
				console.log('请求失败处理');
			});
		},
		findOne:function(csid){
			this.$http.get('/categorysecond/findOne?id='+csid).then(function(res){
				this.csecondEdit=res.body
			},function(){
				console.log('请求失败处理');
			});
			this.$http.get('/category/findAll').then(function(res){
				this.category=res.body
			},function(){
				console.log('请求失败处理');
			});
		},
	},
	mounted:function(){
        this.findAll();
    }
});
