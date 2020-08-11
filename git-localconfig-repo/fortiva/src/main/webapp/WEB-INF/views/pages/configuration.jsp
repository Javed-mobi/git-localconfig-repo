<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<ul class="nav nav-tabs ">
		<li class="active link"><a href="#">Configuration</a></li>
		<!-- <li class="link"><a href="#" onclick="openScreen('billing');">Billing</a></li> -->
		<li class="link"><a href="#" onclick="openScreen('report');">Reports</a></li>
		<li class="link"><a href="#"
			onclick="openScreen('notification');">Notifications</a></li>
		<!-- <li class="link"><a href="#" onclick="openScreen('faq');">FAQ's</a></li>  -->
	</ul>
</div>
<div class="tab-content">

	<div id="config" class="tab-pane fade in active">
		<div class="row">
			<div class="col-md-8 col-xs-6">
				<h3>Configuration</h3>
			</div>
		</div>
		<c:if test="${billingApproveStatus == '0' && confirmationUrl == ''}">
			<div class="notification-bar">
				<span>Don't have a Sift Account? <a
					href="https://sift.com/contact-us"
					style="text-decoration: underline;" class="btn btn-primary"
					target="_blank"> Contact Sift</a>
				</span>
			</div>
		</c:if>
		<c:if test="${billingApproveStatus == '0' && confirmationUrl != ''}">
			<div class="notification-bar">
				<span>Your account has been activated. Activate your billing
					to start using Sift. <a href="${confirmationUrl}"
					style="text-decoration: underline;" class="btn btn-primary"
					target="_blank">Activate Billing</a>
				</span>
			</div>
		</c:if>
		<div class="tab-pane-content">

			<c:if test="${billingApproveStatus == '0'}">
				<form action="/install/dashboard/saveConfiguration" method="POST"
					class="config-form read-only">
			</c:if>

			<c:if test="${billingApproveStatus == '1'}">
				<form class="config-form"
					action="/install/dashboard/saveConfiguration" method="POST">
			</c:if>



			<input type="hidden" name="shopId" id="shopId" value="${shopId}" />
			<input type="hidden" name="id" value="${configuration.id}" />
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Value</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Enable Sift</td>
						<td>
							<div class="btn-group toggle-buttons" data-toggle="buttons">
								<label
									class="${configuration.siftEnabled== '1' ? 'btn btn-primary active':'btn btn-primary'}">
									<input type="radio" name="siftEnabled" value="1" id="sift-on"
									${configuration.siftEnabled=='1'?'checked':''}>Enabled
								</label> <label
									class="${configuration.siftEnabled== '0' ? 'btn btn-primary active':'btn btn-primary'}">
									<input type="radio" name="siftEnabled" value="0" id="sift-off"
									${configuration.siftEnabled=='0'?'checked':''}>Disabled
								</label>
							</div>
						</td>
					</tr>
					<tr>
						<td>Environment</td>
						<td>
							<div class="btn-group toggle-buttons" data-toggle="buttons">
								<label
									class="${configuration.environment== '1' ? 'btn btn-primary active':'btn btn-primary'}">
									<input type="radio" id="env-production" name="environment"
									value="1" ${configuration.environment=='1'?'checked':''} />Production
								</label> <label
									class="${configuration.environment== '0' ? 'btn btn-primary active':'btn btn-primary'}">
									<input type="radio" id="env-sandbox" name="environment"
									value="0" ${configuration.environment=='0'?'checked':''} />Sandbox
								</label>
							</div>
						</td>
					</tr>
					<tr>
						<td>API Signature Key</td>
						<td>
							<div class="row ">
								<div class="col-sm-9">
									<input type="text" class="form-control" name="apiSignatureKey"
										id="api-signature-key"
										value="${configuration.apiSignatureKey}" />
								</div>
							</div>
						</td>
					</tr>
					<tr class="env-header">
						<th colspan="2">Sandbox Keys</th>
					</tr>
					<tr>
						<td>Account ID</td>
						<td>
							<div class="row ">
								<div class="col-sm-9">
									<input type="text" class="form-control" name="stagingAccountId"
										value="${configuration.stagingAccountId}" />
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>API Key</td>
						<td>
							<div class="row ">
								<div class="col-sm-9">
									<input type="text" class="form-control" name="stagingApiKey"
										value="${configuration.stagingApiKey}" />
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>API Beacon key</td>
						<td>
							<div class="row">
								<div class="col-sm-9">
									<input type="text" class="form-control"
										name="stagingApiBeaconKey"
										value="${configuration.stagingApiBeaconKey}" />

								</div>
							</div>
						</td>
					</tr>
					<tr class="env-header">
						<th colspan="2">Production Keys</th>
					</tr>
					<tr>
						<td>Account ID</td>
						<td>
							<div class="row">
								<div class="col-sm-9">
									<input type="text" class="form-control"
										name="productionAccountId"
										value="${configuration.productionAccountId}" />

								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>API Key</td>
						<td>
							<div class="row ">
								<div class="col-sm-9">
									<input type="text" class="form-control" name="productionApiKey"
										value="${configuration.productionApiKey}" />
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>API Beacon key</td>
						<td>
							<div class="row">
								<div class="col-sm-9">
									<input type="text" class="form-control"
										name="productionApiBeaconKey"
										value="${configuration.productionApiBeaconKey}" />
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td></td>
						<td class="text-right"><c:if
								test="${billingApproveStatus == '0'}">
								<input class=" btn btn-primary btn-lg config-save" type="submit"
									value="Save" disabled="disabled">
							</c:if> <c:if test="${billingApproveStatus == '1'}">
								<input class=" btn btn-primary btn-lg config-save" type="submit"
									value="Save">
							</c:if></td>
					</tr>
				</tbody>
			</table>
			</form>
		</div>
	</div>
</div>
