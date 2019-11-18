<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<c:url var="formAction" value="/parkDetails" />
	<form method="GET" action="${formAction}">
	
	<div class="container" >
	
		<div class="d-flex flex-column" >
			<div class="p-2"> 
			<h1>${parkDetail.parkName }</h1>
			</div>
		</div>
	
		<div class="d-flex justify-content-around">
		
		<div class="p-2">
		<c:url value="/img/parks/${parkDetail.imgCode }.jpg" var="parkImg" ></c:url>
		<img class= "rounded-lg" src="${parkImg}" alt="Photo of ${parkDetail.parkName }" />
		</div>
		
		<div class="p-2">
			<blockquote class="blockquote weatherCard text-center shadow">
			<p class="mb-0">"${parkDetail.inspirationalQuote }"</p>
			<footer class="blockquote-footer">
			 <cite title="Source Title"> ${parkDetail.inspirationalQuoteSource }</cite>
			</footer>
			</blockquote>
			<input class="shadow-lg p-3 rounded btn btn-primary" type="button" onclick="window.location.href = 'parkWeather?id=${parkDetail.parkCode }';" value="5-Day Weather Forecast"/>
			
		</div>
		
		
		</div>
		
	</div>
		
<div class="container" >
	<div class="d-flex flex-wrap align-content-start">

	
	<div class="p-2 inline">
	<p class="font-weight-bold">State: </p>
	<p>${parkDetail.state}</p>
	</div>
	
	<div class="p-2 inline">
	<p class="font-weight-bold">Acreage: </p>
	<p> ${parkDetail.acreage}</p>
	</div>
	
	<div class="p-2 inline">
	<p class="font-weight-bold">Elevation: </p>
	<p> ${parkDetail.elevationInFeet}</p>
	</div>
	
	<div class="p-2 inline">
	<p class="font-weight-bold">Miles of Trail: </p>
	<p>${parkDetail.milesOfTrail}</p>
	</div>
	
	<div class="p-2 inline">
	<p class="font-weight-bold">Number of Campsites: </p> 
	<p >${parkDetail.numberOfCampsites}</p>
	</div>
	
	<div class="p-2 inline">
	<p class="font-weight-bold">Climate: </p>
	<p> ${parkDetail.climate} </p>
	</div>
	
	<div class="p-2 inline">
	<p class="font-weight-bold">Year Founded: </p>
	<p>${parkDetail.yearFounded} </p>
	</div>
	
	<div class="p-2 inline">
	<p class="font-weight-bold">Annual Visitor Count: </p>
	<p>${parkDetail.annualVisitorCount} </p>
	</div>
	
	<div class="p-2 inline">
	<p class="font-weight-bold">Entry fee: </p>
	<p>${parkDetail.entryFee} </p>
	</div>
	
	<div class="p-2 inline">
	<p class="font-weight-bold ">Number of Animal Species: </p>
	<p> ${parkDetail.numberOfAnimalSpecies}</p>
	</div>
	
	<div class="p-2">
	<p class="font-weight-bold">Details: </p>
	<p> ${parkDetail.parkDescription}</p>
	</div>
	
	
	</div>
	
</div>	


</form>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />

