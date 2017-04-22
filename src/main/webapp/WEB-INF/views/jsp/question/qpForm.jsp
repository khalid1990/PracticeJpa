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

    <b:formHeader titleKey="label.question.paper"
                  status="New"
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

        <b:textField messageKey="qp.exam.title"
                     bindPath="questionPaper.examTitle"/>

        <b:textField messageKey="qp.exam.serial"
                     bindPath="questionPaper.examSerial"/>

        <b:inputDateTime messageKey="qp.exam.date"
                         bindPath="questionPaper.examDate"/>

        <b:selectBox messageKey="qp.institution"
                     bindPath="questionPaper.institution"
                     optionsList="${institutions}"
                     itemLabel="institutionName"
                     itemValue="id"/>
        
        <b:selectBox messageKey="qp.language"
                     bindPath="questionPaper.lang"
                     itemLabel="name"/>
        
        <b:selectBox messageKey="qp.exam.type"
                     bindPath="questionPaper.examType"
                     itemLabel="name"/>

        <b:selectBox messageKey="qp.exam.category"
                     bindPath="questionPaper.examCategory"
                     itemLabel="name"/>

        <b:textField messageKey="qp.total.time"
                     bindPath="questionPaper.totalTimeInSeconds"/>
        
        <b:textField messageKey="qp.total.questions"
                     bindPath="questionPaper.totalQuestions"/>

        <b:textField messageKey="qp.marks.per.question"
                     bindPath="questionPaper.marksPerQuestion"/>

        <b:textField messageKey="qp.negative.marking.percentage"
                     bindPath="questionPaper.negativeMarkingPercentage"/>

        <b:textArea messageKey="qp.instruction"
                     bindPath="questionPaper.instruction"/>

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
