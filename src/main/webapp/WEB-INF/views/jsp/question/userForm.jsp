<%--
  User: babar
  Date: 5/23/17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/common/taglibs/common-taglibs.jsp"%>
<html>
<head>
    <meta name="decorator" content="bootstrap-theme">
    <title><fmt:message key="label.user"/></title>
</head>
<body>

    <c:if test="${!empty FLASH_MESSAGE}">
        <div class="alert alert-success alert-dismissable">
            <c:out value="${FLASH_MESSAGE}"/>
        </div>
    </c:if>

    <b:formHeader titleKey="label.user" status=""/>

    <c:set var="user" value="${command.user}"/>

    <c:set var="readOnly" value="${command.av.readOnly}"/>

    <form:form action="index" commandName="command" method="post">

        <b:section titleKey="label.user.info">
            <jsp:attribute name="body">
                <div class="row">
                    <b:textField messageKey="label.first.name"
                                 bindPath="user.firstName"
                                 readOnly="${readOnly}"
                                 data="${user.firstName}"
                                 required="true"/>
                </div>

                <div class="row">
                    <b:textField messageKey="label.last.name"
                                 bindPath="user.lastName"
                                 readOnly="${readOnly}"
                                 data="${user.lastName}"
                                 required="true"/>
                </div>

                <div class="row">
                    <b:textField messageKey="label.email"
                                 bindPath="user.email"
                                 readOnly="${readOnly}"
                                 data="${user.email}"
                                 required="true"/>
                </div>

                <div class="row">
                    <b:passwordField messageKey="label.password"
                                     bindPath="user.password"
                                     data="*****"
                                     readOnly="${readOnly}"
                                     visible="${user.new or readOnly}"
                                     required="true"/>
                </div>

                <div class="row">
                    <b:passwordField messageKey="label.confirm.password"
                                     bindPath="confirmPassword"
                                     data="${command.confirmPassword}"
                                     visible="${user.new}"
                                     required="true"/>
                </div>

                <div class="row">
                    <b:textField messageKey="label.phone"
                                 bindPath="user.phone"
                                 readOnly="${readOnly}"
                                 data="${user.phone}"
                                 required="true"/>
                </div>

                <div class="row">
                    <b:selectBox messageKey="label.designation"
                                 bindPath="user.designation"
                                 readOnly="${readOnly}"
                                 itemLabel="name"
                                 data="${command.user.designation.name}"
                                 required="true"/>
                </div>

                <div class="row">
                    <b:textArea messageKey="label.address"
                                bindPath="user.address"
                                readOnly="${readOnly}"
                                data="${user.address}"
                                required="true"/>
                </div>
            </jsp:attribute>
        </b:section>

        <c:if test="${not user.new and not readOnly}">
            <b:section titleKey="label.change.password">
                <jsp:attribute name="body">
                    <div class="row">
                        <b:passwordField bindPath="oldPassword"
                                         messageKey="label.enter.old.password"/>
                    </div>

                    <div class="row">
                        <b:passwordField bindPath="user.password"
                                         messageKey="label.enter.new.password"/>
                    </div>

                    <div class="row">
                        <b:passwordField bindPath="confirmPassword"
                                         messageKey="label.confirm.password"/>
                    </div>
                    
                    <div class="row">
                        <b:button name="_action_update_password"
                                  value="label.update.password"/>
                    </div>
                </jsp:attribute>
            </b:section>
        </c:if>

        <b:buttonSection leftSectionSize="4">
            <jsp:attribute name="left">
                <b:button name="${not readOnly and not user.new ? '_action_back_show' : '_action_back'}" value="label.back"/>

                <b:button name="_action_cancel" value="label.cancel"/>
            </jsp:attribute>
            
            <jsp:attribute name="right">
                <c:choose>
                    <c:when test="${readOnly}">
                        <c:if test="${command.av.canUpdate}">
                            <c:url var="editUrl" value="/qbank/user/edit">
                                <c:param name="id" value="${user.id}"/>
                                <c:param name="backLink" value="${command.backLink}"/>
                            </c:url>

                            <b:button name="editUrl"
                                      value="label.edit"
                                      type="button"
                                      onClick="window.location='${editUrl}'"/>
                        </c:if>

                        <b:button name="_action_delete"
                                  value="label.delete"
                                  visible="${command.av.canDelete}"/>
                    </c:when>

                    <c:otherwise>
                        <b:button name="_action_save"
                                  value="label.save"
                                  visible="${command.av.canSave}"/>

                        <b:button name="_action_update"
                                  value="label.update"
                                  visible="${command.av.canUpdate}"/>
                    </c:otherwise>
                </c:choose>
            </jsp:attribute>
        </b:buttonSection>
    </form:form>
</body>
</html>
