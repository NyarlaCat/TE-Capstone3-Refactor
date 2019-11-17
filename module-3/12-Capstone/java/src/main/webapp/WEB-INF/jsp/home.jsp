<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />



<div id="main-content">
<div class="card-columns">
	<c:forEach items="${parks}" var="park">
	<div class="card shadow">
	<div class="card-body">
        
     	<c:url value="parkDetail?id=${park.parkCode }" var="linkHref" />
     	
    	<c:url value="/img/parks/${park.imgCode }.jpg" var="parkImg" />
    	
    	
    	
    <div class="hovereffect">
        <img class="img-responsive" src="${parkImg}" alt="Photo of ${park.parkName }">
        <div class="overlay">
         <h2>${park.parkName }</h2>
           <a class="info" href="${linkHref}">Click to learn more</a>
        </div>
    </div>
    
        <h4 class="card-text">${park.state }</h4>
        <p class="card-text">${park.parkDescription }</p>
	</div>
	</div>
    </c:forEach>
   
</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
