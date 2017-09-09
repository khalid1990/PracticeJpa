<%--
  Created by IntelliJ IDEA.
  User: babar
  Date: 3/16/17
  Time: 1:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@include file="/WEB-INF/common/taglibs/common-taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>
        <decorator:title/>
    </title>
    <script type="text/javascript" src="<c:url value="/resources/bootstrap-3.3.7-dist/css/bootstrap.css"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/common.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.0.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/jquery-ui-1.12.1/jquery-ui.min.js"/>"></script>

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap-3.3.7-dist/css/bootstrap.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/common.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/jquery-ui-1.12.1/jquery-ui.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/font-awesome-4.7.0/css/font-awesome.min.css"/>">

    <decorator:head/>
</head>
<body>
    <div class="header">
        <div class="header-title"> <fmt:message key="title.project"/> </div>

        <div class="header-right">
            <%--To make the logout mechanism work correctly it was required that the request method was *post*
                and the request was submitted to "/logout" at context root; as I haven't specified any "logout-url"
                in my spring-security.xml.
            --%>
            <c:url var="logoutUrl" value="/logout"/>
            <form action="${logoutUrl}" method="post">
                <b:button name="logout" value="label.logout"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
    </div>

    <div class="container">
        <decorator:body />
    </div>

    <div class="footer">
        <p> Copyright : babar </p>
    </div>
</body>
</html>
