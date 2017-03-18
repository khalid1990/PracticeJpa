<%@ taglib prefix="b" tagdir="/WEB-INF/tags/bootstrap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@attribute name="messageKey" required="true" %>
<%@attribute name="bindPath" required="true" %>
<%@attribute name="labelSize"%>
<%@attribute name="optionsMap" type="java.util.Map<java.lang.Integer, java.lang.String>"%>
<%@attribute name="optionsList" type="java.util.List"%>
<%@attribute name="itemLabel"%>
<%@attribute name="itemValue"%>
<%@attribute name="readOnly"%>
<%@attribute name="hide"%>

<c:if test="${not hide}">
    <div class="form-group">
        <c:choose>
            <c:when test="${readOnly}">
                <b:labelValue messageKey="${messageKey}"
                              value="${bindPath}"/>
            </c:when>
            <c:otherwise>
                <label for="${bindPath}">
                        <fmt:message key="${messageKey}"/>
                </label>
                <form:select path="${bindPath}" cssClass="form-control">
                    <c:choose>
                        <c:when test="${not empty optionsMap}">
                            <form:options items="${optionsMap}"/>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${not empty optionsList}">
                                    <c:choose>
                                        <c:when test="${not empty itemLabel and not empty itemValue}">
                                            <form:options items="${optionsList}"
                                                          itemLabel="${itemLabel}"
                                                          itemValue="${itemValue}"/>
                                        </c:when>
                                    </c:choose>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${not empty itemLabel}">
                                            <form:options itemLabel="${itemLabel}"/>
                                        </c:when>
                                        <c:otherwise>
                                            <form:options />
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </form:select>
            </c:otherwise>
        </c:choose>
    </div>
</c:if>
