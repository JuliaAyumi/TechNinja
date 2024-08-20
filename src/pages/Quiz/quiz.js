document.addEventListener('DOMContentLoaded', function () {
    const blocosPergunta = document.querySelectorAll('.area-pergunta');

    blocosPergunta.forEach((bloco) => {
        const respostas = bloco.querySelectorAll('.resposta-item');

        respostas.forEach((resposta) => {
            resposta.addEventListener('click', () => {
                const isSelected = resposta.checked;

                respostas.forEach((element) => {
                    if (element !== resposta) {
                        element.checked = false;
                    }
                });
            });
        });
    });
});

function verificarResposta() {
    const blocosPergunta = document.querySelectorAll('.area-pergunta');
    let todasAsRespostasSelecionadas = true;

    blocosPergunta.forEach((bloco) => {
        const respostasSelecionadas = bloco.querySelectorAll('.resposta-item:checked');
        if (respostasSelecionadas.length === 0) {
            todasAsRespostasSelecionadas = false;
        }
    });

    if (todasAsRespostasSelecionadas) {
        alert('Finalizado.');
    } else {
        alert('Por favor, selecione uma resposta em cada bloco antes de avançar.');
    }
}

function verificarSaida() {
    if (confirm("Se você sair, perderá todo o progresso. Deseja continuar?")) {
        window.location.href = "../Quizes/quizes.html";
    }
}