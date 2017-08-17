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
<%@attribute name="noResultFound" type="java.lang.Boolean" %>
<%@attribute name="currentUrl" type="java.lang.String" %>

<c:set var="disabledPrevious" value="${currentIndex == 0 ? 'disabled' : ''}"/>
<c:set var="disabledNext" value="${disableNextButton ? 'disabled' : ''}"/>

<script type="text/javascript">

    function navigate(currentIndex, sortProperty, sortOrder) {
        var url = '<c:url value="${listUrl}"/>';

        if (currentIndex) {
            url += '?currentIndex=' + currentIndex;
        }

        if (sortProperty && sortOrder) {
            url += currentIndex ? '&' : '?';
            url += 'sortProperty=' + sortProperty + '&sortOrder=' + sortOrder;
        }

        window.location =  url;
    }
</script>

<b:section titleKey="${titleKey}">
    <jsp:attribute name="body">

        <c:if test="${not empty propertyColumnNameMap}">

            <table class="table table-hover table-bordered table-responsive">
                <thead>
                    <tr>
                        <c:forEach items="${propertyColumnNameMap}" var="entry">
                            <th>
                                <fmt:message key="${entry.value}"/>

                                <c:url var="descendingUrl" value="${listUrl}">
                                    <c:param name="sortProperty" value="${entry.key}"/>
                                    <c:param name="sortOrder" value="desc"/>
                                </c:url>

                                <c:set var="descendingSortDisabled"
                                       value="${sortOrder == 'desc' and sortProperty == entry.key ? 'disabled' : ''}"/>

                                <c:url var="ascendingUrl" value="${listUrl}">
                                    <c:param name="sortProperty" value="${entry.key}"/>
                                    <c:param name="sortOrder" value="asc"/>
                                </c:url>

                                <c:set var="ascendingSortDisabled"
                                       value="${sortOrder == 'asc' and sortProperty == entry.key ? 'disabled' : ''}"/>
                                <span style="white-space: nowrap">
                                    <a href="${descendingUrl}" ${descendingSortDisabled}>
                                        <i class="fa fa-caret-down" aria-hidden="true"></i>
                                    </a>

                                    <a href="${ascendingUrl}" ${ascendingSortDisabled}>
                                        <i class="fa fa-caret-up" aria-hidden="true"></i>
                                    </a>
                                </span>
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
                                    <c:forEach items="${propertyColumnNameMap}" var="entry" varStatus="loop">
                                        <td>
                                            <c:choose>
                                                <c:when test="${loop.index == 0}">
                                                    <c:url var="loadUrl" value="${recordLoaderUrl}">
                                                        <c:param name="id" value="${record['id']}"/>
                                                        <c:param name="backLink" value="${currentUrl}"/>
                                                    </c:url>

                                                    <a href="${loadUrl}">
                                                        <c:out value="${record[entry.key]}"/>
                                                    </a>
                                                </c:when>

                                                <c:otherwise>
                                                    <c:out value="${record[entry.key]}"/>
                                                </c:otherwise>
                                            </c:choose>
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

                    <a href="#" onclick="navigate('${previousIndex}', '${sortProperty}', '${sortOrder}')">
                        <fmt:message key="label.previous"/>
                    </a>
                </li>

                <li class="next ${disabledNext}">
                    <c:set var="nextIndex" value="${noResultFound ? currentIndex : currentIndex + 1}"/>
                    <a href="#" onclick="navigate('${nextIndex}', '${sortProperty}', '${sortOrder}')">
                        <fmt:message key="label.next"/>
                    </a>
                </li>
            </ul>
        </nav>
    </jsp:attribute>
</b:section>

<div class="alert alert-info">
    <div class="row">
        <div class="col-sm-2" style="text-align: left">

            <c:url var="dashboardUrl" value="/qbank/common/dashboard"/>
            <b:button name="backToDashboard"
                      value="label.back"
                      onClick="window.location='${dashboardUrl}'"/>

        </div>
    </div>
</div>