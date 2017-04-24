<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@attribute name="name" required="true" type="java.lang.String"%>
<%@attribute name="value" required="true" type="java.lang.String"%>
<%@attribute name="type" type="java.lang.String"%>
<%@attribute name="size" type="java.lang.Integer"%>
<%@attribute name="offset" type="java.lang.Integer"%>
<%@attribute name="id" type="java.lang.String" %>
<%@attribute name="title" type="java.lang.String" %>
<%@attribute name="onClick" type="java.lang.String" %>
<%@attribute name="primaryClass" type="java.lang.String" %>
<%@attribute name="hidden" type="java.lang.Boolean"%>

<c:set var="btnType" value="${not empty type ? type : 'submit'}"/>
<c:set var="btnClass" value="${not empty primaryClass ? primaryClass : 'btn-default'}"/>
<c:set var="btnSize" value="${empty size ? 1 : size}"/>
<c:set var="btnOffset" value="${empty offset ? 0 : offset}"/>

<c:if test="${not hidden}">
    <input name="${name}"
           id="${id}"
           title="${title}"
           type="${btnType}"
           value="<fmt:message key="${value}"/>"
           class="btn ${btnClass}">
</c:if>

