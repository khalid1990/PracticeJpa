<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="label" required="true"%>
<%@attribute name="bindPath" required="true"%>
<%@attribute name="labelSize" type="java.lang.Integer" %>
<%@attribute name="size"  type="java.lang.Integer"%>
<%@attribute name="readOnly" type="java.lang.Boolean" %>

<div class="form-group">
    <label for="${bindPath}">
        ${label}
    </label>
    <c:choose>
        <c:when  test="${readOnly}">
            <form:label path="${bindPath}"></form:label>
        </c:when>
        <c:otherwise>
            <form:input type="text" cssClass="form-control" path="${bindPath}"></form:input>
        </c:otherwise>
    </c:choose>
</div>

