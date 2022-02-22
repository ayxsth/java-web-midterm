<%@include file="templates/header.jsp" %>

<%
    if(session.getAttribute("username") == null){
        response.sendRedirect("./");
    }
%>

<div class="container w-50 my-5 jumbotron d-flex">
    <div class="mb-auto mt-auto w-100 p-5 shadow-sm rounded bg-white">
        <div class="text-end w-100 mb-3">
            <h5>Hello, ${username}!</h5>
            <h6>Points: ${points}</h6>
        </div>

        <div>
            <h4>Attempt all the question to crack the interview ;)</h4>
        </div>

        <form action="home" method="post">
            <div class="questions" <c:if test="${chosenAnswers != null}">style="pointer-events:none;"</c:if>>
                <c:forEach var="question" items="${questions}" varStatus="loop">
                    <div class="my-5 container p-3 shadow-sm rounded" id="${question.id}">
                        <p><b>${loop.count}. ${question.question} <span class="text-danger">*</span></b></p>
                        <div class="answers m-3 mb-0 d-flex flex-row align-items-center justify-content-between w-75 mx-auto">
                            <div><input type="radio" name="${question.id}" value="${question.ansOne}"
                            <c:if test="${chosenAnswers[loop.index] == question.ansOne}">
                                        checked
                            </c:if>
                                        required>
                                <label
                                        <c:if test="${chosenAnswers[loop.index] != null}">
                                            <c:if test="${question.ansOne == question.correctAns}">
                                                class="text-success"
                                            </c:if>
                                        </c:if>
                                        <c:if test="${chosenAnswers[loop.index] == question.ansOne}">
                                            <c:if test="${question.correctAns != question.ansOne}">
                                                class="text-danger"
                                            </c:if>
                                        </c:if>
                                >${question.ansOne}</label></div>
                            <div><input type="radio" name="${question.id}" value="${question.ansTwo}"
                            <c:if test="${chosenAnswers[loop.index] == question.ansTwo}">
                                        checked
                            </c:if>
                                        required>
                                <label
                                        <c:if test="${chosenAnswers[loop.index] != null}">
                                            <c:if test="${question.ansTwo == question.correctAns}">
                                                class="text-success"
                                            </c:if>
                                        </c:if>
                                        <c:if test="${chosenAnswers[loop.index] == question.ansTwo}">
                                            <c:if test="${question.correctAns != question.ansTwo}">
                                                class="text-danger"
                                            </c:if>
                                        </c:if>
                                >${question.ansTwo}</label></div>
                            <div><input type="radio" name="${question.id}" value="${question.ansThree}"
                            <c:if test="${chosenAnswers[loop.index] == question.ansThree}">
                                        checked
                            </c:if>
                                        required>
                                <label
                                        <c:if test="${chosenAnswers[loop.index] != null}">
                                            <c:if test="${question.ansThree == question.correctAns}">
                                                class="text-success"
                                            </c:if>
                                        </c:if>
                                        <c:if test="${chosenAnswers[loop.index] == question.ansThree}">
                                            <c:if test="${question.correctAns != question.ansThree}">
                                                class="text-danger"
                                            </c:if>
                                        </c:if>
                                >${question.ansThree}</label></div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <button class="btn btn-sm btn-primary float-end" type="submit">${buttonName}</button>
        </form>
    </div>
</div>

<%@include file="templates/footer.jsp" %>