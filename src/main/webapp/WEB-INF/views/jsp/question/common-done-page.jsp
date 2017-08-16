<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/common/taglibs/common-taglibs.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: babar
  Date: 5/15/17
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <fmt:message key="label.common.done"/>
    </title>
    <meta name="decorator" content="bootstrap-theme">
</head>
<body>
    <div class="alert alert-success">
        <c:out value="${doneBean.message}"/>
    </div>

    <p style="text-align: center">
        <a href="<c:url value="${doneBean.showUrl}"/>">
            <fmt:message key="msg.back.to.show.page"/>
        </a>
    </p>
</body>
</html>
