<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@attribute name="messageKey" required="true"%>
<%@attribute name="bindPath" required="true"%>
<%@attribute name="labelSize" type="java.lang.Integer" %>
<%@attribute name="size"  type="java.lang.Integer"%>
<%@attribute name="readOnly" type="java.lang.Boolean" %>
<%@attribute name="id" type="java.lang.String" %>
<%@attribute name="disabled" type="java.lang.Boolean" %>
<%@attribute name="required" type="java.lang.Boolean" %>


<div class="form-group">
    <label for="${bindPath}">
        <fmt:message key="${messageKey}"/>
        <c:if test="${required}">
            <span style="color: red">*</span>
        </c:if>
    </label>
    <c:choose>
        <c:when  test="${readOnly}">
            <form:label path="${bindPath}"/>
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

