
const postsBtn = document.getElementById('posts-button');
const repliesBtn = document.getElementById('replies-button');
const homeBtn = document.getElementById('home-btn');
const profileBtn = document.getElementById('profile-btn');
/*
const replyToTweetBtns = document.querySelectorAll('.reply-button');
*/

const postsDiv = document.querySelector('.user-posts');
const repliesDiv = document.querySelector('.user-replies');
const tweetsDiv = document.querySelector('.tweets-div');
const profileDiv = document.querySelector('.profile-div');
const replyDiv = document.querySelector('.reply');

postsBtn.addEventListener('click', function () {
    if (!repliesDiv.classList.contains('hidden')) {
        repliesDiv.classList.add('hidden');
    }
    postsDiv.classList.toggle('hidden');
})
repliesBtn.addEventListener('click', function () {
    if (!postsDiv.classList.contains('hidden')) {
        postsDiv.classList.add('hidden');
    }
    repliesDiv.classList.toggle('hidden');
})
homeBtn.addEventListener('click', function () {
    if (!profileDiv.classList.contains('hidden')) {
        profileDiv.classList.add('hidden');
    }
    tweetsDiv.classList.remove('hidden');
})
profileBtn.addEventListener('click', function () {
    if (!tweetsDiv.classList.contains('hidden')) {
        tweetsDiv.classList.add('hidden');
    }
    profileDiv.classList.remove('hidden');
})
/*replyToTweetBtns.forEach((replyBtn) => {
    replyBtn.addEventListener('click', function (event) {
            event.preventDefault();

        if (replyDiv.classList.contains('hidden')) {
            replyDiv.classList.remove('hidden');
            // Stop the click event from reaching the body listener
            event.stopPropagation();
        }
    });
})*/
document.body.addEventListener('click', function (event) {
    if (!replyDiv.contains(event.target)) {
        replyDiv.classList.add('hidden');
    }
});


