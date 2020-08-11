<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>
	<ul class="nav nav-tabs ">
		<li class="link"><a href="#"
			onclick="openScreen('configuration');">Configuration</a></li>
		<!-- <li class="link"><a href="#" onclick="openScreen('billing');">Billing</a></li> -->
		<li class="link"><a href="#" onclick="openScreen('report');">Reports</a></li>
		<li class="active link"><a href="#">Notifications</a></li>
		<!-- <li class="link"><a href="#" onclick="openScreen('faq');">FAQ's</a></li>  -->
	</ul>
</div>
<div class="tab-content">
	<div id="notifications" class="tab-pane fade in active">
		<div class="row">
			<div class="col-md-8 col-xs-6">
				<h3>Notifications</h3>
			</div>
			<div class=" mr-top col-md-4 col-xs-6 text-right"></div>
		</div>
		<div class="tab-pane-content">
			<form action="/install/dashboard/saveNotification" method="POST">
				<input type="hidden" name="shopId" id="shopId" value="${shopId}" />
				<table class="table">
					<c:forEach var="notification" items="${notificationList}">
						<tr>
							<td>
								<div>${notification.name}</div>
							</td>
							<td>
								<div class="btn-group toggle-buttons" data-toggle="buttons">
									<label
										class="${notification.value== '1' ? 'btn btn-primary active':'btn btn-primary'}">
										<input type="radio"
										name="${notification.keyCode}~~~${notification.id}" value="1"
										${notification.value=='1'?'checked':''}>Yes
									</label> <label
										class="${notification.value== '0' ? 'btn btn-primary active':'btn btn-primary'}">
										<input type="radio"
										name="${notification.keyCode}~~~${notification.id}" value="0"
										${notification.value=='0'?'checked':''}>No
									</label>
								</div>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td class="text-left" colspan="2">
							<div>
								<input class="btn btn-primary btn-lg config-save" type="submit"
									value="Save">
							</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>