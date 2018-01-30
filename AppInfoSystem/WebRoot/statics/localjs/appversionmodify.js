function delfile(id, path) {
	$.ajax({
		type : "GET",// 请求类型
		url : "delAppVersionPath.json",// 请求的url
		data : {
			id : id,
			flag : path
		},// 请求参数
		dataType : "json",// ajax接口（请求url）返回的数据类型
		success : function(data) {// data：返回数据（json对象）
			if (data == "success") {
				alert("删除成功！");
				$("#uploadfile").show();
				$('#attach').attr('required', true);
				$("#apkFile").html('');
			} else if (data == "failed") {
				alert("删除失败！");
			} else if (data == "nulll") {
				alert("文件不存在");
				$("#uploadfile").show();
				$('#attach').attr('required', true);
				$("#apkFile").html('');
			}
		},
		error : function(data) {// 当访问时候，404，500 等非200的错误状态码
			alert("请求错误！");
		}
	});
}

$(function() {
	$("#back").on("click", function() {
		window.location.href = "list";
	});

	// 上传APK文件---------------------
	var downloadLink = $("#downloadLink").val();
	var id = $("#id").val();
	var apkFileName = $("#apkFileName").val();
	if (downloadLink == null || downloadLink == "") {
		$("#uploadfile").show();
	} else {
		$("#apkFile").append(
				"<p>" + apkFileName + "&nbsp;&nbsp;<a href=\"" + downloadLink
						+ "?m=" + Math.random() + "\" >下载</a> &nbsp;&nbsp;"
						+ "<a href=\"javascript:;\" onclick=\"delfile('" + id
						+ "','" + downloadLink + "');\">删除</a></p>");
	}

});
