var preLoder = '<div class="preloader-wrapper center big active"><div class="spinner-layer spinner-blue-only"><div class="circle-clipper left"><div class="circle"></div></div><div class="gap-patch"><div class="circle"></div></div><div class="circle-clipper right"><div class="circle"></div></div></div></div>';

function ajaxJsonUrl(url, quertString, methodType) {
	$.ajax({
		url : url,
		type : methodType,
		crossDomain: true,
		dataType : "html",
		data : quertString,
		success : ajaxSuccessFunction
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

function ajaxSuccessFunction(data){
	console.log(data);
}

function beforeAjaxCallFunction(data){
	console.log(data);
}

function ajaxErrorFunction(data){
	console.log(data);
}