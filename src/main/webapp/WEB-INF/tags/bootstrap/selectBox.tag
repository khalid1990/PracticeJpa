<%@ taglib prefix="b" tagdir="/WEB-INF/tags/bootstrap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@attribute name="messageKey" required="true" %>
<%@attribute name="bindPath" required="true" %>
<%@attribute name="data" type="java.lang.String" %>
<%@attribute name="labelSize" type="java.lang.Integer" %>
<%@attribute name="valueSize" type="java.lang.Integer" %>
<%@attribute name="optionsMap" type="java.util.Map<java.lang.Integer, java.lang.String>"%>
<%@attribute name="optionsList" type="java.util.List"%>
<%@attribute name="itemLabel" type="java.lang.String" %>
<%@attribute name="itemValue" type="java.lang.String" %>
<%@attribute name="readOnly" type="java.lang.Boolean" %>
<%@attribute name="hide" type="java.lang.Boolean" %>
<%@attribute name="id" type="java.lang.String" %>
<%@attribute name="required" type="java.lang.Boolean" %>

<c:set var="labelSize" value="${not empty labelSize ? labelSize : 2}"/>
<c:set var="valueSize" value="${not empty valueSize ? valueSize : 4}"/>

<c:if test="${not hide}">
    <c:choose>
        <c:when test="${readOnly}">
            <b:labelValue messageKey="${messageKey}"
                          value="${data}"/>

        </c:when>
        <c:otherwise>
            <label for="${bindPath}" class="col-sm-${labelSize} form-group">
                <fmt:message key="${messageKey}"/>
                <c:if test="${required}">
                    <span style="color: red">*</span>
                </c:if>
            </label>

            <div class="col-sm-${valueSize}  form-group">
                <form:select path="${bindPath}" cssClass="form-control" id="${id}">
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
                <form:errors path="${bindPath}"/>
            </div>
        </c:otherwise>
    </c:choose>
</c:if>
