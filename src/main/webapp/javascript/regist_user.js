const mail_address = document.querySelector('input[name="mail_address"]')
mail_address.addEventListener('blur', () => {
	if(mail_address.value===''){
		mail_address.style.backgroundColor = '#fcc'
		mail_address.nextElementSibling.innerHTML = '※mail_addressをご記入ください'
	} else {
		mail_address.style.backgroundColor = '#fff'
		mail_address.nextElementSibling.innerHTML = ''
	}
})

const name = document.querySelector('input[name="name"]')
name.addEventListener('blur', () => {
	if(name.value===''){
		name.style.backgroundColor = '#fcc'
		name.nextElementSibling.innerHTML = '※nameをご記入ください'
	} else {
		name.style.backgroundColor = '#fff'
		name.nextElementSibling.innerHTML = ''
	}
})

const password = document.querySelector('input[name="password"]')
password.addEventListener('blur', () => {
	if(password.value===''){
		password.style.backgroundColor = '#fcc'
		password.nextElementSibling.innerHTML = '※passwordをご記入ください'
	} else {
		password.style.backgroundColor = '#fff'
		password.nextElementSibling.innerHTML = ''
	}
})

const birthday = document.querySelector('input[name="birthday"]')
birthday.addEventListener('blur', () => {
	if(birthday.value===''){
		birthday.style.backgroundColor = '#fcc'
		birthday.nextElementSibling.innerHTML = '※birthdayをご記入ください'
	} else {
		birthday.style.backgroundColor = '#fff'
		birthday.nextElementSibling.innerHTML = ''
	}
})