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
    let data = {
        data: {
            input: g_input.value,
            innerData: 'some Data',
            innerData2: {
                strData: 'some Data',
                numData: 123,
                boolData: true,
                nullData: null,
                arrData: [1,2,3],
            }
        }
    };
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

