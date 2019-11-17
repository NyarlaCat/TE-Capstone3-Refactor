<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="formAction" value="/parkWeather" />
<form method="POST" action="${formAction}">
	


<div class="weatherPage">
	<h1 class="weatherName">${weatherPark.parkName }</h1>

	<c:url value="/img/parks/${weatherPark.imgCode }.jpg" var="parkImg" ></c:url>
	
	<input id="weatherConvert"  class="shadow-lg p-3 rounded btn btn-primary" type="submit" value="Convert Temperature"/>

	<img  class="weatherPhoto" src="${parkImg}" alt="Photo of ${weatherPark.parkName }" />
	
	<input type="hidden" name="id" value="${weatherPark.parkCode}" />
</div>

<div class="container">


<c:forEach items="${weather}" var="dailyWeather">
<div class="d-flex justify-content-start">
	
	<div class="p-2">
		<c:choose>
			<c:when test="${dailyWeather.fiveDayForecastValue == 1 }">
			<h1>TODAY</h1>
			</c:when>
		</c:choose>
		<c:url value="/img/weather/${dailyWeather.forecastImage }.png" var="weatherImg" ></c:url>
		<img  src="${weatherImg}" alt="Clipart image of ${dailyWeather.forecastImage }" />
	
		
	</div>


<div class="p-2" id="flexCent">
		<c:choose>
		<c:when test="${Temperature == 'C' }" >
			<h2>Low: ${dailyWeather.farenheightToCelsiusLow} ${Temperature}</h2>
			<h2>High: ${dailyWeather.farenheightToCelsiusHigh} ${Temperature}</h2>
		</c:when>
		<c:when test="${Temperature == 'F' ||  Temperature == null}">
			<h2>Low: ${dailyWeather.low } F</h2>
			<h2>High: ${dailyWeather.high} F</h2>
		</c:when>
		</c:choose>

	<h2>Forecast: ${dailyWeather.forecast }</h2>
	
	<c:set var="weather" value="${dailyWeather.forecast}"></c:set>
	<c:set var="temperatureHigh" value="${dailyWeather.high}"></c:set>
	<c:set var="temperatureLow" value="${dailyWeather.low}"></c:set>
	<c:set var="temperatureDifference" value="${temperatureHigh - temperatureLow}"></c:set>
</div>
	
	
<div class="p-2" id="flexCent">
	<c:choose>
		
		<c:when test="${temperatureLow < 20 }">
		<p>Be aware of dangerous conditions. A temperature of 0 degrees Fahrenheit and a wind speed of 15 mph creates a wind chill temperature of -19 degrees Fahrenheit. Under these conditions frost bite can occur in just 30 minutes. Extremely cold temperature can also cause hypothermia. Warning signs include uncontrollable shivering, memory loss, disorientation, incoherence, slurred speech, drowsiness, and obvious exhaustion.</p>
		</c:when>
		
		<c:when test="${weather == 'snow' }">
		<p>Pack snow shoes.</p>
		</c:when>
	
	
		<c:when test="${weather == 'rain' }">
		<p>Pack rain gear, wear waterproof shoes. Consider bigger boats.</p>
		</c:when>
	
	
		<c:when test="${weather == 'thunderstorms' }">
		<p>Seek shelter and avoid hiking on exposed ridges.</p>
		</c:when>
	
	
		<c:when test="${weather == 'sunny' }">
		<p>Wear sunblock.</p>
		</c:when>
	
	
		<c:when test="${temperatureHigh > 75 }">
		<p>Bring an extra gallon of water.</p>
		</c:when>

	
		<c:when test="${temperatureDifference > 20 }">
		<p>Wear breathable layers.</p>
		</c:when>	
	</c:choose>
</div>
</div>
	</c:forEach>
</div>

</form>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />