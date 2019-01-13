var getUser = new Vue({
	el : '#getUser',
	data : {
		user : null,
	},
	methods : {
		getUser : function() {
			this.$http.get('/seller/getUser').then(function(res) {
				this.user = res.bodyText
			}, function() {
				console.log('请求失败处理');
			});
		},
		logout : function() {
			this.$http.get('/seller/removeUser').then(function(res) {
				if (res.body.success) {
					alert("注销成功！")
					location.href = "login.html"
				} else {
					alert("注销失败！")
					location.href = "login.html"
				}
			}, function() {
				console.log("请求失败处理")
			});
		}
	},
	mounted : function() {
		this.getUser();
	}
});
var login = new Vue({
	el : '#login',
	data : {
		username : null,
		password : null
	},
	methods : {
		login : function() {
			this.$http.get('/seller/login', {
				params : {
					username : this.username,
					password : this.password
				}
			}, {
				emulateJSON : true
			}).then(function(res) {
				if (res.body.success) {
					alert("登录成功");
					location.href = "index.html"
				} else {
					alert("用户名或密码错误");
					location.href = "login.html"
				}
			}, function() {
				console.log('请求失败处理');
			});
		}
	}
});
var sellerInfo = new Vue({
	el : '#sellerInfo',
	data : {
		seller : [],
	},
	methods : {
		findOne : function() {
			this.$http.get('/seller/findOne?id=1').then(function(res) {
				this.seller = res.body;
			});
		}
	},
	mounted : function() {
		this.findOne();
	}
});
var changePwd = new Vue({
	el : '#changePwd',
	data : {
		id : null,
		user : [],
	},
	methods : {
		getInfo : function() {
			this.$http.get('/seller/findOne', {
				params : {
					id : 1
				}
			}, {
				emulateJSON : true
			}).then(function(res) {
				this.user = res.body;
			}, function() {
				console.log('请求失败处理');
			});
		},
		updatePwd : function() {
			var password = $("#password").val();
			var newPwd = $("#newPwd").val();
			this.$http.get('/seller/findByNamePwd', {
				params : {
					username : this.user.username,
					password : password
				}
			}, {
				emulateJSON : true
			}).then(function(res) {
				if (res.body.success) {
					this.$http.post('/seller/update', {
						sid : this.user.sid,
						username : this.user.username,
						password : newPwd,
						license : this.user.license,
						company : this.user.company,
						scope : this.user.scope
					}).then(function(res) {
						if (res.body.success) {
							alert("修改成功");
							location.href = "changePwd.html"
						} else {
							alert("修改失败");
							location.href = "changePwd.html"
						}
					}, function() {
						console.log('请求失败处理');
					});
				} else {
					alert("原密码错误");
					location.href = "changePwd.html"
				}
			}, function() {
				console.log('请求失败处理');
			});
		}
	},
	mounted : function() {
		this.getInfo();
	}
});
var orderManage = new Vue({
	el : '#orderManage',
	data : {
		orders : null,
		orderitems : null
	},
	methods : {
		calDate : function(time) {
			var d = new Date(time);
			var times = d.getFullYear() + '-' + (d.getMonth() + 1) + '-'
					+ d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes()
					+ ':' + d.getSeconds();
			return times;
		},
		findAll : function() {
			this.$http.get('/order/findAll').then(function(res) {
				this.orders = res.body
			}, function() {
				console.log('请求失败处理');
			});
		},
		findByUid : function() {
			this.$http.get('/order/findByUid?uid=1').then(function(res) {
				this.orders = res.body
			}, function() {
				console.log('请求失败处理');
			});
		},
		findByOid : function(oid) {
			this.$http.get('/orderitem/findByOid?oid=' + oid).then(
					function(res) {
						this.orderitems = res.body
					}, function() {
						console.log('请求失败处理');
					});
		}
	},
	mounted : function() {
		/* this.findAll(); */
		this.findByUid();
	}
});
var productManage = new Vue({
	el : '#productManage',
	data : {
		products : null,
		categoryseconds : null,
		product : [],
		csname : null
	},
	methods : {
		calDate : function(time) {
			var d = new Date(time);
			var times = d.getFullYear() + '-' + (d.getMonth() + 1) + '-'
					+ d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes()
					+ ':' + d.getSeconds();
			return times
		},
		update : function() {

		},
		del : function(product) {
			this.product = product
			var ids = [];
			ids = this.product.pid;
			this.$http.post('/product/delete?ids=' +ids).then(function(res) {
				if(res.body.success){
					alert("删除成功！")
					location.href="productManage.html"
				}else{
					alert("删除失败！")
					location.href="productManage.html"
				}
			}, function() {
				console.log('请求失败处理');
			});
		},
		findBySid : function() {
			this.$http.get('/product/findBySid?sid=1').then(function(res) {
				this.products = res.body;
			}, function() {
				console.log('请求失败处理');
			});
		},
		findAll : function() {
			this.$http.get('/product/findAll').then(function(res) {
				this.products = res.body;
			}, function() {
				console.log('请求失败处理');
			});
		},
		findOne : function(product) {
			this.$http.get('/product/findOne?id=' + product.pid).then(
					function(res) {
						this.product = res.body;
						this.$http.get(
								'/categorysecond/findOne?id=' + product.csid)
								.then(function(res) {
									/* alert(res.body.csname) */
									this.csname = res.body.csname;
								}, function() {
									console.log('请求失败处理');
								});
					}, function() {
						console.log('请求失败处理');
					});
		}
	},
	mounted : function() {
		/* this.findAll(); */
		this.findBySid();
	}
});
var category = new Vue({
	el : '#category',
	data : {
		categorys : null,
	},
	methods : {
		del : function(id) {
			var ids = [];
			ids = id
			this.$http.post('/category/delete?ids=' + ids).then(function(res) {
				if (res.body.success) {
					alert("删除成功！");
					location.href = "category.html";
				} else {
					alert("删除失败！");
					location.href = "category.html";
				}
			}, function() {
				console.log('请求失败处理');
			});
		},
		findAll : function() {
			this.$http.post('/category/findAll').then(function(res) {
				this.categorys = res.body
			}, function() {
				console.log('请求失败处理');
			});
		},
		findOne : function(cid) {
			this.$http.post('/category/findOne?id=' + cid).then(function(res) {

			}, function() {
				console.log('请求失败处理');
			});
		}
	},
	mounted : function() {
		this.findAll();
	}
});
var categorysecond = new Vue({
	el : '#categorysecond',
	data : {
		categoryseconds : null,
		category : null
	},
	methods : {
		del : function(id) {
			var ids = [];
			ids = id
			this.$http.post('/categorysecond/delete?ids=' + ids).then(
					function(res) {
						if (res.body.success) {
							alert("删除成功！");
							location.href = "categorySecond.html";
						} else {
							alert("删除失败！");
							location.href = "categorySecond.html";
						}
					}, function() {
						console.log('请求失败处理');
					});
		},
		findAll : function() {
			this.$http.post('/categorysecond/findAll').then(function(res) {
				this.categoryseconds = res.body
			}, function() {
				console.log('请求失败处理');
			});
		},
		findOne : function(csid) {
			this.$http.post('/categorysecond/findOne?id=' + csid).then(
					function(res) {

					}, function() {
						console.log('请求失败处理');
					});
			this.$http.get('/category/findAll').then(function(res) {
				this.category = res.body
			}, function() {
				console.log('请求失败处理');
			});
		},
	},
	mounted : function() {
		this.findAll();
	}
});