
    var student = {
        name : 'Alex',
        age : 21,
        gender : 'man',
        info : '我爱学习'
    };
    // console.log(JSON.stringify(student,null,'   '));
    var  jsonString = JSON.stringify(student);

    $.ajax({
        type:"post",
        url:'ajaxServlet',
        data:{'mydata':jsonString},
        success:function () {
            alert("向后端传值成功");
        },
        error:function () {
            alert("向后端传值失败");
        }
    });

    $.ajax({
        type:"get",
        url:'ajaxServlet',
        data:{},
        dataType:'json',
        success:function (data) {
            alert("向前端传值成功");
            $.each(data,function (index,value) {
                console.log("index===="+index);
                console.log("value===="+value);
            });
        },
        error:function () {
            alert("向前端传值失败");
        }
    });

