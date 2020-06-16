const value = document.querySelector('input[name="value"]')
value.addEventListener('blur', () => {
	if(value.value===''){
		value.style.backgroundColor = '#fcc'
		value.nextElementSibling.innerHTML = '※評価をご記入ください'
	} else {
		value.style.backgroundColor = '#fff'
		value.nextElementSibling.innerHTML = ''
	}
})

window.addEventListener('DOMContentLoaded',function(){
	document.getElementById('submit').disabled = true;
	document.getElementById('point').addEventListener('click',function(){
		document.getElementById('submit').disabled = false;
	},false);
},false);