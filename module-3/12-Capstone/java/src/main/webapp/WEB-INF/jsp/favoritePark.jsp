<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<c:url var="formAction" value="/favoritePark" />
	<form method="GET" action="${formAction}">
	

<h1>${thanks }</h1>


<div class="centerText">
<h1 class="">Favorite Parks</h1>
<h3 class="">Ranked by your survey feedback</h3>
</div>



	<c:forEach items="${favorites}" var="fav">
		
		<div class="faveGrid">
		
		<c:url value="/img/parks/${fav.imgCode }.jpg" var="parkImg" />
		
		<img class="favePhoto" src="${parkImg}" alt="Photo of ${fav.parkName }" />
		
		<h2 class="faveName">${fav.parkName }</h2>
		
		<h2 class="faveVote">Vote Count: ${fav.count }</h2>
		
		</div>
		
	</c:forEach>
	
	

<c:import url="/WEB-INF/jsp/common/footer.jsp" />