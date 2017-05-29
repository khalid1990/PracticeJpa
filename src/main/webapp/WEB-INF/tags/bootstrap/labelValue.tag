<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="messageKey" required="true" %>
<%@attribute name="value"%>
<%@attribute name="labelSize" type="java.lang.Integer" %>
<%@attribute name="valueSize" type="java.lang.Integer" %>

<c:set var="labelSize" value="${not empty labelSize ? labelSize : 2}"/>
<c:set var="valueSize" value="${not empty valueSize ? valueSize : 4}"/>

<label class="col-sm-${labelSize} form-group">
    <fmt:message key="${messageKey}"/>
</label>

<div class="col-sm-${valueSize} form-group">
    <c:out value="${value}"/>
</div>
