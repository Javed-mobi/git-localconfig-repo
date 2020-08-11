<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<ul class="nav nav-tabs ">
		<li class="link"><a href="#"
			onclick="openScreen('configuration');">Configuration</a></li>
		<!-- <li class="link"><a href="#" onclick="openScreen('billing');">Billing</a></li> -->
		<li class="active link"><a href="#">Reports</a></li>
		<li class="link"><a href="#"
			onclick="openScreen('notification');">Notifications</a></li>
		<!-- <li class="link"><a href="#" onclick="openScreen('faq');">FAQ's</a></li> -->
	</ul>
</div>
<div class="tab-content">
	<input type="hidden" name="shopId" value="${shopId}" id="shopId" />
	<div id="reports" class="tab-pane fade in active">
		<div class="row">
			<div class="col-md-8 col-xs-6">
				<h3>Billing</h3>
			</div>
			<div class=" mr-top col-md-4 col-xs-6 text-right"></div>
		</div>
		<div class="tab-pane-content">
			<table class="table">
				<thead>
					<tr class="reports-header-text">
						<c:url value="/dashboard/sortedReport" var="sort">
							<c:param name="page" value="${page-1}" />
							<c:param name="shopId" value="${shopId}" />
							<c:param name="sortDirection" value="${sortDirection}" />
						</c:url>

						<th>
							<div class="pd-lft">
								<a href="#" class="sort-by">Order Number</a>
							</div>
						</th>
						<th class="pd-top">Customer Name</th>
						<th class="pd-top">Amount</th>
						<th class="pd-top">Sift Score</th>
						<th class="pd-top" onclick=""><a
							href="<c:out value="${sort}" />" class="sort-by">Action/Decision
								Taken</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${orderList.content}">
						<tr class="reports-content-text">
							<td><div class="pd-lft">#${order.orderNo}</div></td>
							<td>${order.customerName}</td>
							<td><span class="input-group-text"><fmt:formatNumber
										value="${order.amount}" type="currency" /></span></td>
							<td>${order.siftScore}</td>
							<td><c:if test="${order.actionTaken== 'BLOCK'}">
									<span class="btn btn-danger report-action-btn">Blocked</span>
								</c:if> <c:if test="${order.actionTaken== 'ACCEPT'}">
									<span class="btn btn-success report-action-btn">Accepted</span>
								</c:if> <c:if test="${order.actionTaken== 'WATCH'}">
									<span class="btn btn-warning report-action-btn">Watched</span>
								</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


			<nav aria-label="Page navigation example">
				<ul class="pagination">

					<c:url value="/dashboard/report" var="prev2">
						<c:param name="page" value="${page-3}" />
						<c:param name="shopId" value="${shopId}" />
						<c:param name="sortDirection" value="${sortDirection}" />
					</c:url>
					<c:if test="${page > 2}">
						<li class="page-item"><a href="<c:out value="${prev2}" />"
							class="page-link">Previous</a></li>
					</c:if>

					<c:url value="/dashboard/report" var="prev1">
						<c:param name="page" value="${page-2}" />
						<c:param name="shopId" value="${shopId}" />
						<c:param name="sortDirection" value="${sortDirection}" />
					</c:url>
					<c:if test="${page > 1}">
						<li class="page-item"><a href="<c:out value="${prev1}" />"
							class="page-link">${page - 1}</a></li>
					</c:if>

					<li class="page-item active"><a href="#" class="page-link">${page}</a></li>

					<c:url value="/dashboard/report" var="next1">
						<c:param name="page" value="${page}" />
						<c:param name="shopId" value="${shopId}" />
						<c:param name="sortDirection" value="${sortDirection}" />
					</c:url>
					<c:if test="${page + 1 <= maxPages}">
						<li class="page-item"><a href='<c:out value="${next1}" />'
							class="page-link">${page + 1}</a></li>
					</c:if>

					<c:url value="/dashboard/report" var="next2">
						<c:param name="page" value="${page + 1}" />
						<c:param name="shopId" value="${shopId}" />
						<c:param name="sortDirection" value="${sortDirection}" />
					</c:url>
					<c:if test="${page + 2 <= maxPages}">
						<li class="page-item"><a href='<c:out value="${next2}" />'
							class="page-link">Next</a></li>
					</c:if>

				</ul>
			</nav>

		</div>
	</div>
</div>
