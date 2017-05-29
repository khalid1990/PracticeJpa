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

    <c:set var="user" value="${command.user}"/>

    <form:form action="index" commandName="command" method="post">

        <b:section titleKey="label.user.info">
            <jsp:attribute name="body">
                <div class="row">
                    <b:textField messageKey="label.first.name"
                                 bindPath="user.firstName"
                                 readOnly="${command.av.readOnly}"
                                 data="${user.firstName}"
                                 required="true"/>
                </div>

                <div class="row">
                    <b:textField messageKey="label.last.name"
                                 bindPath="user.lastName"
                                 readOnly="${command.av.readOnly}"
                                 data="${user.lastName}"
                                 required="true"/>
                </div>

                <div class="row">
                    <b:textField messageKey="label.email"
                                 bindPath="user.email"
                                 readOnly="${command.av.readOnly}"
                                 data="${user.email}"
                                 required="true"/>
                </div>

                <div class="row">
                    <b:passwordField messageKey="label.password"
                                     bindPath="user.password"
                                     data="${user.password}"
                                     readOnly="${command.av.readOnly}"
                                     required="true"/>
                </div>

                <c:if test="${not command.av.readOnly}">
                    <div class="row">
                        <b:passwordField messageKey="label.confirm.password"
                                         bindPath="user.confirmPassword"
                                         data="${user.confirmPassword}"
                                         required="true"/>
                    </div>
                </c:if>

                <div class="row">
                    <b:textField messageKey="label.phone"
                                 bindPath="user.phone"
                                 readOnly="${command.av.readOnly}"
                                 data="${user.phone}"
                                 required="true"/>
                </div>

                <div class="row">
                    <b:selectBox messageKey="label.designation"
                                 bindPath="user.designation"
                                 readOnly="${command.av.readOnly}"
                                 itemLabel="name"
                                 data="${command.user.designation.name}"
                                 required="true"/>
                </div>

                <div class="row">
                    <b:textArea messageKey="label.address"
                                bindPath="user.address"
                                readOnly="${command.av.readOnly}"
                                data="${user.address}"
                                required="true"/>
                </div>
            </jsp:attribute>
        </b:section>

        <b:buttonSection leftSectionSize="4">
            <jsp:attribute name="left">
                <b:button name="_action_back" value="label.back"/>

                <b:button name="_action_cancel" value="label.cancel"/>
            </jsp:attribute>
            
            <jsp:attribute name="right">
                <b:button name="_action_save"
                          value="label.save"
                          hidden="${not command.av.canSave}"/>

                <b:button name="_action_update"
                          value="label.update"
                          hidden="${not command.av.canUpdate}"/>

                <b:button name="_action_delete"
                          value="label.delete"
                          hidden="${not command.av.canDelete}"/>
            </jsp:attribute>
        </b:buttonSection>
    </form:form>
</body>
</html>