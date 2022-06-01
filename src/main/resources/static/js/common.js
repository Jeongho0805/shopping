// var sessionStorage = window.sessionStorage;


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

// function getLoginInfo(sId){
//     let url = '/account/loginInfo';
//     commRequest(url, "post", null, function(outRec, status){
//         debugger
//         if(status == "success"){
//             if(outRec != "fail"){
//                 sessionStorage.setItem("loginInfo", outRec);
//             }
//         }
//     });
// }
