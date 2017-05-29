<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@attribute name="titleKey" type="java.lang.String" %>
<%@attribute name="body" fragment="true"%>

<div class="panel panel-default">
    <div class="panel-heading">
        <div class="panel-title">
            <fmt:message key="${titleKey}"/>
        </div>
    </div>

    <div class="panel-body">
        <jsp:invoke fragment="body"/>
    </div>
</div>