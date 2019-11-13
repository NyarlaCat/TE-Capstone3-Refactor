<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<section class="planet">

<!-- this info will have to dynamically generate in a loop -->
        
<div id="main-content">
	<c:forEach items="${parks}" var="park">
		<section>
        <h2>${park.parkName }</h2>
     	<c:url value="parkDetail?id=${park.parkCode }" var="linkHref" />
    		<c:url value="/img/${park.parkCode }.jpg" var="parkImg" />
        <a href="${linkHref}">
        		<img src="${parkImg}" alt="Photo of ${park.parkName }" />
        </a>
		
        <p>${park.parkDescription }</p>
    </section>
    
    </c:forEach>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />