<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@attribute name="messageKey" required="true"%>
<%@attribute name="bindPath" required="true"%>
<%@attribute name="labelSize" type="java.lang.Integer" %>
<%@attribute name="size"  type="java.lang.Integer"%>
<%@attribute name="readOnly" type="java.lang.Boolean" %>

<div class="form-group">
    <label for="${bindPath}">
        <fmt:message key="${messageKey}"/>
    </label>
    <c:choose>
        <c:when  test="${readOnly}">
            <form:label path="${bindPath}"/>
        </c:when>
        <c:otherwise>
            <form:textarea cssClass="form-control" path="${bindPath}"/>
        </c:otherwise>
    </c:choose>
</div>

