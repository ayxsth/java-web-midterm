<%@include file="templates/header.jsp"%>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache");   //HTTP 1.0
    response.setHeader("Expires", "0"); //Proxies
%>

<c:if test="${user != null}">
    <c:redirect url="home"/>
</c:if>

<div class="container w-50 vh-100 jumbotron d-flex">
    <div class="mb-auto mt-auto w-100 p-5 shadow-sm rounded bg-white">
        <h1>Welcome ;)</h1>
        <h3>Login to proceed!</h3>
        <a class="btn btn-primary" href="login">Login</a>
    </div>
</div>

<%@include file="templates/footer.jsp"%>
