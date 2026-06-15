function saveStudent (){

    let id = $('student_id').val();
    let name = $('student_name').val();
    let email = $('student_email').val();
    let phone = $('student_phone').val();

    let contextPath = $('meta[name = "contextPath"]').attr('content');

    $.ajax({
        type: 'POST',
        url: contextPath + "students/saveStudent",
        dataType: 'json',
        data: {id:id, name:name, email:email, phone:phone, contextPath:contextPath },
        success:function(response){
            console.log(response);
            let  finalResponse = JSON.stringify(response);
            $('#results').html("Your response is " + finalResponse);
        },
        error:function(response){
            console.log(response);
        }
    });
}