<%@taglib prefix="b" tagdir="/WEB-INF/tags/bootstrap" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@attribute name="messageKey" type="java.lang.String" %>
<%@attribute name="bindPath" type="java.lang.String" %>
<%@attribute name="data" type="java.lang.String" %>
<%@attribute name="labelSize" type="java.lang.String" %>
<%@attribute name="valueSize" type="java.lang.String" %>
<%@attribute name="readOnly" type="java.lang.Boolean" %>
<%@attribute name="required" type="java.lang.Boolean" %>

<c:set var="labelSize" value="${not empty labelSize ? labelSize : 2}"/>
<c:set var="valueSize" value="${not empty valueSize ? valueSize : 4}"/>

<c:choose>
    <c:when test="${readOnly}">
        <b:labelValue messageKey="${messageKey}"
                      value="${data}"/>
    </c:when>
    <c:otherwise>
        <label for="${bindPath}" class="col-sm-${labelSize} form-group">
            <fmt:message key="${messageKey}"/>
            <c:if test="${required}">
                <span class="text-danger">*</span>
            </c:if>
        </label>

        <div class="col-sm-${valueSize} form-group">
            <form:password path="${bindPath}"
                           cssClass="form-control"/>

            <form:errors path="${bindPath}"/>
        </div>
    </c:otherwise>
</c:choose>


