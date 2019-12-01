<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<c:url var="formAction" value="/favoritePark" />
	<form method="GET" action="${formAction}">
	

<div class="bg-success text-white text-center">
	<h1>${thanks }</h1>
</div>


<div class="centerText">
	<h1 class="">Favorite Parks</h1>
	<h3 class="">Ranked by your survey feedback</h3>
</div>

<div class="main">

	<c:forEach items="${favorites}" var="fav">
	
		<div class="card">
		
		<c:url value="parkDetail?id=${fav.parkCode }" var="linkHref" />
		<c:url value="/img/parks/${fav.imgCode }.jpg" var="parkImg" />
        
      
		<img class="card-img" src="${parkImg}" alt="Photo of ${fav.parkName }" />
		
		<div class="card-img-overlay">
		<div class="cardLabel">
		
		
		<h2 class="card-text">${fav.parkName }</h2>
		<h2 class="card-text">Vote Count: ${fav.count }</h2>
		
		<a href="${linkHref}" class="btn btn-primary">Details</a>
		
		</div>
		</div>
		
		
		</div>
	
	</c:forEach>
</div>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

