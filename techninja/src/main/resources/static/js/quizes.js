// Obtendo o email logado da sessão
const logedEmail = document.getElementById('logedEmail').dataset.email;
console.log(logedEmail);

// Obtendo os parâmetros da URL
const urlParams = new URLSearchParams(window.location.search);
const difficulty = urlParams.get('difficulty');
const theme = urlParams.get('theme');

// Fazendo a requisição para o endpoint do quiz
fetch(`http://localhost:8080/quiz?difficulty=${difficulty}&theme=${theme}`)
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        if (!Array.isArray(data)) {
            throw new Error('Os dados retornados pelo endpoint do quiz não são um array');
        }
        const quizContainer = document.getElementById('quiz-container');
        data.forEach((questionData, index) => {
            if (!questionData.question || !questionData.answers) {
                throw new Error('Uma das perguntas não tem pergunta ou respostas');
            }

            // Criação do bloco de pergunta
            const questionBlock = document.createElement('div');
            questionBlock.className = 'question-block';
            questionBlock.textContent = questionData.question;
            quizContainer.appendChild(questionBlock);

            // Criação do bloco de respostas
            const answersBlock = document.createElement('div');
            answersBlock.className = 'answers-block';

            questionData.answers.forEach((answer, answerIndex) => {
                const answerDiv = document.createElement('div');
                answerDiv.className = 'resposta-item';
                const answerRadio = document.createElement('input');
                answerRadio.type = 'radio';
                answerRadio.name = `question-${index}`;
                answerRadio.value = answerIndex;
                answerDiv.appendChild(answerRadio);
                answerDiv.appendChild(document.createTextNode(answer));
                answersBlock.appendChild(answerDiv);
            });

            quizContainer.appendChild(answersBlock);
        });

        const finishButton = document.createElement('button');
        finishButton.textContent = 'Finalizar Quiz';
        
        // Adicione um evento de clique ao botão 'Finalizar Quiz'
        finishButton.addEventListener('click', function() {
            // Calcule a pontuação
            var score = 0;
            data.forEach((questionData, index) => {
                var selectedAnswer = document.querySelector(`input[name="question-${index}"]:checked`);
                if (selectedAnswer && questionData.correctAnswer === parseInt(selectedAnswer.value)) {
                    score++;
                }
            });
        
            // Armazene a pontuação, o logedEmail, a dificuldade e o tema do quiz no localStorage
            localStorage.setItem(`quiz-completed-${difficulty}-${theme}`, 'true');
            localStorage.setItem(`quiz-score-${difficulty}-${theme}`, score);
            localStorage.setItem(`quiz-email-${difficulty}-${theme}`, logedEmail);
            

            // Redirecione para a página quiz1.html
            window.location.href = 'quiz1';
        });
        
        // Adicione o botão 'finishButton' a algum elemento do DOM
        document.body.appendChild(finishButton);
        
        // Verifique o status de conclusão do quiz quando a página for carregada
        window.onload = function() {
            const isCompleted = localStorage.getItem(`quiz-completed-${difficulty}-${theme}`);
            if (isCompleted) {
                // Se o quiz foi concluído, desative o botão 'Finalizar Quiz'
                finishButton.disabled = true;
            }
        };
        finishButton.addEventListener('click', function() {
            var quizData = {
                completed: localStorage.getItem(`quiz-completed-${difficulty}-${theme}`),
                score: localStorage.getItem(`quiz-score-${difficulty}-${theme}`),
                email: localStorage.getItem(`quiz-email-${difficulty}-${theme}`)
            };
            fetch('/saveQuiz', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(quizData)
            });
        });
    });

    //Implementar função que fecha o quiz ao concluir, Corrigir Erro de busca de dados do usuarios
    