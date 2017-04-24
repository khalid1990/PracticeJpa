<%@ taglib prefix="b" tagdir="/WEB-INF/tags/bootstrap"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="userName" required="true" %>
<%@attribute name="date" required="true" type="java.util.Date" %>
<%@attribute name="messageKey" required="true" %>

<c:if test="${not empty userName}">
    <c:choose>
        <c:when test="${not empty date}">
            <c:set var="formattedDate">
                <fmt:formatDate value="${date}" pattern="dd/MM/yyyy"/>
            </c:set>
            <b:labelValue messageKey="${messageKey}"
                          value="${userName} on ${formattedDate}"/>
        </c:when>
        <c:otherwise>
            <b:labelValue messageKey="${messageKey}"
                          value="${userName}"/>
        </c:otherwise>
    </c:choose>
</c:if>