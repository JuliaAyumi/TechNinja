document.getElementById('register-form').addEventListener('submit', function (event) {
    event.preventDefault()

    document.getElementById('error-message').style.display = 'none'

    var name = document.getElementById('name').value
    var email = document.getElementById('email').value
    var password = document.getElementById('password').value
    var confirmPassword = document.getElementById('confirm-password').value

    if (name.trim() === '' || email.trim() === '' || password.trim() === '' || confirmPassword.trim() === '') {
        displayErrorMessage("Por favor, preencha todos os campos.")
        return
    }

    if (password !== confirmPassword) {
        displayErrorMessage("Ambas as senhas devem ser as mesmas.")
        return
    }
})

function displayErrorMessage(message) {
    let errorMessage = document.getElementById('error-message')
    errorMessage.innerText = message
    errorMessage.style.display = "block"
}