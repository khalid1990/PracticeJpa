<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
--@author babar
--@since 8/1/17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/common/taglibs/common-taglibs.jsp"%>
<html>
<head>
    <title><fmt:message key="label.user.list"/></title>
    <meta name="decorator" content="bootstrap-theme">
</head>
<body>
    <b:listView titleKey="label.user.list"
                          currentIndex="${currentIndex}"
                          disableNextButton="${disableNextButton}"
                          propertyColumnNameMap="${propertyColumnNameMap}"
                          records="${records}"
                          recordLoaderUrl="${recordLoaderUrl}"
                          sortProperty="${sortProperty}"
                          sortOrder="${sortOrder}"
                          listUrl="${listUrl}"/>

</body>
</html>
