<%@include file="templates/header.jsp" %>

<div class="container w-50 vh-100 my-5 jumbotron d-flex">
    <div class="mb-auto mt-auto w-100 p-5 shadow-sm rounded bg-white">
        <div class="text-end w-100 mb-3">
            <h5>Hello, ${username}!</h5>
            <h6>Points: ${points}</h6>
        </div>

        <div>
            <h3>Attempt all the question to crack the interview ;)</h3>
        </div>

        <form action="home" method="post">
            <div class="questions">
                <c:forEach var="question" items="${questions}" varStatus="loop">
                    <div class="my-5 container p-3 shadow-sm rounded" id="${question.id}">
                        <p><b>${loop.count}. ${question.question} <span class="text-danger">*</span></b></p>
                        <div class="answers m-3 mb-0 d-flex flex-row align-items-center justify-content-between w-75 mx-auto">
                            <div><input type="radio" name="${question.id}" value="${question.ansOne}" required>
                                <label>${question.ansOne}</label></div>
                            <div><input type="radio" name="${question.id}" value="${question.ansTwo}" required>
                                <label>${question.ansTwo}</label></div>
                            <div><input type="radio" name="${question.id}" value="${question.ansThree}" required>
                                <label>${question.ansThree}</label></div>
                        </div>
                    </div>
                </c:forEach>

            </div>
            <button class="btn btn-primary float-end" type="submit">Submit</button>
        </form>
    </div>
</div>

<%@include file="templates/footer.jsp" %>