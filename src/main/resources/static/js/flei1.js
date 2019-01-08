$(function(){

$(".maintip").each(function(index){
var tip_height=$(".tips:eq("+index+")").height();
$(this).mouseover(function(){
var win_height=$(window).height();    //获取浏览器当前可视区域高度
var obj=$(this).offset();    
var wobj=$(this).width();
if(obj.top+tip_height<win_height){    //判断B底部是否超过浏览器底部
    //没超过，按默认A和B顶端偏移位置一致即可
    var xobj=obj.left+wobj+"px";
    var yobj=obj.top+"px";
}
else{
    //超过了，那么抬高B顶部位置
    var tip_top=win_height-tip_height;
    var xobj=obj.left+wobj+"px";
    var yobj=tip_top+"px";
}
$(this).css({"width":"224px","z-index":"9999","border-right":"none","background":"#ff9900"});
$(".tips:eq("+index+")").css({"left":xobj,"top":yobj}).show();
}).mouseout(function(){
$(".tips").hide();
$(this).css({"width":"224px","z-index":"1","background":"rgba(95,87,80,0.7)"})
})

 })
 
 $(".tips").each(function(){
$(this).mouseover(function(){
$(this).prev(".maintip").css({"width":"224px","z-index":"9999","border-right":"none","background":"rgba(98,93,79,0.7)"})
$(this).show();  
}).mouseout(function(){
$(this).hide(); 
$(this).prev(".maintip").css({"width":"224px","z-index":"1","background":"rgba(98,93,79,0.7)"});
  }) 
 
      })
})