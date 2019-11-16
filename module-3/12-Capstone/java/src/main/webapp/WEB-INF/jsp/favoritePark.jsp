<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<c:url var="formAction" value="/favoritePark" />
	<form method="GET" action="${formAction}">
	
<div id="main-content">
<h1>${thanks }</h1>
<h1 class="centered">Favorite Parks</h1>
<h3 class="centered">Ranked by your survey feedback</h3>

	<c:forEach items="${favorites}" var="fav">
		<c:url value="/img/parks/${fav.imgCode }.jpg" var="parkImg" />
		<img src="${parkImg}" alt="Photo of ${fav.parkName }" />
		<h2>${fav.parkName }</h2>
		<h2>Vote Count: ${fav.count }</h2>
	</c:forEach>
	
	
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />