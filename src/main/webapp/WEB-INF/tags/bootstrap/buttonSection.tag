<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@attribute name="left" fragment="true" %>
<%@attribute name="right" fragment="true" %>
<%@attribute name="leftSectionSize" type="java.lang.Integer" required="true"%>

<c:set var="rightSectionSize" value="${12 - leftSectionSize}"/>
<div class="alert alert-info">
    <div class="row">
        <div class="col-sm-${leftSectionSize}" style="text-align: left">
            <jsp:invoke fragment="left"/>
        </div>

        <div class="col-sm-${rightSectionSize}" style="text-align: right">
            <jsp:invoke fragment="right"/>
        </div>
    </div>
</div>
