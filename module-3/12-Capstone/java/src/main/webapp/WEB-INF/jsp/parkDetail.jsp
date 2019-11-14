<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
	<c:url var="formAction" value="/productDetails" />
	<form method="GET" action="${formAction}">
	

<div id="main-content">
	<div class="centered">
	<h1>${parkDetail.parkName }</h1>
	<c:url value="/img/parks/${parkDetail.imgCode }.jpg" var="parkImg" ></c:url>
	
	<img src="${parkImg}" alt="Photo of ${parkDetail.parkName }" />
	<h2>"${parkDetail.inspirationalQuote }"
	-- ${parkDetail.inspirationalQuoteSource }</h2>
	<nav>
        <ul>
            <li id="weatherNav"><a id="weatherNavText" href="parkWeather?id=${parkDetail.parkCode }">5-Day Weather Forecast</a></li>
        </ul>
    </nav>
	</div>

	
    
	<h4>State: ${parkDetail.state}</h4>
	
	<h4>Acreage: ${parkDetail.acreage}</h4>
	
	<h4>Elevation: ${parkDetail.elevationInFeet}</h4>
	
	<h4>Miles of Trail: ${parkDetail.milesOfTrail}</h4>
	
	<h4>Number of Campsites: ${parkDetail.numberOfCampsites}</h4>
	
	<h4>Climate: ${parkDetail.climate}</h4>
	
	<h4>Year Founded: ${parkDetail.yearFounded}</h4>
	
	<h4>Annual Visitor Count: ${parkDetail.annualVisitorCount}</h4>
	
	<h4>Entry fee: ${parkDetail.entryFee}</h4>
	
	<h4>Number of Animal Species: ${parkDetail.numberOfAnimalSpecies}</h4>
	
	<p>${parkDetail.parkDescription}</p>
	
	
</div>


</form>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />