<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Park Geek</title>
    <c:url value="/css/bootstrap.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
    <header>
    		<c:url value="/" var="homePageHref" />
    		<c:url value="/img/logo.png" var="logoSrc" />
    		
   
        <a href="${homePageHref}">
        		<img class="logo" src="${logoSrc}" alt="National Park Geek logo"/>
        </a>

        
        
   </header>  
    <nav class="navbar sticky-top navbar-dark bg-primary">
        <h1 id="changeFontColor" >Explore National Parks</h1>
            <a  class="navbar-brand btn btn-primary" href="home">Home</a>
            <a  class="navbar-brand btn btn-primary" href="survey">Survey</a>
            <a 	class="navbar-brand btn btn-primary" href="favoritePark">Favorite Parks</a>
    </nav>
    
 