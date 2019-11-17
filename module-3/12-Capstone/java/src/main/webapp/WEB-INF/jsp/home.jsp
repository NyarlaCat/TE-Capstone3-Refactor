<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />



<div id="main-content">
<div class="card-columns">
	<c:forEach items="${parks}" var="park">
	<div class="card">
	<div class="card-body">
        <h2 class="card-text">${park.parkName }</h2>
        
     	<c:url value="parkDetail?id=${park.parkCode }" var="linkHref" />
     	
    	<c:url value="/img/parks/${park.imgCode }.jpg" var="parkImg" />
    	
        <a href="${linkHref}">
        <img src="${parkImg}" alt="Photo of ${park.parkName }" />
        </a>
        
        <h4 class="card-text">${park.state }</h4>
        <p class="card-text">${park.parkDescription }</p>
	</div>
	</div>
    </c:forEach>
   
</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
