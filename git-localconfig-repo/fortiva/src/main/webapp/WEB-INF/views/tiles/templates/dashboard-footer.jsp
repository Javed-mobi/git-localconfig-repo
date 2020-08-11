<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<script src="../js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/5.4.0/bootbox.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
<script>
	jQuery(document).ready(($) => {
		
		$(".read-only :input").prop('readonly', true).prop('disabled', 'disabled');
      	$(".read-only label").removeClass("active").addClass('disabled');
	      
		$('#config .config-save').on('click', function (e) {
       		$('.config-form').validate({
         		rules: {
           			"apiSignatureKey": {
             			required: () => {
               				return $("#sift-on").prop('checked') || $("#env-production").prop('checked');
             			}
           			},
           			"productionAccountId": {
             			required: () => {
               				return $("#env-production").prop('checked') && $("#sift-on").prop('checked');
             			}
           			},
           			"productionApiKey": {
             			required: () => {
               				return $("#env-production").prop('checked') && $("#sift-on").prop('checked');
             			}
           			},
           			"productionApiBeaconKey": {
             			required: () => {
               				return $("#env-production").prop('checked') && $("#sift-on").prop('checked');
             			}
           			},
           			"stagingAccountId": {
             			required: () => {
               				return $("#env-sandbox").prop('checked') && $("#sift-on").prop('checked');
             			}
           			},
           			"stagingApiKey": {
             			required: () => {
               				return $("#env-sandbox").prop('checked') && $("#sift-on").prop('checked');
             			}
           			},
           			"stagingApiBeaconKey": {
             			required: () => {
               				return $("#env-sandbox").prop('checked') && $("#sift-on").prop('checked');
             			}
           			}
         		},
         		messages: {
       	  			"apiSignatureKey": {
                 		required: "Please enter a Signature Key"
             		},
             		"productionAccountId": {
               			required: "Please enter the production AccountID"
             		},
             		"productionApiKey": {
               			required: "Please enter the production API Key"
             		},
             		"productionApiBeaconKey": {
               			required: "Please enter the production Beacon Key"
             		},
             		"stagingAccountId": {
               			required: "Please enter the sandbox AccountID"
             		},
             		"stagingApiKey": {
               			required: "Please enter the sandbox API Key"
             		},
             		"stagingApiBeaconKey": {
               			required: "Please enter the sandbox Beacon Key"
             		}
         		},
         		submitHandler: function(form) {
           			bootbox.confirm({
	             		message: "You are about to make changes to the app configuration. Are you sure?",
	             		callback: function (result) {
	               			form.submit();
	             		}
           			});
         		}
       		})
     	});
   });
</script>