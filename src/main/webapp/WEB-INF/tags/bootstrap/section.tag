<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="titleKey" type="java.lang.String" %>
<%@attribute name="body" fragment="true"%>
<%@attribute name="showHeader" type="java.lang.Boolean"%>

<c:set var="showHeader" value="${not empty showHeader ? showHeader : true}"/>

<div class="panel panel-default">
    <c:if test="${showHeader}">
        <div class="panel-heading">
            <div class="panel-title">
                <fmt:message key="${titleKey}"/>
            </div>
        </div>
    </c:if>

    <div class="panel-body">
        <jsp:invoke fragment="body"/>
    </div>
</div>