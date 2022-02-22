const $textField = document.querySelector("#username");
const $validFeedback = document.querySelector(".valid-feedback");

$textField.addEventListener("keyup", (e) => {
    if (e.target.value.length > 0) {
        $textField.classList.add("is-valid");
        $validFeedback.removeAttribute("hidden");
    } else {
        $textField.classList.remove("is-valid");
        $validFeedback.setAttribute("hidden", "hidden");
    }
});


