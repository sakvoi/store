var productManage = new Vue({
	el: '#productManage',
	data:{
		products : null,
		categoryseconds : null,
		product : [],
		csname : null
	},
	methods:{
		update:function(){
			
		},
		del:function(product){
			this.product=product
			this.$http.post('/product/delete?id='+this.product.pid).then(function(res){
				this.products = res.body
			},function(){
				console.log('请求失败处理');
			});
		},
		findAll:function(){
			this.$http.get('/product/findAll').then(function(res){
				this.products = res.body
			},function(){
				console.log('请求失败处理');
			});
		},
		findOne:function(product){
			this.$http.get('/product/findOne?id='+product.pid).then(function(res){
				this.product = res.body;
				this.$http.get('/categorysecond/findOne?id='+product.csid).then(function(res){
					/*alert(res.body.csname)*/
					this.csname=res.body.csname;
				},function(){
					console.log('请求失败处理');
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
var category = new Vue({
	el:'#category',
	data:{
		categorys:null,
	},
	methods:{
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
			this.$http.post('/category/findAll').then(function(res){
				this.categorys=res.body
			},function(){
				console.log('请求失败处理');
			});
		},
		findOne:function(cid){
			this.$http.post('/category/findOne?id='+cid).then(function(res){
				
			},function(){
				console.log('请求失败处理');
			});
		}
	},
	mounted:function(){
        this.findAll();
    }
});
var categorysecond = new Vue({
	el:'#categorysecond',
	data:{
		categoryseconds: null,
		category:null
	},
	methods:{
		del:function(id){
			var ids=[];
			ids=id
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
			this.$http.post('/categorysecond/findAll').then(function(res){
				this.categoryseconds=res.body
			},function(){
				console.log('请求失败处理');
			});
		},
		findOne:function(csid){
			this.$http.post('/categorysecond/findOne?id='+csid).then(function(res){
				
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