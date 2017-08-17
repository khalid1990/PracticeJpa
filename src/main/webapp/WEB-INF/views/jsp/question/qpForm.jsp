<%--
--@author: babar
--@since: 3/17/17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/common/taglibs/common-taglibs.jsp"%>
<html>
<head>
    <title> Question Paper </title>
    <meta name="decorator" content="bootstrap-theme" >

    <script type="text/javascript">
        $(document).ready(function(){
            $(".date-time").datepicker();
        });
    </script>
</head>
<body>
    <c:set var="qp" value="${command.questionPaper}"/>
    <c:set var="av" value="${command.actionView}"/>
    <c:set var="readOnly" value="${av.readOnly}"/>

    <c:if test="${!empty FLASH_MESSAGE}">
        <div class="alert alert-success alert-dismissable">
            <c:out value="${FLASH_MESSAGE}"/>
        </div>
    </c:if>

    <b:formHeader titleKey="label.question.paper"
                  status="${qp.status}"
                  createdBy="${qp.createdBy.displayName}"
                  created="${qp.created}"
                  updatedBy="${qp.updatedBy.displayName}"
                  updated="${qp.updated}"
                  approvedBy="${qp.approvedBy.displayName}"
                  approved="${qp.approveDate}"
                  returnedBy="${qp.returnedBy.displayName}"
                  returned="${qp.returnDate}"
                  deletedBy="${qp.deletedBy.displayName}"
                  deleted="${qp.deleteDate}"/>

    <form:form action="index" method="post" commandName="command">

        <b:section showHeader="false">
            <jsp:attribute name="body">
                <div class="row">
                    <b:textField messageKey="qp.exam.title"
                                 bindPath="questionPaper.examTitle"
                                 data="${qp.examTitle}"
                                 readOnly="${readOnly}"
                                 required="true"/>
                </div>

                <div class="row">
                    <b:textField messageKey="qp.exam.serial"
                                 bindPath="questionPaper.examSerial"
                                 data="${qp.examSerial}"
                                 readOnly="${readOnly}"
                                 required="true"/>
                </div>

                <div class="row">
                    <b:inputDateTime messageKey="qp.exam.date"
                                     data="${qp.examDate}"
                                     readOnly="${readOnly}"
                                     bindPath="questionPaper.examDate"/>
                </div>

                <div class="row">
                    <b:selectBox messageKey="qp.institution"
                                 bindPath="questionPaper.institution"
                                 data="${qp.institution.institutionName}"
                                 optionsList="${institutions}"
                                 readOnly="${readOnly}"
                                 itemLabel="institutionName"
                                 itemValue="id"/>
                </div>

                <div class="row">
                    <b:selectBox messageKey="qp.language"
                                 bindPath="questionPaper.lang"
                                 data="${qp.lang}"
                                 readOnly="${readOnly}"
                                 itemLabel="name"
                                 required="true"/>
                </div>

                <div class="row">
                    <b:selectBox messageKey="qp.exam.type"
                                 bindPath="questionPaper.examType"
                                 data="${qp.examType}"
                                 readOnly="${readOnly}"
                                 itemLabel="name"
                                 required="true"/>
                </div>

                <div class="row">
                    <b:selectBox messageKey="qp.exam.category"
                                 bindPath="questionPaper.examCategory"
                                 data="${qp.examCategory}"
                                 readOnly="${readOnly}"
                                 itemLabel="name"
                                 required="true"/>
                </div>

                <div class="row">
                    <b:textField messageKey="qp.total.time"
                                 readOnly="${readOnly}"
                                 data="${qp.totalTimeInSeconds}"
                                 bindPath="questionPaper.totalTimeInSeconds"/>
                </div>

                <div class="row">
                    <b:textField messageKey="qp.total.questions"
                                 data="${qp.totalQuestions}"
                                 readOnly="${readOnly}"
                                 bindPath="questionPaper.totalQuestions"/>
                </div>

                <div class="row">
                    <b:textField messageKey="qp.marks.per.question"
                                 readOnly="${readOnly}"
                                 data="${qp.marksPerQuestion}"
                                 bindPath="questionPaper.marksPerQuestion"/>
                </div>

                <div class="row">
                    <b:textField messageKey="qp.negative.marking.percentage"
                                 readOnly="${readOnly}"
                                 data="${qp.negativeMarkingPercentage}"
                                 bindPath="questionPaper.negativeMarkingPercentage"/>
                </div>

                <div class="row">
                    <b:textArea messageKey="qp.instruction"
                                readOnly="${readOnly}"
                                data="${qp.instruction}"
                                bindPath="questionPaper.instruction"/>
                </div>
            </jsp:attribute>
        </b:section>

        <b:buttonSection leftSectionSize="3">
            <jsp:attribute name="left">
                <b:button name="${!readOnly and not qp.new ? '_action_back_show' : '_action_back'}" value="label.back"/>
                <b:button name="_action_cancel" value="label.cancel"/>
            </jsp:attribute>

            <jsp:attribute name="right">
                <c:choose>
                    <c:when test="${readOnly}">
                        <c:if test="${av.canUpdate}">
                            <c:url var="editUrl" value="/qbank/questionPaper/edit">
                                <c:param name="id" value="${qp.id}"/>
                                <c:param name="backLink" value="${command.backLink}"/>
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
