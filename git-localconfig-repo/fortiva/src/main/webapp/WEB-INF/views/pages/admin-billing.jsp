<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<title>Dashboard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="../style.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
</head>

<body class="admin">
	<div class="container-fluid">
		<nav class="navbar navbar-inverse">
			<div class="container">
				<div class="col-xs-4 col-md-5 text-left">
					<a href="#"> <svg class="icon-monochrome-logo">
							<use xlink:href="#icon-monochrome-logo">
                <symbol viewBox="0 0 501 234" id="icon-monochrome-logo"
								xmlns="http://www.w3.org/2000/svg">
							<circle cx="309.024" cy="28.885" r="13.649" fill="#fff" />
							<path
								d="M253.799 227.966h28.351l32.902-155.351h-28.35l-32.903 155.351zm208.75-132.494h32.321L500 72.615h-32.318l9.35-44.275h-28.196l-.022.024-9.482 44.251-48.964.167 4.414-20.446c1.973-9.419 6.508-20.171 14.191-23.706 6.03-2.775 13.522-3.318 19.488-3.163l5.113-22.926c-3.895-.727-9.214-1.248-14.297-1.248-30.988 0-46.383 21.527-52.708 50.766l-4.548 20.724h-24.163l-5.133 22.857h24.163l-27.769 132.493h28.35l27.77-132.493 48.964-.167-20.003 95.155c-5.465 26.076 1.777 39.196 27.74 39.196 7.16 0 15.176-.167 22.774-2.718l4.883-21.859c-4.745.943-10.404 1.249-14.952 1.249-13.205 0-13.954-6.741-11.126-20.086l19.03-90.938z"
								fill="#fff" />
							<circle cx="9.671" cy="129.725" r="8.685" fill="#fff" />
							<circle cx="41.142" cy="129.725" r="9.544" fill="#fff" />
							<circle cx="72.614" cy="129.725" r="10.498" fill="#fff" />
							<circle cx="135.3" cy="129.725" r="10.498" fill="#fff" />
							<circle cx="104.085" cy="129.725" r="10.498" fill="#fff" />
							<circle cx="9.671" cy="98.195" r="6.872" fill="#fff" />
							<circle cx="41.142" cy="98.195" r="8.267" fill="#fff" />
							<circle cx="72.614" cy="98.195" r="10.498" fill="#fff" />
							<circle cx="104.085" cy="98.195" r="10.498" fill="#fff" />
							<circle cx="135.556" cy="98.195" r="10.498" fill="#fff" />
							<circle cx="41.142" cy="65.758" r="8.267" fill="#fff" />
							<circle cx="167.028" cy="65.758" r="8.267" fill="#fff" />
							<circle cx="9.671" cy="66.665" r="4.008" fill="#fff" />
							<circle cx="135.556" cy="66.665" r="9.019" fill="#fff" />
							<circle cx="72.614" cy="66.665" r="9.019" fill="#fff" />
							<circle cx="104.085" cy="66.665" r="10.498" fill="#fff" />
							<circle cx="41.142" cy="35.135" r="4.008" fill="#fff" />
							<circle cx="72.614" cy="35.135" r="6.872" fill="#fff" />
							<circle cx="104.085" cy="35.135" r="8.685" fill="#fff" />
							<circle cx="135.556" cy="35.135" r="6.872" fill="#fff" />
							<circle cx="167.028" cy="35.135" r="4.008" fill="#fff" />
							<circle cx="9.671" cy="161.255" r="6.872" fill="#fff" />
							<circle cx="167.028" cy="162.04" r="7.441" fill="#fff" />
							<circle cx="135.556" cy="161.255" r="10.498" fill="#fff" />
							<circle cx="104.085" cy="161.255" r="10.498" fill="#fff" />
							<circle cx="72.614" cy="161.255" r="10.498" fill="#fff" />
							<circle cx="41.142" cy="161.255" r="8.267" fill="#fff" />
							<circle cx="167.028" cy="190.098" r="6.614" fill="#fff" />
							<circle cx="41.142" cy="193.692" r="8.267" fill="#fff" />
							<circle cx="193.788" cy="190.098" r="4.008" fill="#fff" />
							<circle cx="72.614" cy="192.785" r="9.019" fill="#fff" />
							<circle cx="104.085" cy="192.785" r="10.498" fill="#fff" />
							<circle cx="9.671" cy="192.785" r="4.008" fill="#fff" />
							<circle cx="135.556" cy="224.315" r="6.872" fill="#fff" />
							<circle cx="104.085" cy="224.315" r="8.685" fill="#fff" />
							<circle cx="72.614" cy="224.315" r="6.872" fill="#fff" />
							<circle cx="41.142" cy="224.315" r="4.008" fill="#fff" />
							<path
								d="M209.095 138.997l-.01-.005c-1.686-.947-3.372-1.864-5.031-2.767-11.784-6.409-21.961-11.943-21.961-22.358 0-11.376 11.136-20.287 25.351-20.287 10.557 0 20.347 4.702 29.906 14.37l17.74-17.027c-13.595-14.056-29.967-21.48-47.393-21.48-15.112 0-29.178 4.793-39.607 13.494-10.617 8.859-16.464 21.058-16.464 34.349 0 16.555 10.185 29.544 33.024 42.115 19.906 11.045 28.012 16.571 28.012 26.901 0 11.34-12.769 20.92-27.884 20.92-8.871 0-17.375-3.026-25.276-8.996l-.312-.253a5.245 5.245 0 0 1-.152-.108 14.52 14.52 0 0 1-.461-.357l-.283-.222c-.157-.12-.312-.243-.468-.366l-.067-.053c-3.481-2.862-6.782-6.289-9.831-10.2l-.015.012-.496-.671a70.962 70.962 0 0 1-3.341-4.972l-20.721 13.244c2.863 5.529 6.784 10.75 11.663 15.529 12.308 12.867 30.888 21.17 47.352 21.17 35.774 0 60.758-20.09 60.758-48.856.001-17.713-9.541-29.804-34.033-43.126z"
								fill="#fff" /></symbol>
							<symbol viewBox="0 0 10 17" id="icon-triangle"
								xmlns="http://www.w3.org/2000/svg">
							<path
								d="M1.8.3l7.9 7.5c.4.4.4 1.1 0 1.5l-7.9 7.5c-.7.5-1.8.1-1.8-.8V1C0 .1 1.1-.3 1.8.3z" /></symbol>
              </use></svg>
					</a>
				</div>
				<div class="col-xs-8 col-md-7 text-right">
					<a class="btn btn-link lnk-logout" href="/install/logout">Logout</a>
				</div>
			</div>
		</nav>
	</div>
	<div class="container">
		<!--Billing-->
		<div class="adm-listing">
			<div class="row">
				<div class="col-md-12 page-heading">
					<h3>Reports</h3>
				</div>
			</div>
			<div class="adm-store-info">
				<div class="row text-center">
					<div class="col col-md-3">
						<span>Store Name: </span>${shopName}
					</div>
					<div class="col col-md-3">
						<span>Status: </span>${shopStatus}
					</div>
					<div class="col col-md-3">
						<span>Subscription: </span>$${subscription}
					</div>
					<div class="col col-md-3">
						<span>Billing Rate: </span>$${apiRate}
					</div>
				</div>
			</div>

			<div class="tab-pane-content">
				<table class="table">
					<thead>
						<tr class="reports-header-text">

							<c:url value="/shop/sortedReport" var="sort">
								<c:param name="page" value="${page-1}" />
								<c:param name="shopId" value="${shopId}" />
								<c:param name="sortDirection" value="${sortDirection}" />
							</c:url>

							<th>
								<div class="pd-lft">
									<a href="#" class="sort-by">Order Number</a>
								</div>
							</th>
							<th class="pd-top"><a href="#" class="sort-by">Customer
									Name</a></th>
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

						<c:url value="/shop/ShowReportDetail" var="prev2">
							<c:param name="sortDirection" value="${sortDirection}" />
							<c:param name="page" value="${page-3}" />
							<c:param name="shopId" value="${shopId}" />
						</c:url>
						<c:if test="${page > 2}">
							<li class="page-item"><a href="<c:out value="${prev2}" />"
								class="page-link">Previous</a></li>
						</c:if>

						<c:url value="/shop/ShowReportDetail" var="prev1">
							<c:param name="sortDirection" value="${sortDirection}" />
							<c:param name="page" value="${page-2}" />
							<c:param name="shopId" value="${shopId}" />
						</c:url>
						<c:if test="${page > 1}">
							<li class="page-item"><a href="<c:out value="${prev1}" />"
								class="page-link">${page - 1}</a></li>
						</c:if>

						<li class="page-item active"><a href="#" class="page-link">${page}</a></li>

						<c:url value="/shop/ShowReportDetail" var="next1">
							<c:param name="sortDirection" value="${sortDirection}" />
							<c:param name="page" value="${page}" />
							<c:param name="shopId" value="${shopId}" />
						</c:url>
						<c:if test="${page + 1 <= maxPages}">
							<li class="page-item"><a href='<c:out value="${next1}" />'
								class="page-link">${page + 1}</a></li>
						</c:if>

						<c:url value="/shop/ShowReportDetail" var="next2">
							<c:param name="sortDirection" value="${sortDirection}" />
							<c:param name="page" value="${page + 1}" />
							<c:param name="shopId" value="${shopId}" />
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
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		crossorigin="anonymous"></script>
	<script src="js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/5.4.0/bootbox.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
	<script>
    jQuery(document).ready(($) => {
      $('.lnk-billing-rate').on('click', function(e) {
        e.preventDefault();
        bootbox.prompt({
            title: "API Billing Rate ($)",
            inputType: 'number',
            value: '0.07',
            step: '.01',
            callback: function (result) {
                console.log(result);
            }
        });
      });
      $('.lnk-activate').on('click', function(e) {
        e.preventDefault();
        bootbox.prompt({
            title: "Set Subscription Amount & Activate ($)",
            inputType: 'number',
            value: '1000',
            callback: function (result) {
                console.log(result);
            },
            buttons: {
                confirm: {
                    label: 'Update & Activate',
                },
                cancel: {
                    label: 'Cancel',
                }
            }
        });
      });
      
    });
  </script>
</html>