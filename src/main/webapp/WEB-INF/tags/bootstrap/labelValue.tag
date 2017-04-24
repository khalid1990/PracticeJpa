<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@attribute name="messageKey" required="true" %>
<%@attribute name="value"%>

<div class="row">
    <label class="col-sm-4"> <fmt:message key="${messageKey}"/> </label>
    <div class="col-sm-4"> ${value} </div>
</div>