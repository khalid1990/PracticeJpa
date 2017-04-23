<%--
--@author: babar
--@since: 4/23/17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/common/taglibs/common-taglibs.jsp"%>

<html>
    <head>
        <title> Question Option </title>
        <meta name="decorator" content="bootstrap-theme">
    </head>
    <body>
        <c:set var="questionOption" value="${command.questionOption}"/>

        <b:formHeader titleKey="label.question.option"
                      status="NEW"
                      createdBy="${questionOption.createdBy.displayName}"
                      created="${questionOption.created}"
                      updatedBy="${questionOption.updatedBy.displayName}"
                      updated="${questionOption.updated}"
                      approvedBy="${questionOption.approvedBy.displayName}"
                      approved="${questionOption.approveDate}"
                      returnedBy="${questionOption.returnedBy.displayName}"
                      returned="${questionOption.returnDate}"
                      deletedBy="${questionOption.deletedBy.displayName}"
                      deleted="${questionOption.deleteDate}"/>

        <form:form action="index" method="post" commandName="command">
            <b:textArea messageKey="label.question.option.text"
                        bindPath="questionOption.text"/>

            <b:checkBox messageKey="question.option.serial.no"
                        bindPath="autoAssignNextSequenceValue"/>

            <b:textField messageKey="question.option.serial.no"
                        bindPath="questionOption.serialNumber"/>

            <b:checkBox messageKey="question.option.if.correct"
                        bindPath="questionOption.correct"/>

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
