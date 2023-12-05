const overlay = document.querySelector(".overlay");
const updateProfileDiv = document.querySelector('.edit-profile');
const editProfileButton = document.getElementById('edit-profile-button');


const currentDisplay = true;

editProfileButton.addEventListener('click', function () {
    if (currentDisplay) {
        updateProfileDiv.style.display = 'flex';
        overlay.style.display = "block";
        currentDisplay=false;
    } else {
        updateProfileDiv.style.display = 'none';
        overlay.style.display = "none";
    }
})

overlay.addEventListener("click", function () {
    overlay.style.display = "none";
    updateProfileDiv.style.display = 'none';
});

function DeleteAlert() {
    alert("Deleted");
}