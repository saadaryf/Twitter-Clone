
const signBtn = document.getElementById("signin");
const loginDiv = document.querySelector('.login');
const overlay = document.querySelector(".overlay");
const closeBtn = document.getElementById("close-btn");

const currentDisplay = true;


signBtn.addEventListener('click', function () {
    if (currentDisplay) {
        loginDiv.style.display = 'flex';
        overlay.style.display = "block";
        currentDisplay=false;
    } else {
        loginDiv.style.display = 'none';
        overlay.style.display = "none";
    }
})

overlay.addEventListener("click", function () {
    overlay.style.display = "none";
    loginDiv.style.display = 'none';
});

closeBtn.addEventListener("click", function(){
    overlay.style.display = "none";
    loginDiv.style.display = 'none';
})