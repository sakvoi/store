$(function(){

$(".maintip").each(function(index){
var tip_height=$(".tips:eq("+index+")").height();
$(this).mouseover(function(){
var win_height=$(window).height();    //��ȡ�������ǰ��������߶�
var obj=$(this).offset();    
var wobj=$(this).width();
if(obj.top+tip_height<win_height){    //�ж�B�ײ��Ƿ񳬹�������ײ�
    //û��������Ĭ��A��B����ƫ��λ��һ�¼���
    var xobj=obj.left+wobj+"px";
    var yobj=obj.top+"px";
}
else{
    //�����ˣ���ô̧��B����λ��
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