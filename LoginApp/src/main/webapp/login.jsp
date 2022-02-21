<%@include file="templates/header.jsp"%>

<div class="container w-50 vh-100 jumbotron d-flex">
    <div class="mb-auto mt-auto w-100 p-5 shadow-sm rounded bg-white">
        <form method="post" action="login">
            <h3>Login to explore</h3>
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input
                        type="text"
                        class="form-control"
                        id="username"
                        name="username"
                        value="${username}"
                />
            </div>
            <div class="mb-3">
                <label for="password" class="form-label"
                >Password</label
                >
                <input
                        type="password"
                        class="form-control"
                        id="password"
                        name="password"
                />
            </div>
            <p class="text-danger">${error == null ? "" : error}</p>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
    </div>
</div>

<%@include file="templates/footer.jsp"%>
