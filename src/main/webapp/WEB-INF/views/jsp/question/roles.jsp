<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/common/taglibs/common-taglibs.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: babar
  Date: 9/9/17
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title><fmt:message key="label.add.update.role"/></title>
    <meta name="decorator" content="bootstrap-theme"/>
</head>

<body>
    <b:section titleKey="label.add.update.role">
        <jsp:attribute name="body">
            <b:subSection titleKey="label.roles.added">
                <jsp:attribute name="body">
                    <c:choose>
                        <c:when test="${not empty addedRoles}">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>
                                            <fmt:message key="label.role"/>
                                        </th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${addedRoles}" var="role">
                                        <tr>
                                            <td>${role}</td>
                                            <td>
                                                <c:url var="deleteRoleUrl" value="">
                                                    <c:param name="userId" value="${userId}"/>
                                                    <c:param name="role" value="${role}"/>
                                                    <c:param name="delete" value="true"/>
                                                </c:url>

                                                <b:button name="deleteBtn"
                                                          value="label.delete"
                                                          type="button"
                                                          onClick="window.location='${deleteRoleUrl}'"/>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:when>

                        <c:otherwise>
                            <fmt:message key="label.no.role.added"/>
                        </c:otherwise>
                    </c:choose>
                </jsp:attribute>
            </b:subSection>

            <b:subSection titleKey="label.roles.not.added">
                <jsp:attribute name="body">
                    <c:choose>
                        <c:when test="${not empty rolesNotAdded}">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th><fmt:message key="label.role"/></th>
                                        <th></th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach items="${rolesNotAdded}" var="role">
                                        <tr>
                                            <td>${role}</td>
                                            <td>
                                                <c:url var="addRoleUrl" value="">
                                                    <c:param name="userId" value="${userId}"/>
                                                    <c:param name="role" value="${role}"/>
                                                    <c:param name="add" value="true"/>
                                                </c:url>

                                                <b:button name="addBtn"
                                                          value="label.add"
                                                          type="button"
                                                          onClick="window.location='${addRoleUrl}'"/>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:when>

                        <c:otherwise>
                            <fmt:message key="label.role.nothing.to.add"/>
                        </c:otherwise>
                    </c:choose>
                </jsp:attribute>
            </b:subSection>
        </jsp:attribute>
    </b:section>
</body>
</html>
