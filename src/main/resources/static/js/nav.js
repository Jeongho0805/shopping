$(document).ready(function(){
    debugger
    // let sLoginId = localStorage.getItem('sLoginId');
    // if(sLoginId && sLoginId != 'logout'){
    //     $('#logout_state').css('display', 'none');
    //     $('#userInfo')[0].innerHTML = '<span style="font-weight: bold; font-size: 16px;">' + sLoginId + '</span> 님 안녕하세요';
    // }
    // else{
    //     $('#login_state').css('display', 'none');
    // }
    if($('#userInfo').length){
        // $('#userInfo')[0].innerHTML = '<span style="font-weight: bold; font-size: 16px;">' + loginInfo.username + '</span> 님 안녕하세요';
    }
});
$('#SIGN_IN').on('click', function(e){
    location.href = '/account/login';
});

$('#SIGN_UP').on('click', function(e){
    location.href = "/account/register";
});

$('#LOGOUT').on('click', function(){
    // commRequest('/logout', 'post', null, function(outRec, status){
    //     debugger
    // })
    $('#LOGOUT_BTN').click();
})