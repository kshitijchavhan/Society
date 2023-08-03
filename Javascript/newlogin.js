let signup = document.querySelector(".signup");
let login = document.querySelector(".login");
let slider = document.querySelector(".slider");
let formSection = document.querySelector(".form-section");
  
signup.addEventListener("click", () => {
    slider.classList.add("moveslider");
    formSection.classList.add("form-section-move");
});
  
login.addEventListener("click", () => {
    slider.classList.remove("moveslider");
    formSection.classList.remove("form-section-move");
});
function checkPassword() {
  var passwordInput = document.getElementById("password");
  var password = passwordInput.value;

  if (password.length >= 8) {
	document.getElementById("msg").innerHTML="";
    } else {
    document.getElementById("msg").innerHTML="password must be 8 diget";
    }
}


