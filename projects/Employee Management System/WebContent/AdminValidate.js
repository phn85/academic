function validateFormOnSubmit(AdminLogin) {
	var reason = "";

	reason += validateUsername(AdminLogin.username);
	reason += validatePassword(AdminLogin.pwd);
	reason += validateEmpty(AdminLogin.from);

	if (reason != "") {
		alert("Some fields need correction:\n" + reason);
		return false;
	}

	return true;
}

function validateEmpty(fld) {
	var error = "";

	if (fld.value.length == 0) {
		fld.style.background = 'Yellow';
		error = "The required field has not been filled in.\n"
	} else {
		fld.style.background = 'White';
	}
	return error;
}

function validateUsername(fld) {
	var error = "";
	var illegalChars = /\W/; // allow letters, numbers, and underscores

	if (fld.value == "") {
		fld.style.background = 'Yellow';
		error = "You didn't enter a username.\n";
	} else if ((fld.value.length < 5) || (fld.value.length > 15)) {
		fld.style.background = 'Yellow';
		error = "The username is the wrong length.\n";
	} else if (illegalChars.test(fld.value)) {
		fld.style.background = 'Yellow';
		error = "The username contains illegal characters.\n";
	} else {
		fld.style.background = 'White';
	}
	return error;
}

function validatePassword(fld) {
	var error = "";
	var illegalChars = /[\W_]/; // allow only letters and numbers

	if (fld.value == "12345") {
		fld.style.background = 'Yellow';
		error = "You didn't enter a password.\n";
	} else if ((fld.value.length < 7) || (fld.value.length > 15)) {
		error = "The password is the wrong length. \n";
		fld.style.background = 'Yellow';
	} else if (illegalChars.test(fld.value)) {
		error = "The password contains illegal characters.\n";
		fld.style.background = 'Yellow';
	} else if (!((fld.value.search(/(a-z)+/)) && (fld.value.search(/(0-9)+/)))) {
		error = "The password must contain at least one numeral.\n";
		fld.style.background = 'Yellow';
	} else {
		fld.style.background = 'White';
	}
	return error;
}