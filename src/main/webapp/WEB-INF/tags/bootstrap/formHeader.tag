<%@ taglib prefix="b" tagdir="/WEB-INF/tags/bootstrap"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="titleKey" required="true" %>
<%@attribute name="status" required="true" %>
<%@attribute name="createdBy"%>
<%@attribute name="created" type="java.util.Date" %>
<%@attribute name="updatedBy"%>
<%@attribute name="updated" type="java.util.Date"%>
<%@attribute name="approvedBy"%>
<%@attribute name="approved" type="java.util.Date"%>
<%@attribute name="returnedBy"%>
<%@attribute name="returned" type="java.util.Date"%>
<%@attribute name="deletedBy"%>
<%@attribute name="deleted" type="java.util.Date"%>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">
            <fmt:message key="${titleKey}"/>
        </h3>
        <span>
            <c:if test="${not empty status}">
                ${status}
            </c:if>
        </span>
    </div>

    <div class="panel-body">
        <b:showUserActionInfo userName="${createdBy}" date="${created}" messageKey="label.created.by"/>

        <b:showUserActionInfo userName="${updatedBy}" date="${updated}" messageKey="label.updated.by"/>

        <b:showUserActionInfo userName="${approvedBy}" date="${approved}" messageKey="label.approved.by"/>

        <b:showUserActionInfo userName="${returnedBy}" date="${returned}" messageKey="label.returned.by"/>

        <b:showUserActionInfo userName="${deletedBy}" date="${deleted}" messageKey="label.deleted.by"/>
    </div>
</div>
