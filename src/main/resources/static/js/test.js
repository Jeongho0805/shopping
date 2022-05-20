var localhost = 'localhost:8080/test/';

let g_btn;
let g_input;

function onInit(){
    console.log('hello');
    g_input = document.getElementById('myInput');
    g_btn = document.getElementById('myBtn');

    g_btn.addEventListener('click', btnClick);
}

//JSON.stringify(data)
function btnClick(){
    debugger;
    let data = {data: g_input.value};
    let url = '/test/btn2';
    commRequest(url, "post", data, function(outRec, status){
        debugger
        if(status == "success"){
            debugger
            console.log('get success');
            alert('success');
        }
        else{
            alert('fail')
        }
    });

}

function commRequest(url, type, data, callback) {
    $.ajax({
        url: url,
        contentType: 'application/json',
        type: type,
        data: JSON.stringify(data),
        beforeSend: function (jqXHR, settings) {
                   var header = $("meta[name='_csrf_header']").attr("content");
                   var token = $("meta[name='_csrf']").attr("content");
                   jqXHR.setRequestHeader(header, token);
        	},
        success: function (data, status) {
            if (callback) callback(data, status)
        },
        error: function (err, status,errorThrown) {
            if (callback) callback(err, status, errorThrown)
        }
    });
}
