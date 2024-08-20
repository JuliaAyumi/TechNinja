//Validação em tempo real do preenchimento do formulario - preveção de erros
//evitar que o formulario recarregue ou o usuario seja direcionado para a pagina de erro
//validaçao e mudança na cor do campo do formulario, e exibir mensagem de erro caso o usuario tente enviar os dados sem preencher corretamente
var senha = document.getElementById('senha');
        var repSenha = document.getElementById('repSenha');
        var passwordError = document.getElementById('passwordError');

        function validatePassword(){
            if(senha.value != repSenha.value) {
                repSenha.classList.add('error');
                passwordError.textContent = 'As senhas não são iguais';
            } else {
                repSenha.classList.remove('error');
                passwordError.textContent = '';
            }
        }

        senha.onchange = validatePassword;
        repSenha.onkeyup = validatePassword;

        var email = document.getElementById('email');
        var emailError = document.getElementById('emailError');
        
        function validateEmail() {
            var xhr = new XMLHttpRequest();
            xhr.open('GET', '/checkEmail?email=' + encodeURIComponent(email.value), true);
            xhr.onload = function() {
                if (xhr.status === 200) {
                    var emailInUse = JSON.parse(xhr.responseText);
                    if (emailInUse) {
                        email.classList.add('error');
                        emailError.textContent = 'O e-mail já está em uso';
                    } else {
                        email.classList.remove('error');
                        emailError.textContent = '';
                    }
                }
            };
            xhr.send();
        }
        
        email.onchange = validateEmail;

        //var form = document.querySelector('form');

//form.addEventListener('submit', function(event) {
    // Verifica se há erros
    //if (email.classList.contains('error') || repSenha.classList.contains('error')) {
        //event.preventDefault();
        //alert('Por favor, corrija os erros antes de enviar o formulário.');
    //}
//});

var form = document.querySelector('form');
var popup = document.getElementById('popup');
var closePopup = document.getElementById('closePopup');

form.addEventListener('submit', function(event) {
    // Verifica se há erros
    if (email.classList.contains('error') || repSenha.classList.contains('error')) {
        event.preventDefault();
        popup.style.display = 'block';
    }
});

closePopup.addEventListener('click', function() {
    popup.style.display = 'none';
});