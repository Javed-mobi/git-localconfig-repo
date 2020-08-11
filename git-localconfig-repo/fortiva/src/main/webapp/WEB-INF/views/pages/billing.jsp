<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>
	<ul class="nav nav-tabs ">
		<li class="link"><a href="#" onclick="openScreen('dashboard');">Configuration</a></li>
		<li class="active link"><a href="#">Billing</a></li>
		<li class="link"><a href="#" onclick="openScreen('report');">Reports</a></li>
		<li class="link"><a href="#"
			onclick="openScreen('notification');">Notifications</a></li>
		<li class="link"><a href="#" onclick="openScreen('faq');">FAQ's</a></li>
	</ul>
</div>
<div class="tab-content">
	<div id="billing" class="tab-pane fade in active">
		<div class="row">
			<div class="col-md-8 col-xs-6">
				<h3>Billing</h3>
			</div>
			<div class=" mr-top col-md-4 col-xs-6 text-right">
				<span style="font-weight: 500; color: #525566; font-size: 13px;">Don't
					have a Sift Account? <br />Contact the Sift Team <a href="#"
					style="text-decoration: underline;"> here</a>
				</span>
			</div>
		</div>
		<div class="tab-pane-content">
			<input type="hidden" name="shopId" id="shopId" value="${shopId}" />
			<table class="table">
				<thead>
					<tr class="well billing-header-rows">
						<th><div class="pd-lft">
								<a href="#" class="sort-by">ID</a>
							</div></th>
						<th><a href="#" class="sort-by">Date</a></th>
						<th>Description</th>
						<th>Amount</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="bill" items="${billList}">
						<tr class="well billing-tab-rows">
							<td><div class="pd-lft">#${ bill.id }</div></td>
							<td>${ bill.billDate }</td>
							<td>${bill.description}</td>
							<td><span class="input-group-text"><fmt:formatNumber
										value="${bill.amount}" type="currency" /></span></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- 	
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#">Previous</a></li>
				<li class="page-item "><a class="page-link" href="#">1</a></li>
				<li class="page-item active"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>
		 -->
	</div>
</div>