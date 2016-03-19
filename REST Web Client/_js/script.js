// --disable-web-security should be enabled for the chrome.
$(document).ready(function(){
    $("#div0").show();
	$("#div1").hide();
	$("#div2").hide();
	$("#div3").hide();
	$("#div4").hide();
	$("#div5").hide();
	$("#button_create").click(function(){
        $("#div0").hide();
		$("#div1").show();
		$("#div2").hide();
		$("#div3").hide();
		$("#div4").hide();
		$("#div5").hide();
    });
	$("#button_read").click(function(){        
		$("#div0").hide();
		$("#div1").hide();
		$("#div2").show();
		$("#div3").hide();
		$("#div4").hide();
		$("#div5").hide();
    });
	$("#button_update").click(function(){        
		$("#div0").hide();
		$("#div1").hide();
		$("#div2").hide();
		$("#div3").show();
		$("#div4").hide();
		$("#div5").hide();
    });
	$("#button_delete").click(function(){        
		$("#div0").hide();
		$("#div1").hide();
		$("#div2").hide();
		$("#div3").hide();
		$("#div4").show();
		$("#div5").hide();
    });
	$("#sub_update").click(function(){        
		$("#div0").hide();
		$("#div2").hide();
		$("#div3").hide();
		$("#div4").hide();
		$("#div1").show();
		$("#div5").hide();
		//$('input[name="Emp. ID"]').val("hail high");
		//$("#rtn_frm_update").val($("#send_val_update").val);
    });

$("#delete_button").click(function(){        
		$("#div0").show();
		$("#div2").hide();
		$("#div3").hide();
		$("#div4").hide();
		$("#div1").hide();
		$("#div5").hide();
		//$('input[name="Emp. ID"]').val("hail high");
		//$("#rtn_frm_update").val($("#send_val_update").val);
    });

	$("#button_read").click(function(){
		
		var url = "http://localhost:8080/CustCRUDRestService/customer";
		$.getJSON(url,function (data) {
			$('#read_table').find("tr:gt(0)").remove();
			var tr;
		   	for (var i = 0; i < data.length; i++) {
		   		//alert("Congrats  " + data[i].customer_id);
			   	tr = $('<tr>');
		  		tr.append("<td>" + data[i].customer_id + "</td>");
		   		tr.append("<td>" + data[i].customer_name + "</td>");
		   		$('#read_table').append(tr);
		    	}
		});
		
	});
	
	$("#up_button").click(function(){
		$("#div3").hide();
		//$("#div5").show();
		var id = $('#cust_ID_update').val();
		var url = "http://localhost:8080/CustCRUDRestService/customer/"+id;
		var jqxhr = $.getJSON(url,function (data) {
			
			$("#customer_id1").val(data.customer_id);
			$("#customer_name1").val(data.customer_name);
		})
		.done(function() {
			$("#div5").show();
			console.log( "success" );
		})
		.fail(function() {
			$("#div5").hide();
			$("#div3").show();
    			console.log( "error" );
  		});
	});

	$("#delete_button").click(function(){
		
		//$("#home").show();
		var id = $('#cust_ID_delete').val();
		
		var url = "http://localhost:8080/CustCRUDRestService/customer/"+id;
		
		$.ajax({
			url: url,
			processData: false,
			type:'DELETE',
			success: function(data){
			   console.log('Delete success!')
			   $("#home").show();
			}//,
			//error: function(data){
			  // console.log('Delete failed!')
			   //$("#div4").show();
			//}
		});
	});
	
	$("#create_button").click(function(){
		
		var url = "http://localhost:8080/CustCRUDRestService/customer";
		
                    console.log('Create button clicked!')
                    
                    $.ajax({
                      url: url,
                      data: JSON.stringify({ "customer_id": $('#customer_id').val() , "customer_name": $('#customer_name').val() }),
                      processData: false,
                      contentType: 'application/json',
                      type:'POST',
                      dataType:'json',
                      Accept: 'application/json',
                      success: function(data){
                        console.log('Create success!')
                        
                      }
                    });
	});
	
	$("#update_button").click(function(){
		
		var id = $('#customer_id1').val();
		var url = "http://localhost:8080/CustCRUDRestService/customer/" + id;
		
                    console.log('Update button clicked!')
                    
                    $.ajax({
                      url: url,
                      data: JSON.stringify({ "customer_id": $('#customer_id1').val() , "customer_name": $('#customer_name1').val() }),
                      processData: false,
                      contentType: 'application/json',
                      type:'PUT',
                      dataType:'json',
                      Accept: 'application/json',
                      success: function(data){
                        console.log('Update success!')
                        
                      }
                    });
	});
});