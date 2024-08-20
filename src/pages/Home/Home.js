const modoEscuroIcon = document.getElementById('modoescuro') // Icon do modo escuro, não tirar
const header = document.querySelector('header') // Elemento que será manipulado, nesse caso pegando pelo elemento HTML header
const areaConhecimento = document.getElementById('ac1') 
const areaConhecimento2 = document.getElementById('ac2')
const areaConhecimento3 = document.getElementById('ac3')// Puxando pelo id
const body = document.querySelector('body')

// Verifica se o modo escuro está ativado no sessionStorage
const isModoEscuroAtivado = sessionStorage.getItem('modoEscuro') === 'true';

// Define o estado inicial com base no sessionStorage
if (isModoEscuroAtivado) {
    header.classList.add('dark-mode');
    areaConhecimento.classList.add('dark-mode');
    areaConhecimento2.classList.add('dark-mode');
    areaConhecimento3.classList.add('dark-mode');
    body.classList.add('dark-mode');
}

modoEscuroIcon.addEventListener('click', () => {
    header.classList.toggle('dark-mode');
    areaConhecimento.classList.toggle('dark-mode');
    areaConhecimento2.classList.toggle('dark-mode');
    areaConhecimento3.classList.toggle('dark-mode');
    body.classList.toggle('dark-mode');

    // Salva o estado no sessionStorage
    sessionStorage.setItem('modoEscuro', header.classList.contains('dark-mode'));
    sessionStorage.setItem('modoEscuro', areaConhecimento.classList.contains('dark-mode'));
    sessionStorage.setItem('modoEscuro', areaConhecimento2.classList.contains('dark-mode'));
    sessionStorage.setItem('modoEscuro', areaConhecimento3.classList.contains('dark-mode'));
    sessionStorage.setItem('modoEscuro', body.classList.contains('dark-mode'));
});
