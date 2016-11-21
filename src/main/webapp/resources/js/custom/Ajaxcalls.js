var preLoder = '<div class="preloader-wrapper center big active"><div class="spinner-layer spinner-blue-only"><div class="circle-clipper left"><div class="circle"></div></div><div class="gap-patch"><div class="circle"></div></div><div class="circle-clipper right"><div class="circle"></div></div></div></div>';

function ajaxPosturl(url, jsonObject) {

	$.ajax({
		url : url,
		type : "POST",
		dataType : "json",
		contentType : "Application/Json",
		data : JSON.stringify(jsonObject),
		success : function(data) {
			console.log(data.Attempt);
		},
		failure : function(errMsg) {
		}
	});
}

function ajaxGeturl(url, jsonObject) {
	$.ajax({
		url : url,
		type : "GET",
		dataType : "json",
		contentType : "Application/Json",
		data : JSON.stringify(jsonObject),
		success : function(data) {
			console.log(data.Attempt);

		},
		failure : function(errMsg) {
		}
	});
}

function ajaxGeturlForSideNav(url, divIdToReplace) {
	$.ajax({
		url : url,
		type : "GET",
		success : function(data) {			
			$('#' + divIdToReplace).html('');	
			$('#' + divIdToReplace).html(preLoder);
			$(".menuButton").trigger("click");
			$(".drag-target").trigger('click');
			setTimeout(function() {				
				$('#' + divIdToReplace).html(data);								
				setDefautValues();
			}, 1000);
		},
		failure : function(errMsg) {
			console.log('ajaxfail');
		},
		done : function() {
			setDefautValues();
		}
	});
}