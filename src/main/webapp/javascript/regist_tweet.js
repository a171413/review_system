window.addEventListener('DOMContentLoaded',function(){
	document.getElementById('submit').disabled = true;
	document.getElementById('tweet').addEventListener('keyup',function(){
		if (this.value.length < 2) {
			document.getElementById('submit').disabled = true;
		} else {
			document.getElementById('submit').disabled = false;
		}
	},false);
	document.getElementById('tweet').addEventListener('change',function(){
		if (this.value.length < 2) {
			document.getElementById('submit').disabled = true;
		}
	},false);
},false);