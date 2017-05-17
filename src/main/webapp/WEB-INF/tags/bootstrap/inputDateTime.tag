<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@attribute name="bindPath" required="true" type="java.lang.String" %>
<%@attribute name="messageKey" required="true" type="java.lang.String" %>
<%@attribute name="readOnly" type="java.lang.Boolean" %>
<%@attribute name="id" type="java.lang.String" %>
<%@attribute name="hide" type="java.lang.Boolean" %>
<%@attribute name="required" type="java.lang.Boolean" %>

<c:if test="${not hide}">
    <div class="form-group">
        <label for="${bindPath}">
            <fmt:message key="${messageKey}"/>
            <c:if test="${required}">
                <span style="color: red">*</span>
            </c:if>
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
