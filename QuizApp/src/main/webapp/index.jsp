<%@include file="templates/header.jsp"%>

<%
    if(session.getAttribute("username") != null){
        response.sendRedirect("home");
    }
%>

<div class="container w-50 vh-100 jumbotron d-flex">
    <div class="mb-auto mt-auto w-100 p-5 shadow-sm rounded bg-white">
        <form action="set-username-points">
            <h3>Enter your name to start!</h3>
            <div class="col-md-4 w-100">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" name="username" id="username" placeholder="Mario" required>
                <div hidden class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <button type="submit" class="btn btn-primary mt-3 float-end">START</button>
        </form>
    </div>
</div>

<script src="assets/script.js"></script>

<%@include file="templates/footer.jsp"%>