<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@attribute name="messageKey" type="java.lang.String" required="true"%>
<%@attribute name="bindPath" type="java.lang.String" required="true"%>
<%@attribute name="data" type="java.lang.String" %>
<%@attribute name="labelSize" type="java.lang.Integer" %>
<%@attribute name="valueSize" type="java.lang.Integer" %>
<%@attribute name="size"  type="java.lang.Integer"%>
<%@attribute name="readOnly" type="java.lang.Boolean" %>
<%@attribute name="id" type="java.lang.String" %>
<%@attribute name="disabled" type="java.lang.Boolean" %>
<%@attribute name="required" type="java.lang.Boolean" %>

<c:set var="labelSize" value="${not empty labelSize ? labelSize : 2}"/>
<c:set var="valueSize" value="${not empty valueSize ? valueSize : 4}"/>


<label for="${bindPath}" class="col-sm-${labelSize} control-label form-group">
    <fmt:message key="${messageKey}"/>
    <c:if test="${required and not readOnly}">
        <span style="color: red">*</span>
    </c:if>
</label>
<div class="col-sm-${valueSize} form-group">
    <c:choose>
        <c:when  test="${readOnly}">
            <c:out value="${data}"/>
        </c:when>

        <c:otherwise>
            <form:input cssClass="form-control"
                        path="${bindPath}"
                        id="${id}"
                        disabled="${disabled}"/>
            <form:errors path="${bindPath}"/>
        </c:otherwise>
    </c:choose>
</div>


