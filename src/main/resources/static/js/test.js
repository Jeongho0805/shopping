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

