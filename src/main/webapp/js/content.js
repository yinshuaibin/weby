
$(document).ready(function(){
    $('.title-prize .triangle2').click(function(){
        $(this).parent().next().toggle().siblings();
        $(this).find('i').toggleClass('triang2');
    })

    $('.div-title-r,.div-title-l').hide();
    $('.pic2 li,.pic li').mouseenter(function(){
        var that=$(this);
        var div_title=that.children('.div-title-r,.div-title-l').removeClass('div-title-l').addClass('div-title-r').show();
        var div_title2=that.children('.position,.position-l').removeClass('position').addClass('position-l').show();
        var window_width=window.innerWidth;
        var title_right_position=(div_title.offset()||{left:0}).left+div_title.width();
        var title_right_position2=(div_title.offset()||{left:0}).left+div_title.width();
        if(title_right_position>window_width){
            div_title.removeClass('div-title-r').addClass('div-title-l');
        }else{
            div_title.removeClass('div-title-l').addClass('div-title-r');
        }
        if(title_right_position2>window_width){
            div_title2.removeClass('position').addClass('position-l');
        }else{
            div_title2.removeClass('position-l').addClass('position');
        }
        $('.div-title-r .close,.div-title-l .close').click(function(){
            $(this).parent().hide();
        })
    })

    $('.pic2 li,.pic li').mouseleave(function () {
        $(this).children('.div-title-r,.div-title-l').hide();
    })
						   
});
//    tab切换
$(function(){
    function hanshu(nav,cont){
        var length=$(nav).length;
        for(var i=0;i<length;i++){
            $(nav)[i].index=i;
            $(nav).eq(i).click(function(){
                $(cont).css("display","none");//ul的隐藏
                $(cont).eq(this.index).css("display","block");//ui的隐藏
                $(nav).addClass('active');//导航条的显示
                $(this).siblings().removeClass('active');//导航条的隐藏
            })
        }
    }
    hanshu($(".list-t>ul li"),$(".content-cent"));
});