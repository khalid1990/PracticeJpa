<%--
--@author babar
--@since 22/4/2017
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/common/taglibs/common-taglibs.jsp"%>

<html>
<head>
    <title> Question </title>
    <meta name="decorator" content="bootstrap-theme">
</head>
<body>
    <c:set var="question" value="${command.question}"/>
    
    <b:formHeader titleKey="label.question"
                  status="NEW"
                  createdBy="${question.createdBy.displayName}"
                  created="${question.created}"
                  updatedBy="${question.updatedBy.displayName}"
                  updated="${question.updated}"
                  approvedBy="${question.approvedBy.displayName}"
                  approved="${question.approveDate}"
                  returnedBy="${question.returnedBy.displayName}"
                  returned="${question.returnDate}"
                  deletedBy="${question.deletedBy.displayName}"
                  deleted="${question.deleteDate}"/>

    <form:form action="index" method="post" commandName="command">
        <b:textArea messageKey="question.title"
                    bindPath="question.title"
                    required="true"/>

        <b:selectBox messageKey="question.exam.sub.category"
                     bindPath="question.examSubCategory"
                     optionsList="${subCategories}"
                     itemLabel="name"
                     itemValue="id"/>
        
        <b:textArea messageKey="question.hint"
                    bindPath="question.hint"/>
        
        <b:checkBox bindPath="autoAssignSequenceNo"
                    messageKey="label.auto.assign.next.val"/>
        
        <b:textField messageKey="question.serial.no"
                     bindPath="question.serialNumber"/>

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
