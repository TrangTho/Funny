//Get the button
var mybutton = document.getElementById("myBtn");

// When the user scrolls  show the button
window.onscroll = function() { scrollFunction() };

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        // mybutton.style.display = "block";
        // mybutton[0].classList.add('animate');
        mybutton.style.animation = "fadeUp 1s ease-out forwards";
    } else {
        // mybutton.style.display = "none";
        // mybutton[0].classList.remove('animate');
        mybutton.style.animation = "fadeDown 1s ease-in-out forwards";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}