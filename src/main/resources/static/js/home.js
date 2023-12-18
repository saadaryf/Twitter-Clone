const overlay = document.querySelector(".overlay");
const updateProfileDiv = document.querySelector('.edit-profile');
const editProfileButton = document.getElementById('edit-profile-button');


const currentDisplay = true;

$(document).ready(function () {
    $('#update-like-button').on('click', function (event) {
        event.preventDefault(); 
        var tweetId = $(this).attr('href').split('=')[1];
        $.ajax({
            type: 'GET',
            url: $(this).attr('href'),
            data: { id: tweetId },
            success: function (response) {
                console.log("success");
                if (response === 'like-updated') {
                    $("#like-count-" + tweetId).text(response.likeCount);
                } else {
                    console.error('Unexpected response:', response);
                }
            },
            error: function (error) {
                console.error('Error updating likes:', error);
            }
        });
    });
});

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


