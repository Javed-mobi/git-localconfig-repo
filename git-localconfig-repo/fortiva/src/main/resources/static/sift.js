function ls() {
	var e = document.createElement('script');
	e.src = 'https://cdn.sift.com/s.js';
	document.body.appendChild(e);
}

var _user_id = '';
var _session_id = '';
var beaconKey = '';
var _cart_token = '';

function callShopifyApi(){
	

	var url = 'https://shopify.sift.com/install/fetchBeaconTag?shop=' + Shopify.shop;
	var xhttp = new XMLHttpRequest();
	
	var body = '';
	xhttp.open('GET', url, false);
	xhttp.setRequestHeader('X-PINGOTHER', 'pingpong');
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4) {
			if (sessionStorage)
			    sessionStorage.setItem("sift-beacon-key", xhttp.responseText);  
				beaconKey = xhttp.responseText;
		}
	};
	xhttp.send(body);
}
async function fetchBeaconKey(){
	await callShopifyApi();
}

if (sessionStorage){
	beaconKey = sessionStorage.getItem("sift-beacon-key");
	_session_id = sessionStorage.getItem("_session_id");
	
	if(_session_id == "null" || _session_id == null || _session_id == ''){
		let r = Math.random().toString().substr(2,4);
		let timeStamp = Date.now();
		_session_id = timeStamp + '' + r;
		
		sessionStorage.setItem("_session_id", _session_id);
	}
	
	if(beaconKey == "null" || beaconKey == null || beaconKey == ''){
		fetchBeaconKey();
	}
}


jQuery.getJSON('/cart.js', function(cart) {
	_cart_token = sessionStorage.getItem("_cart_token");
	if(cart.item_count > 0 && _cart_token != cart.token){
			
		var xhttp = new XMLHttpRequest();
		var url = 'https://shopify.sift.com/sift/webhook/orders/sendSessionDetail';

		var body = JSON.stringify({ "shop": Shopify.shop, "_session_id": _session_id, "token": cart.token });
		sessionStorage.setItem("_cart_token", cart.token);
		xhttp.open('POST', url, true);
		xhttp.setRequestHeader('X-PINGOTHER', 'pingpong');
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4) {
			}
		};
		xhttp.send(body);
		
	}
});

var _sift = window._sift = window._sift || [];
_sift.push(['_setAccount', beaconKey]);
_sift.push(['_setUserId', _user_id]);
_sift.push(['_setSessionId', _session_id]);
_sift.push(['_trackPageview']);

ls();
