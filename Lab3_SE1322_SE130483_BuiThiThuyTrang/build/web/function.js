

//check quantity 
function validateQuantity() {
    var x1 = document.forms["formUpdate"]["quantity"].value;
    var x2 = document.forms["formUpdate"]["quantityReal"].value;
    if (x1 == "") {
        alert("Quantity is empty");
        return false;
    }
    if (Number(x1) > Number(x2)) {
        alert("Quantity out of stock");
        return false;
    } else {
        return confirm('Do you want to submit?');

    }
}
//signup
function validSign() {
    var x1 = document.forms["formSignUp"]["email"].value;
    var x2 = document.forms["formSignUp"]["password"].value;
    var x3 = document.forms["formSignUp"]["confirm"].value;
    var x4 = document.forms["formSignUp"]["name"].value;
    var x5 = document.forms["formSignUp"]["phone"].value;
    var x6 = document.forms["formSignUp"]["address"].value;
    if (x1 == "") {
        alert("Email can't be blank");
        return false;
    }
    if (x2 == "") {
        alert("Password can't be blank");
        return false;
    }
    if (x3 == "") {
        alert("Confirm can't be blank");
        return false;
    }
    if (x4 == "") {
        alert("Name can't be blank");
        return false;
    }
    if (x5 == "") {
        alert("Phone can't be blank");
        return false;
    }
    if (x6 == "") {
        alert("Address can't be blank");
        return false;
    } else {
        return confirm('Do you want to submit?');

    }
}
function validateDates() {
    var x1 = document.forms["formConfirm"]["rentalDate"].value;
    var x2 = document.forms["formConfirm"]["returnDate"].value;

    if (x1 == "") {
        alert("Rental date can't empty");
        return false;
    }
    if (x2 == "") {
        alert("Return date can't empty");
        return false;
    } else {
        return confirm('Do you want to submit?');

    }
}
function validateSearch() {
    var x1 = document.forms["formConfirm"]["rentalDate"].value;
    var x2 = document.forms["formConfirm"]["returnDate"].value;
    var x3 = document.forms["formConfirm"]["searchName"].value;
    var x4 = document.forms["formConfirm"]["quantityCar"].value;
    if (x1 == "") {
        alert("Rental date can't empty");
        return false;
    }
    if (x3 == "") {
        alert(" Name can't empty");
        return false;
    }
    if (x2 == "") {
        alert("Return date can't empty");
        return false;
    }
    if (x4 == "") {
        alert("Quantity can't empty");
        return false;
    } else {
        return confirm('Do you want to submit?');

    }
}
function validateSearchCate() {
    var x1 = document.forms["formConfirmA"]["rentalDate1"].value;
    var x2 = document.forms["formConfirmA"]["returnDate1"].value;
    var x3 = document.forms["formConfirmA"]["searchCate"].value;
    var x4 = document.forms["formConfirmA"]["quantityCar1"].value;
    if (x1 == "") {
        alert("Rental date can't empty");
        return false;
    }
    if (x3 == "") {
        alert(" Name can't be blank");
        return false;
    }
    if (x2 == "") {
        alert("Return date can't empty");
        return false;
    }
    if (x4 == "") {
        alert("Quantity can't be blank");
        return false;
    } else {
        return confirm('Do you want to submit?');

    }
}
