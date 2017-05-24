<%--
  User: babar
  Date: 5/23/17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/common/taglibs/common-taglibs.jsp"%>
<html>
<head>
    <meta name="decorator" content="bootstrap-theme">
    <title>User</title>
</head>
<body>
    <b:formHeader titleKey="label.user" status=""/>

    <form:form action="index" commandName="command" method="post">
        <b:textField messageKey="label.first.name"
                     bindPath="user.firstName"
                     required="true"/>

        <b:textField messageKey="label.last.name"
                     bindPath="user.lastName"
                     required="true"/>
        
        <b:textField messageKey="label.email" 
                     bindPath="user.email"
                     required="true"/>
        
        <b:textField messageKey="label.password"
                     bindPath="user.password"
                     required="true"/>

        <b:textField messageKey="label.phone"
                     bindPath="user.phone"
                     required="true"/>

        <b:selectBox messageKey="label.designation"
                     bindPath="user.designation"
                     itemLabel="name"
                     required="true"/>

        <b:textArea messageKey="label.address"
                    bindPath="user.address"
                    required="true"/>
        
        <b:buttonSection leftSectionSize="4">
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