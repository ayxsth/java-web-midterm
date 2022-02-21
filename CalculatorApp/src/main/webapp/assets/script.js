const keys = document.querySelectorAll('#calculator span');
const operators = ['+', '-', 'x', '/'];
let decimalAdded = false;
let operatorAdded = false;

keys.forEach((key) => {
    key.onclick = () => {
        const screen = document.querySelector(".screen");

        if (key.innerText === "C") {
            screen.value = "";
            decimalAdded = false;
            operatorAdded = false;
        } else if (key.innerText === ".") {
            if (!decimalAdded) {
                screen.value += key.innerText;
                decimalAdded = true;
            }
        } else if (operators.indexOf(key.innerText) >= 0) {
            if (!operatorAdded) {
                screen.value += ` ${key.innerText + " "}`;
                decimalAdded = false;
                operatorAdded = true;
            }
        } else if (key.innerText === "=") {
            if(screen.value.length > 0) {
                let expression = screen.value.replace("x", "*");

                fetch(`calculate?expression=${encodeURIComponent(expression)}`)
                    .then(res =>
                        res.json()
                    ).then(data => {
                    screen.value = data.result;
                    decimalAdded = false;
                    operatorAdded = false;
                }).catch(e => {
                    console.log({"error": e.message})
                });
            }
        } else {
            screen.value += key.innerText;
            operatorAdded = false;
        }
    }
})