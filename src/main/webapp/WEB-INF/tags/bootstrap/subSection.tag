<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="titleKey" type="java.lang.String" %>
<%@attribute name="body" fragment="true"%>

<h3>
    <fmt:message key="${titleKey}"/>
</h3>

<br/>

<div class="subSectionText">
    <jsp:invoke fragment="body"/>
</div>
