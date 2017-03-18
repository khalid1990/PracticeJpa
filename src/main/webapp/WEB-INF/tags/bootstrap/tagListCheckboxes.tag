<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@attribute name="title" required="true" %>
<%@attribute name="readOnly" required="true" type="java.lang.Boolean"%>
<%@attribute name="tagIdValueMap" type="java.util.Map<java.lang.Integer, java.lang.String>" required="true" %>
<%@attribute name="bindPath" required="true" %>

<div class="panel panel-default">
    <div class="panel-heading">
        ${title}
    </div>
    <div class="panel-body">
        <c:forEach items="${tagIdValueMap}" var="entry">
            <div class="tagCheckboxWrapper">
                <form:checkbox path="${bindPath}"
                               value="${entry.key}"
                               label="${entry.value}"/>
            </div>
        </c:forEach>
    </div>
</div>
