<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=GB2312"%>
<html>
<head>
<title>map</title>
</head>
<body>
	<table align="center" border="1" cellspacing=0 cellpadding=20>
		<tr>
			<th>¼¦µ°</th>
			<th>¹·µ°</th>
			<th>Ñ¼µ°</th>
		</tr>
		<c:if test="${!empty llmm }">
			<c:forEach items="${llmm}" var="list">
				<tr>
					<c:forEach items="${list}" var="map">
						<td>${map.value}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>