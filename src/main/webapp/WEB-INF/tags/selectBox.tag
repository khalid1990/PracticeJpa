<%@ taglib prefix="b" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@attribute name="labelValue" required="true" %>
<%@attribute name="labelSize"%>
<%@attribute name="options" type="java.util.Map<java.lang.Integer, java.lang.String>" required="true" %>
<%@attribute name="bindPath" required="true" %>
<%@attribute name="readOnly" type="java.lang.Boolean" required="true" %>

<div class="form-group">
    <c:choose>
        <c:when test="${readOnly}">
            <b:labelValue label="${labelValue}"
                          value="${bindPath}"/>
        </c:when>
        <c:otherwise>
            <label for="${bindPath}">
                    ${labelValue}
            </label>
            <form:select path="${bindPath}" cssClass="form-control">
                <c:forEach items="${options}" var="entry">
                    <c:set var="selected">
                        <c:choose>
                            <c:when test="${bindPath == entry.key}">
                                <c:out value="selected"/>
                            </c:when>
                            <c:otherwise>
                                <c:out value=""/>
                            </c:otherwise>
                        </c:choose>
                    </c:set>
                    <form:option value="${entry.key}">${entry.value}</form:option>
                </c:forEach>
            </form:select>
        </c:otherwise>
    </c:choose>
</div>
