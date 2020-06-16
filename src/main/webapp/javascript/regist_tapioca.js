window.addEventListener('DOMContentLoaded',function(){
	document.getElementById('submit').disabled = true;
	document.getElementById('name').addEventListener('keyup',function(){
		if (this.value.length < 1) {
			document.getElementById('submit').disabled = true;
		} else {
			document.getElementById('submit').disabled = false;
		}
	},false);
	document.getElementById('name').addEventListener('change',function(){
		if (this.value.length < 1) {
			document.getElementById('submit').disabled = true;
		}
	},false);
},false);

const name = document.querySelector('input[name="name"]')
name.addEventListener('blur', () => {
	if(name.value===''){
		name.style.backgroundColor = '#fcc'
		name.nextElementSibling.innerHTML = '※名前をご記入ください'
	} else {
		name.style.backgroundColor = '#fff'
		name.nextElementSibling.innerHTML = ''
	}
})

const address = document.querySelector('input[name="address"]')
address.addEventListener('blur', () => {
	if(address.value===''){
		address.style.backgroundColor = '#fcc'
		address.nextElementSibling.innerHTML = '※住所をご記入ください'
	} else {
		address.style.backgroundColor = '#fff'
		address.nextElementSibling.innerHTML = ''
	}
})

