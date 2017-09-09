<%@include file="/WEB-INF/common/taglibs/common-taglibs.jsp"%>
<%--
  author: babar
  since: 9/6/17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <fmt:message key="label.login"/>
    </title>
    <meta name="decorator" content="bootstrap-theme">
</head>
<body>

    <%--
        this made it work : login-processing-url="/qbank/common/login"
    --%>
    <form:form action="" method="post">
        <b:section titleKey="label.login">
            <jsp:attribute name="body">
                <div class="row form-group form-inline">
                    <label class="col-sm-2"><fmt:message key="label.email"/></label>
                    <input type="text" name="email" class="form-control col-sm-4">
                </div>

                <div class="row form-group form-inline">
                    <label class="col-sm-2"><fmt:message key="label.password"/></label>
                    <input type="password" name="password" class="form-control col-sm-4">
                </div>

                <div class="row form-group">
                    <div class="col-sm-2">
                        <b:button name="submit" value="label.login"/>
                    </div>
                </div>
            </jsp:attribute>
        </b:section>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /><%--this is required as, *csrf* is enabled by default--%>
    </form:form>

</body>
</html>
