<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
--@author babar
--@since 22/4/2017
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/common/taglibs/common-taglibs.jsp"%>

<html>
<head>
    <title> <fmt:message key="label.question"/> </title>
    <meta name="decorator" content="bootstrap-theme">
</head>
<body>
    <c:set var="question" value="${command.question}"/>
    <c:set var="av" value="${command.actionView}"/>
    <c:set var="readOnly" value="${av.readOnly}"/>

    <b:formHeader titleKey="label.question"
                  status="${question.status}"
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

        <b:section titleKey="label.question">
            <jsp:attribute name="body">
                <div class="row">
                    <b:textArea messageKey="question.title"
                                bindPath="question.title"
                                data="${question.title}"
                                readOnly="${readOnly}"
                                required="true"/>
                </div>

                <div class="row">
                    <b:selectBox messageKey="question.exam.sub.category"
                                 bindPath="question.examSubCategory"
                                 data="${question.examSubCategory}"
                                 itemLabel="name"
                                 readOnly="${readOnly}"/>
                </div>

                <div class="row">
                    <b:textArea messageKey="question.hint"
                                data="${question.hint}"
                                readOnly="${readOnly}"
                                bindPath="question.hint"/>
                </div>

                <div class="row">
                    <b:checkBox bindPath="autoAssignSequenceNo"
                                labelSize="8"
                                readOnly="${readOnly}"
                                messageKey="label.auto.assign.next.val"/>
                </div>

                <div class="row">
                    <b:textField messageKey="question.serial.no"
                                 data="${question.serialNumber}"
                                 readOnly="${readOnly}"
                                 bindPath="question.serialNumber"/>
                </div>

                <div class="row">
                    <b:textField messageKey="question.total.options"
                                 data="${question.totalOptions}"
                                 readOnly="${readOnly}"
                                 bindPath="question.totalOptions"/>
                </div>

                <c:if test="${not question.new}">
                    <hr/>

                    <h4><fmt:message key="label.options"/></h4>

                    <c:forEach items="${question.questionOptions}" var="option" varStatus="loop">
                        <div class="row">
                            <b:textArea messageKey="label.option"
                                        bindPath="question.questionOptions[${loop.index}].text"
                                        readOnly="${readOnly}"
                                        data="${option.text}"/>
                        </div>
                    </c:forEach>
                </c:if>
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
                        <c:if test="${av.canUpdate}">
                            <c:url var="editUrl" value="/qbank/question/edit">
                                <c:param name="id" value="${question.id}"/>
                            </c:url>

                            <b:button name="editUrl"
                                      value="label.edit"
                                      type="button"
                                      onClick="window.location='${editUrl}'"/>
                        </c:if>

                        <b:button name="_action_submit"
                                  value="label.submit"
                                  visible="${av.canSubmit}"/>

                        <b:button name="_action_approve"
                                  value="label.approve"
                                  visible="${av.canApprove}"/>

                        <b:button name="_action_return"
                                  value="label.return"
                                  visible="${av.canReturn}"/>

                        <b:button name="_action_delete"
                                  value="label.delete"
                                  visible="${av.canDelete}"/>
                    </c:when>

                    <c:otherwise>
                        <b:button name="_action_update"
                                  value="label.update"
                                  visible="${av.canUpdate}"/>

                        <b:button name="_action_save"
                                  value="label.save"
                                  visible="${av.canSave}"/>
                    </c:otherwise>
                </c:choose>
            </jsp:attribute>
        </b:buttonSection>
    </form:form>
</body>
</html>
