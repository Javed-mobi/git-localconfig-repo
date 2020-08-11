<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>Store Domain</th>
				<th>Status</th>
				<th>Subscription Amount</th>
				<th>Usage Charge</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="shop" items="${shopList}">
				<form action="/install/enableSift" method="POST">
					<input type="hidden" name="shopId" value="${shop.id}" />
					<tr>
						<td><div>${shop.domain}</div></td>
						<td><button
								class="${shop.status == '0' ? 'btn btn-danger report-action-btn':'btn btn-success report-action-btn'}">${shop.status== '0' ? 'Enabled' : 'Disabled'}</button></td>
						<td><div>
								<fmt:formatNumber value="1000" type="currency" />
							</div></td>
						<td><div>
								<fmt:formatNumber value="0.07" type="currency" />
							</div></td>
						<td><input class="btn btn-primary btn-lg config-save"
							type="submit" value="Save"></td>
					</tr>
				</form>
			</c:forEach>
		</tbody>
	</table>
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="#">Previous</a></li>
			<li class="page-item "><a class="page-link" href="#">1</a></li>
			<li class="page-item active"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">Next</a></li>
		</ul>
	</nav>
</body>
</html>
