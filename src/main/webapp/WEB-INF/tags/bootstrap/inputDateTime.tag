<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@attribute name="bindPath" required="true" type="java.lang.String" %>
<%@attribute name="messageKey" required="true" type="java.lang.String" %>
<%@attribute name="readOnly" type="java.lang.Boolean" %>
<%@attribute name="id" type="java.lang.String" %>
<%@attribute name="hide" type="java.lang.Boolean" %>
<%@attribute name="required" type="java.lang.Boolean" %>
<%@attribute name="labelSize" type="java.lang.Integer" %>
<%@attribute name="valueSize" type="java.lang.Integer" %>
<%@attribute name="data" type="java.lang.String"%>

<c:set var="labelSize" value="${not empty labelSize ? labelSize : 2}"/>
<c:set var="valueSize" value="${not empty valueSize ? valueSize : 4}"/>

<c:if test="${not hide}">
    <label for="${bindPath}" class="col-sm-${labelSize} form-group">
        <fmt:message key="${messageKey}"/>
        <c:if test="${required}">
            <span style="color: red">*</span>
        </c:if>
    </label>

    <div class="col-sm-${valueSize} form-group">
        <c:choose>
            <c:when test="${readOnly}">
                <c:out value="${data}"/>
            </c:when>
            <c:otherwise>
                <form:input id="${id}" path="${bindPath}" cssClass="form-control date-time"/>
                <form:errors path="${bindPath}"/>
            </c:otherwise>
        </c:choose>
    </div>
</c:if>
