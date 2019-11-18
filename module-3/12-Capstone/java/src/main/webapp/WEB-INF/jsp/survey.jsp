<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="pageTitle" value="Register"/>
<%@include file="common/header.jsp" %>

<c:url value="/survey" var="url"/>
<form:form action="${url}" method="POST" modelAttribute="survey">


<div class="survey">
	<div class="form-group">
		<form:label path="email">Email</form:label>
		<form:input path="email" class="form-control"/>
		<form:errors path="email"  class="badge badge-danger"/>
	</div>
	
	<div class="form-group">
		<form:label path="parkCode">What is your favorite park?</form:label>
		<select class="custom-select" name="parkCode">
			<c:forEach items="${surveyParks}" var="park">				
			<option value="${park.parkCode }">${park.parkName }</option>
			</c:forEach>
		</select>
	</div>
	
	<div class="form-group">
		<label  path="activityLevel">What is your activity level?</label>
		<select class="custom-select" name="activityLevel">
			<option value="inactive">Inactive</option>
			<option value="sedentary">Sedentary</option>
			<option value="active">Active</option>
			<option value="xtreme activ">Extremely Active</option>
		</select>
	</div>
	
	<div>
		<label path="state">State of Residence:</label> 
		<select name="state" class="custom-select">
			<option value="AL">Alabama</option>
			<option value="AK">Alaska</option>
			<option value="AZ">Arizona</option>
			<option value="AR">Arkansas</option>
			<option value="CA">California</option>
			<option value="CO">Colorado</option>
			<option value="CT">Connecticut</option>
			<option value="DE">Delaware</option>
			<option value="DC">District Of Columbia</option>
			<option value="FL">Florida</option>
			<option value="GA">Georgia</option>
			<option value="HI">Hawaii</option>
			<option value="ID">Idaho</option>
			<option value="IL">Illinois</option>
			<option value="IN">Indiana</option>
			<option value="IA">Iowa</option>
			<option value="KS">Kansas</option>
			<option value="KY">Kentucky</option>
			<option value="LA">Louisiana</option>
			<option value="ME">Maine</option>
			<option value="MD">Maryland</option>
			<option value="MA">Massachusetts</option>
			<option value="MI">Michigan</option>
			<option value="MN">Minnesota</option>
			<option value="MS">Mississippi</option>
			<option value="MO">Missouri</option>
			<option value="MT">Montana</option>
			<option value="NE">Nebraska</option>
			<option value="NV">Nevada</option>
			<option value="NH">New Hampshire</option>
			<option value="NJ">New Jersey</option>
			<option value="NM">New Mexico</option>
			<option value="NY">New York</option>
			<option value="NC">North Carolina</option>
			<option value="ND">North Dakota</option>
			<option value="OH">Ohio</option>
			<option value="OK">Oklahoma</option>
			<option value="OR">Oregon</option>
			<option value="PA">Pennsylvania</option>
			<option value="RI">Rhode Island</option>
			<option value="SC">South Carolina</option>
			<option value="SD">South Dakota</option>
			<option value="TN">Tennessee</option>
			<option value="TX">Texas</option>
			<option value="UT">Utah</option>
			<option value="VT">Vermont</option>
			<option value="VA">Virginia</option>
			<option value="WA">Washington</option>
			<option value="WV">West Virginia</option>
			<option value="WI">Wisconsin</option>
			<option value="WY">Wyoming</option>
		</select>
	</div>

	<input type="submit" value="Submit" class="btn btn-primary"/>
</div>	
</form:form>
<%@include file="common/footer.jsp" %>