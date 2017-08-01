<%@ taglib tagdir="/WEB-INF/tags/bootstrap" prefix="b"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@attribute name="titleKey" type="java.lang.String" %>
<%@attribute name="currentIndex" type="java.lang.Integer" %>
<%@attribute name="disableNextButton" type="java.lang.Boolean" %>
<%@attribute name="listUrl" type="java.lang.String" %>
<%@attribute name="recordLoaderUrl" type="java.lang.String" %>
<%@attribute name="propertyColumnNameMap" type="java.util.LinkedHashMap" %>
<%@attribute name="records" type="java.util.List" %>
<%@attribute name="sortProperty" type="java.lang.String" %>
<%@attribute name="sortOrder" type="java.lang.String" %>
<%@attribute name="filterProperty" type="java.lang.String" %>
<%@attribute name="filterValue" type="java.lang.String" %>
<%@attribute name="noResultFound" type="java.lang.Boolean" %>

<c:set var="disabledPrevious" value="${currentIndex == 0 ? 'disabled' : ''}"/>
<c:set var="disabledNext" value="${disableNextButton ? 'disabled' : ''}"/>

<script type="text/javascript">
    function filter(sortProperty, sortOrder) {
        var filterProperty = $("#filterProperty").val();
        var filterValue = $("#filterValue").val();

        if (!filterProperty) {
            alert("Please select property for filtering");
            return;
        }

        if (!filterValue) {
            alert("Please enter a value for the selected filter property");
            return;
        }

        var url = '<c:url value="${listUrl}"/>' + '?filterProperty=' + filterProperty + '&filterValue=' + filterValue;
        if (sortProperty && sortOrder) {
            url += '&sortProperty=' + sortProperty + '&sortOrder=' + sortOrder;
        }

        window.location = url;
    }

    function navigateSortFilter(currentIndex, sortProperty, sortOrder, filterProperty, filterValue) {
        var url = '<c:url value="${listUrl}"/>';

        if (currentIndex) {
            url += '?currentIndex=' + currentIndex;
        }

        if (sortProperty && sortOrder) {
            url += currentIndex ? '&' : '?';
            url += 'sortProperty=' + sortProperty + '&sortOrder=' + sortOrder;
        }

        if (filterProperty && filterValue) {
            url += currentIndex || sortProperty ? '&' : '?';
            url += 'filterProperty=' + filterProperty + '&filterValue=' + filterValue;
        }

        window.location =  url;
    }
</script>

<b:section titleKey="${titleKey}">
    <jsp:attribute name="body">

        <div class="form-inline">
            <div class="form-group">
                <label><fmt:message key="label.filter.by.property"/></label>
                <select class="form-control" id="filterProperty">
                    <option value="0"><fmt:message key="label.select.filter.property"/></option>

                    <c:forEach items="${propertyColumnNameMap}" var="entry">
                        <c:set var="selected" value="${entry.key == filterProperty ? 'selected' : ''}"/>
                        
                        <option value="${entry.key}" ${selected}>
                            <fmt:message key="${entry.value}"/>
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label><fmt:message key="label.filter.value"/></label>
                <input class="form-control" type="text" id="filterValue" value="${not empty filterValue ? filterValue : ''}">
            </div>

            <div class="form-group">
                <b:button name="filterButton"
                          type="button"
                          id="filterButton"
                          onClick="filter('${sortProperty}', '${sortOrder}')"
                          value="label.filter"/>
            </div>
        </div>

        <hr/>

        <c:if test="${not empty propertyColumnNameMap}">

            <c:if test="${not empty filterProperty and not empty filterValue}">
                <div class="well">
                    <c:url var="clearUrl" value="${listUrl}">
                        <c:if test="${not empty sortProperty and not empty  sortOrder}">
                            <c:param name="sortProperty" value="${sortProperty}"/>
                            <c:param name="sortValue" value="${sortOrder}"/>
                        </c:if>
                    </c:url>
                    <fmt:message key="msg.filtered.result"/> &nbsp;&nbsp;
                    <a href="${clearUrl}"><b><fmt:message key="label.clear.filter.effect"/></b></a>
                </div>
            </c:if>

            <table class="table table-hover table-bordered table-responsive">
                <thead>
                    <tr>
                        <c:forEach items="${propertyColumnNameMap}" var="entry">
                            <th>
                                <fmt:message key="${entry.value}"/>

                                <c:url var="descendingUrl" value="${listUrl}">
                                    <c:param name="sortProperty" value="${entry.key}"/>
                                    <c:param name="sortOrder" value="desc"/>

                                    <c:if test="${not empty filterProperty and not empty filterValue}">
                                        <c:param name="filterProperty" value="${filterProperty}"/>
                                        <c:param name="filterValue" value="${filterValue}"/>
                                    </c:if>
                                </c:url>

                                <c:set var="descendingSortDisabled"
                                       value="${sortOrder == 'desc' and sortProperty == entry.key ? 'disabled' : ''}"/>

                                <a href="${descendingUrl}" ${descendingSortDisabled}>
                                    <i class="fa fa-caret-down" aria-hidden="true"></i>
                                </a>

                                <c:url var="ascendingUrl" value="${listUrl}">
                                    <c:param name="sortProperty" value="${entry.key}"/>
                                    <c:param name="sortOrder" value="asc"/>

                                    <c:if test="${not empty filterProperty and not empty filterValue}">
                                        <c:param name="filterProperty" value="${filterProperty}"/>
                                        <c:param name="filterValue" value="${filterValue}"/>
                                    </c:if>
                                </c:url>

                                <c:set var="ascendingSortDisabled"
                                       value="${sortOrder == 'asc' and sortProperty == entry.key ? 'disabled' : ''}"/>

                                <a href="${ascendingUrl}" ${ascendingSortDisabled}>
                                    <i class="fa fa-caret-up" aria-hidden="true"></i>
                                </a>
                            </th>
                        </c:forEach>
                    </tr>
                </thead>

                <tbody>
                    <c:choose>
                        <c:when test="${noResultFound and currentIndex == 0}">
                            <tr>
                                <td colspan="">
                                    <fmt:message key="msg.no.record.found"/>
                                </td>
                            </tr>
                        </c:when>

                        <c:when test="${noResultFound and currentIndex > 0}">
                            <tr>
                                <td colspan="">
                                    <fmt:message key="msg.no.more.records"/>
                                </td>
                            </tr>
                        </c:when>

                        <c:otherwise>
                            <c:forEach items="${records}" var="record">
                                <tr>
                                    <c:forEach items="${propertyColumnNameMap}" var="entry">
                                        <td>
                                            <c:out value="${record[entry.key]}"/>
                                        </td>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </c:if>

        <nav>
            <ul class="pager">
                <li class="previous ${disabledPrevious}">
                    <c:set var="previousIndex" value="${currentIndex > 0 ? currentIndex - 1 : 0}"/>

                    <a href="#" onclick="navigateSortFilter('${previousIndex}', '${sortProperty}', '${sortOrder}', '${filterProperty}', '${filterValue}')">
                        <fmt:message key="label.previous"/>
                    </a>
                </li>

                <li class="next ${disabledNext}">
                    <c:set var="nextIndex" value="${noResultFound ? currentIndex : currentIndex + 1}"/>
                    <a href="#" onclick="navigateSortFilter('${nextIndex}', '${sortProperty}', '${sortOrder}', '${filterProperty}', '${filterValue}')">
                        <fmt:message key="label.next"/>
                    </a>
                </li>
            </ul>
        </nav>
    </jsp:attribute>
</b:section>
