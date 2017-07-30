<%--
  User: babar
  Date: 4/24/17
  Time: 12:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/common/taglibs/common-taglibs.jsp"%>

<html>
<head>
    <title><fmt:message key="label.institution"/></title>
    <meta name="decorator" content="bootstrap-theme"/>
</head>
<body>

    <c:set var="readOnly" value="${command.actionView.readOnly}"/>

    <b:formHeader titleKey="label.institution"
                  status="${command.institution.status.value}"/>

    <form:form action="index" method="post" commandName="command">

        <b:section titleKey="label.institution">
            <jsp:attribute name="body">
                <div class="row">
                    <b:textArea messageKey="label.institution.name"
                                bindPath="institution.institutionName"
                                readOnly="${readOnly}"
                                data="${command.institution.institutionName}"
                                required="true"/>
                </div>
            </jsp:attribute>
        </b:section>

        <b:buttonSection leftSectionSize="3">
            <jsp:attribute name="left">
                <b:button name="_action_back" value="label.back"/>
                <b:button name="_action_cancel" value="label.cancel"/>
            </jsp:attribute>

            <jsp:attribute name="right">
                <c:choose>
                    <c:when test="${readOnly}">
                        <c:if test="${command.actionView.canUpdate}">
                            <c:url var="editUrl" value="/qbank/institution/edit">
                                <c:param name="id" value="${command.institution.id}"/>
                            </c:url>

                            <b:button name="editUrl"
                                      value="label.edit"
                                      type="button"
                                      onClick="window.location='${editUrl}'"/>
                        </c:if>

                        <b:button name="_action_submit"
                                  value="label.submit"
                                  visible="${command.actionView.canSubmit}"/>

                        <b:button name="_action_approve"
                                  value="label.approve"
                                  visible="${command.actionView.canApprove}"/>

                        <b:button name="_action_return"
                                  value="label.return"
                                  visible="${command.actionView.canReturn}"/>

                        <b:button name="_action_delete"
                                  value="label.delete"
                                  visible="${command.actionView.canDelete}"/>
                    </c:when>

                    <c:otherwise>
                        <b:button name="_action_save"
                                  value="label.save"
                                  visible="${command.actionView.canSave}"/>

                        <b:button name="_action_update"
                                  value="label.update"
                                  visible="${command.actionView.canUpdate}"/>
                    </c:otherwise>
                </c:choose>
            </jsp:attribute>
        </b:buttonSection>
    </form:form>
</body>
</html>
