$(function(){
 
    $(".maintip").each(function(index){   //����A���֣�ע��������¼�����index����
        $(this).mouseover(function(){   //��꾭��Aʱ�����¼�
            var obj=$(this).offset();   //��ȡ����꾭����A��ƫ��λ�ã�offset()�Ǹ��ö��������������ѵ�ȥ�˽���
            var xobj=obj.left+224+"px"; //����Ҫ��Bˮƽƫ�Ƶľ��룬����ġ�200���ǿ��Զ���ģ���Ȼ����Ը�Ϊ$(this).width()����ø�Aһ���Ŀ��
            var yobj=obj.top+"px";     //����Ҫ��B��ֱƫ�Ƶľ���
            $(this).css({"width":"224px","z-index":"9999","border-right":"none","background":"rgba(98,93,79,0.7)"});  //A�ı���ʽ����Ϊѡ��״̬��Ч��
            $(".tips:eq("+index+")").css({"left":xobj,"top":yobj}).show();   //��Ӧ�ģ�����������������B�ı���ʽ����ʾ����
            })
        .mouseout(function(){     //����뿪Aʱ�������¼�
            $(".tips").hide();     //B����
            $(this).css({"width":"224px","z-index":"1","background":"rgba(98,93,79,0.7)"})   //A���ԭʼ��ʽ
        })
    })
    
         $(".tips").each(function(){  //����B
            $(this).mouseover(function(){  //��꾭��Bʱ�����¼�
            $(this).prev(".maintip").css({"width":"224px","z-index":"9999","border-right":"none","background":"rgba(98,93,79,0.7)"})  //��Ӧ��A��Ϊѡ��״̬Ч��
            $(this).show();  //A��Ҫ�����ˣ������Ϊ����д������뿪A����A����
        })
        .mouseout(function(){  //����뿪B�����¼�����ʵ������B���أ�ͬʱA��Ϊԭʼ״̬
            $(this).hide();   
            $(this).prev(".maintip").css({"width":"200px","z-index":"1","background":"rgba(98,93,79,0.7)"});
        }) 
    })
})