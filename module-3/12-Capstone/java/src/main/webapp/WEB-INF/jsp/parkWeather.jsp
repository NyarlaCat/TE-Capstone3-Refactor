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
<div class="d-flex justify-content-start weatherCard shadow">
	
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
		<h3>Pack snow shoes.</h3>
		</c:when>
	
	
		<c:when test="${weather == 'rain' }">
		<h3>Pack rain gear, wear waterproof shoes.</h3>
		</c:when>
	
	
		<c:when test="${weather == 'thunderstorms' }">
		<h4>Seek shelter and avoid hiking on exposed ridges.</h4>
		</c:when>
	
	
		<c:when test="${weather == 'sunny' }">
		<h3>Wear sunblock.</h3>
		</c:when>
	
	
		<c:when test="${temperatureHigh > 75 }">
		<h3>Bring an extra gallon of water.</h3>
		</c:when>

	
		<c:when test="${temperatureDifference > 20 }">
		<h3>Wear breathable layers.</h3>
		</c:when>	
	</c:choose>
</div>
</div>
	</c:forEach>
</div>

</form>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />