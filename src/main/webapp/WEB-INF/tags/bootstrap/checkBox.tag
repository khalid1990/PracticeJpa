<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@attribute name="id" type="java.lang.String" %>
<%@attribute name="messageKey" type="java.lang.String" required="true" %>
<%@attribute name="bindPath" type="java.lang.String" required="true"%>
<%@attribute name="labelSize" type="java.lang.Integer" %>
<%@attribute name="readOnly" type="java.lang.Boolean" %>
<%@attribute name="disabled" type="java.lang.Boolean" %>
<%@attribute name="required" type="java.lang.Boolean" %>

<c:set var="disableCheckbox" value="${disabled or readOnly}"/>
<c:set var="labelValue">
    <fmt:message key="${messageKey}"/>
    <c:if test="${required}">
        <span style="color: red">*</span>
    </c:if>
</c:set>
<div class="form-group">
    <form:checkbox path="${bindPath}"
                   label="${labelValue}"
                   disabled="${disabled}"
                   cssClass="form-control"
                   id="${id}"/>

    <form:errors path="${bindPath}"/>
</div>
