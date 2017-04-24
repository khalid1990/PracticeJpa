<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@attribute name="bindPath" required="true" %>
<%@attribute name="messageKey" required="true" %>
<%@attribute name="readOnly"%>
<%@attribute name="id"%>
<%@attribute name="hide"%>

<c:if test="${not hide}">
    <div class="form-group">
        <label for="${bindPath}">
            <fmt:message key="${messageKey}"/>
        </label>

        <c:choose>
            <c:when test="${readOnly}">
                <form:label path="${bindPath}"/>
            </c:when>
            <c:otherwise>
                <form:input id="${id}" path="${bindPath}" cssClass="form-control date-time"/>
                <form:errors path="${bindPath}"/>
            </c:otherwise>
        </c:choose>
    </div>
</c:if>
