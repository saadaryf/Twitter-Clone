document.addEventListener('DOMContentLoaded', function() {
  scrollToBottom();
});
function scrollToBottom() {
  console.log("called");
  const chatContainer = document.querySelector('main');
  chatContainer.scrollTop = chatContainer.scrollHeight;
  // Immediate scroll to the bottom
  chatContainer.scrollIntoView({
    behavior: 'auto',
    block: 'end',
  });
}
