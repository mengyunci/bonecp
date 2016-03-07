<#assign base=rc.contextPath/>
<!DOCTYPE html>
<html lang="en">
<head>
    <base id="base" href="${base}">
	<script src="${base}/js/index.js"></script>
</head>
<body>
	Date: ${time?date}
	<br>
	Time: ${time?time}
	<br>
	Message: ${message}
</body>

</html>
