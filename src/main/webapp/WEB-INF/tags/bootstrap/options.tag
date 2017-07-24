<%@ taglib tagdir="/WEB-INF/tags/bootstrap" prefix="b"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@attribute name="label" required="true"%>
<%@attribute name="optionList" type="java.util.ArrayList<java.lang.String>" required="true" %>
<%@attribute name="bindPath" required="true" %>
<%@attribute name="readOnly" type="java.lang.Boolean" required="true" %>
<%@attribute name="messageKey"%>

<%--
<c:forEach items="${optionList}" varStatus="status">
    <b:textField label="Option ${status.count}"
                 bindPath="${bindPath}[${status.index}]"
                 readOnly="${readOnly}"/>
</c:forEach>
--%>

