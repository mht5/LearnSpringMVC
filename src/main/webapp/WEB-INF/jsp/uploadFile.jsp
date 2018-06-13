<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Upload File</title>
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
		<script>
			var totalFileLength, totalUploaded, fileCount, filesUploaded;
			
			function debug(s) {
				var debug = document.getElementById("debug");
				if (debug) {
					debug.innerHTML = debug.innerHTML + "<br/>" + s;
				}
			}
			
			function onUploadComplete(e) {
				totalUploaded += document.getElementById("files").files[filesUploaded].size;
				filesUploaded++;
				debug("complete " + filesUploaded + " of " + fileCount);
				debug("totalUploaded: " + totalUploaded);
				if (filesUploaded < fileCount) {
					uploadNext();
				} else {
					var bar = document.getElementById("bar");
					bar.style.width = "100%";
					bar.innerHTML = "100% complete";
					alert("Finished uploading file(s)");
				}
			}
			
			function onFileSelect(e) {
				var files = e.target.files;
				var output = [];
				fileCount = files.length;
				totalFileLength = 0;
				for (var i = 0; i < fileCount; i++) {
					var file = files[i];
					output.push(file.name, "(", file.size, "bytes, ", file.lastModifiedDate.toLocaleDateString(), ")");
					output.push("<br/>");
					debug("add " + file.size +" bytes");
					totalFileLength += file.size;
				}
				document.getElementById("selectedFiles").inerHTML = output.join(" ");
				debug("totalFileLength: " + totalFileLength);
			}
			
			function onUploadProgress(e) {
				if (e.lengthComputable) {
					var percentComplete = parseInt((e.loaded + totalUploaded) * 100 / totalFileLength);
					var bar = document.getElementById("bar");
					bar.style.width = percentComplete + "%";
					bar.innerHTML = percentComplete + "% complete";
				} else {
					debug("unable to compute");
				}
			}
			
			function onUploadFailed(e) {
				alert("Error uploading file");
			}
			
			function uploadNext() {
				var xhr = new XMLHttpRequest();
				var fd = new FormData();
				var file = document.getElementById("files").files[filesUploaded];
				fd.append("multipartFile", file);
				xhr.upload.addEventListener("progress", onUploadProgress, false);
				xhr.addEventListener("load", onUploadComplete, false);
				xhr.addEventListener("error", onUploadFailed, false);
				xhr.open("POST", "save-file");
				debug("uploading " + file.name);
				xhr.send(fd);
			}
			
			function startUpload() {
				totalUploaded = filesUploaded = 0;
				uploadNext();
			}
			
			window.onload = function() {
				document.getElementById("files").addEventListener("change", onFileSelect, false);
				document.getElementById("uploadButton").addEventListener("click", startUpload, false);
			}
		</script>
	</head>
	<body>
		<header class="navbar">
			<section class="navbar-section">
		    	<a href="<%=request.getContextPath()%>/index.html" class="navbar-brand mr-2">Home</a>
		  	</section>
		</header><br/>
		<div id="progressBar" style="height:20px; border:solid 2px green;">
			<div id="bar" style="height: 100%; background:#33dd33; width:0;"></div>
		</div>
		<form>
			<input type="file"  id="files" multiple /><br/>
			<output id="selectedFiles" />
			<input id="uploadButton" type="button" value="Upload" />
		</form>
		<div id="debug" style="height:100px; border:2px solid green; overflow:autp;"></div>
	</body>
</html>