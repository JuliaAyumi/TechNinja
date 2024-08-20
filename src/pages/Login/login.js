document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault()

    document.getElementById('error-message').style.display = 'none'

    var email = document.getElementById('email').value
    var password = document.getElementById('password').value

    if (email.trim() === '' || password.trim() === '') {
        displayErrorMessage("Por favor, preencha todos os campos.")
        return
    }
})

function displayErrorMessage(message) {
    let errorMessage = document.getElementById('error-message')
    errorMessage.innerText = message
    errorMessage.style.display = "block"
}