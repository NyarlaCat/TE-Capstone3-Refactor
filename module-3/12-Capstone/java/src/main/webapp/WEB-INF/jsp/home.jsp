<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />



<div id="main-content">
	<c:forEach items="${parks}" var="park">
	
        <h2>${park.parkName }</h2>
     	<c:url value="parkDetail?id=${park.parkCode }" var="linkHref" />
    		<c:url value="/img/parks/${park.imgCode }.jpg" var="parkImg" />
        <a href="${linkHref}">
        		<img src="${parkImg}" alt="Photo of ${park.parkName }" />
        </a>
        <h4>${park.state }</h4>
        <p>${park.parkDescription }</p>

    </c:forEach>
   
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />