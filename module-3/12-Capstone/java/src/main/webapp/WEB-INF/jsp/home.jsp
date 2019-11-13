<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<section class="planet">

<!-- this info will have to dynamically generate in a loop -->
        
<div id="main-content">
	<c:forEach items="${parks}" var="park">
		
		<c:url value="/" var="homePageHref" />
    		<c:url value="/img/logo.png" var="logoSrc" />
        <a href="${homePageHref}">
        		<img src="${logoSrc}" alt="National Park Geek logo" />
        </a>
   </header>  
   
   
        <h2>${park.parkName }</h2><!-- can pull this name as a variable off the object -->
        <c:url value="parkDetail?id=${park.parkCode }" var="linkTo" />
        <c:url var="ImgSrc" value="/img/${park.parkCode }.jpg" />
        
		<img src="${ImgSrc}" alt="Photo of ${park.parkName }">
		
        <p></p>
    </section>
    
    </c:forEach>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />