<<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
--@author babar
--@since 8/7/17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/common/taglibs/common-taglibs.jsp"%>
<html>
<head>
    <title><fmt:message key="qp.question.paper.list"/></title>
    <meta name="decorator" content="bootstrap-theme">
</head>
<body>
<b:listView titleKey="qp.question.paper.list"
                         currentIndex="${currentIndex}"
                         disableNextButton="${disableNextButton}"
                         propertyColumnNameMap="${propertyColumnNameMap}"
                         records="${records}"
                         recordLoaderUrl="${recordLoaderUrl}"
                         sortProperty="${sortProperty}"
                         sortOrder="${sortOrder}"
                         currentUrl="${currentUrl}"
                         listUrl="${listUrl}"/>
</body>
</html>
