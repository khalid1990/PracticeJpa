<%--
  Created by IntelliJ IDEA.
  User: babar
  Date: 8/17/17
  Time: 1:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/common/taglibs/common-taglibs.jsp"%>

<html>
<head>
    <title><fmt:message key="label.institution"/></title>
    <meta name="decorator" content="bootstrap-theme">
</head>
<body>
    <b:listView titleKey="label.institution"
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
