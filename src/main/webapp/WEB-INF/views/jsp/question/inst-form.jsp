<%--
  Created by IntelliJ IDEA.
  User: sherlock
  Date: 4/24/17
  Time: 12:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/common/taglibs/common-taglibs.jsp"%>

<html>
<head>
    <title>Institution</title>
    <meta name="decorator" content="bootstrap-theme"/>
</head>
<body>
    <b:formHeader titleKey="label.institution" status="NEW"/>

    <form:form action="index" method="post" commandName="command">
        <b:textArea messageKey="label.institution.name" bindPath="institution.institutionName"/>

        <b:buttonSection leftSectionSize="3">
            <jsp:attribute name="left">
                <b:button name="_action_back" value="label.back"/>
                <b:button name="_action_cancel" value="label.cancel"/>
            </jsp:attribute>

            <jsp:attribute name="right">
                <b:button name="_action_save" value="label.save"/>
            </jsp:attribute>
        </b:buttonSection>
    </form:form>
</body>
</html>
