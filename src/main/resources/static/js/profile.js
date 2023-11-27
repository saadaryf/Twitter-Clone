
const postsBtn = document.getElementById('posts-button');
const repliesBtn = document.getElementById('replies-button');
const homeBtn = document.getElementById('home-btn');
const profileBtn = document.getElementById('profile-btn');
const messageBtn = document.getElementById('message-button');

const postsDiv = document.querySelector('.user-posts');
const repliesDiv = document.querySelector('.user-replies');
const tweetsDiv = document.querySelector('.tweets-div');
const profileDiv = document.querySelector('.profile-div');
const userTab = document.querySelector('.users-tab');

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
    if (!userTab.classList.contains('hidden')) {
        userTab.classList.add('hidden');
    }
    tweetsDiv.classList.remove('hidden');
})
profileBtn.addEventListener('click', function () {
    if (!tweetsDiv.classList.contains('hidden')) {
        tweetsDiv.classList.add('hidden');
    }
    if (!userTab.classList.contains('hidden')) {
        userTab.classList.add('hidden');
    }
    profileDiv.classList.remove('hidden');
})
messageBtn.addEventListener('click', function () {
    if (!tweetsDiv.classList.contains('hidden')) {
        tweetsDiv.classList.add('hidden');
    }
    if (!profileDiv.classList.contains('hidden')) {
        profileDiv.classList.add('hidden');
    }
    userTab.classList.remove('hidden');
})
