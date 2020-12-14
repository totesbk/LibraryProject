$(document).ready(function () {
    fullset();
    quickClick();	
});
function fullset() {
    var pageindex = $("#fullpage > .fullsection").size();  //fullpage 안에 섹션이(.fullsection) 몇개인지 확인하기 
    for (var i = 1; i <= pageindex; i++) {
        $("#fullpage > .quick > ul").append("<li></li>");
    }
    $("#fullpage .quick ul :first-child").addClass("on");    //일단 화면이 로드 되었을때는 퀵버튼에 1번째에 불이 들어오게 
    //마우스 휠 이벤트 
    $(window).bind("mousewheel", function (event) {
        var page = $(".quick ul li.on");
        //alert(page.index()+1);   // 현재 on 되어있는 페이지 번호 
        if ($("body").find("#fullpage:animated").length >= 1) return false;
        //마우스 휠을 위로 
        if (event.originalEvent.wheelDelta >= 0) {
            var before = page.index();
            if (page.index() >= 0) page.prev().addClass("on").siblings(".on").removeClass("on");            //퀵버튼옮기기 
            var pagelength = 0;
            for (var i = 1; i < (before); i++) {
                pagelength += $(".full" + i).height();
            }
            if (page.index() > 0) {    //첫번째 페이지가 아닐때 (index는 0부터 시작) 
                page = page.index() - 1;
                $("#fullpage").animate({ "top": -pagelength + "px" }, 1000, "swing");
            } 
        } else {       // 마우스 휠을 아래로 
            var nextPage = parseInt(page.index() + 1);       //다음페이지번호 
            var lastPageNum = parseInt($(".quick ul li").size());      //마지막 페이지번호 
            //현재페이지번호 <= (마지막 페이지 번호 - 1) 
            //이럴때 퀵버튼옮기기 
            if (page.index() <= $(".quick ul li").size() - 1) {
                page.next().addClass("on").siblings(".on").removeClass("on");
            } if (nextPage < lastPageNum) {         //마지막 페이지가 아닐때만 animate ! 
                var pagelength = 0;
                for (var i = 1; i < (nextPage + 1); i++) {
                    //총 페이지 길이 구하기 
                    //ex) 현재 1번페이지에서 2번페이지로 내려갈때는 1번페이지 길이 + 2번페이지 길이가 더해짐 
                    pagelength += $(".full" + i).height();
                }
                $("#fullpage").animate({ "top": -pagelength + "px" }, 1000, "swing");
            } 
        }
    });
    $(window).resize(function () {
        //페이지가 100%이기때문에 브라우저가 resize 될때마다 스크롤 위치가 그대로 남아있는것을 방지하기 위해
        var resizeindex = $(".quick ul li.on").index() + 1;
        var pagelength = 0;
        for (var i = 1; i < resizeindex; i++) {
            //총 페이지 길이 구하기 
            //ex) 현재 1번페이지에서 2번페이지로 내려갈때는 1번페이지 길이 + 2번페이지 길이가 더해짐 
            pagelength += $(".full" + i).height();
        }
        $("#fullpage").animate({ "top": -pagelength + "px" }, 0);
    });
}
//사이드 퀵버튼 클릭 이동 
function quickClick() {
    $(".quick li").click(function () {
        var gnbindex = $(this).index() + 1;
        var length = 0;
        for (var i = 1; i < (gnbindex); i++) {
            length += $(".full" + i).height();
        }
        if ($("body").find("#fullpage:animated").length >= 1)
            return false;
        $(this).addClass("on").siblings("li").removeClass("on");
        $("#fullpage").animate({ "top": -length + "px" }, 800, "swing");
        return false;
    });
}
//로그인/회원가입 박스
$(window).scroll(function () {  //스크롤이 움직일때마다 이벤트 발생 
    var position = $(window).scrollTop(); // 현재 스크롤바의 위치값을 반환합니다.
    $(id).stop().animate({ top: position + "px" }, 1); //해당 오브젝트 위치값 재설정
});

var currentPosition = parseInt($("#sidebox").css("top"));
$(window).scroll(function () {
    var position = $(window).scrollTop();
    $("#sidebox").stop().animate({ "top": position + currentPosition + "px" }, 1000);
});

//시계
document.addEventListener("DOMContentLoaded", function() {
    
    realTimer();    
    setInterval(realTimer, 500);
});

// 시간을 출력
function realTimer() {
    const nowDate = new Date();
    const year = nowDate.getFullYear();
    const month= nowDate.getMonth() + 1;
    const date = nowDate.getDate();
    const hour = nowDate.getHours();
    const min = nowDate.getMinutes();
    const sec = nowDate.getSeconds();
    document.getElementById("nowTimes").innerHTML = 
              year + "년 " + addzero(month) + "월 " + addzero(date) + "일" +"<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ hour + "시 " + addzero(min) + "분 " + addzero(sec)+"초";

}
    // 1자리수의 숫자인 경우 앞에 0을 붙여준다.
function addzero(num) {
    if(num < 10) { num = "0" + num; }
     return num;
}
