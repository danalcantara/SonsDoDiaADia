Aplicativo de Terapia Sonora
Este é um aplicativo Android desenvolvido usando Jetpack Compose que oferece uma variedade de sons ambientais para diferentes fins de relaxamento e foco. O aplicativo é projetado com várias missões, cada uma focando em um tema diferente como "Sono do Bebê", "Foco nos Estudos" e "Yoga e Meditação".

Recursos
Seleção de Missão: Os usuários podem escolher entre diferentes missões para terapia sonora.
Opções de Sons Ambientais: Cada missão oferece uma seleção de sons relaxantes:
Sono do Bebê: Opções incluem "Ruído Branco", "Chuva" e "Vento".
Foco nos Estudos: Opções incluem "Cafeteria", "Floresta" e "Biblioteca".
Yoga e Meditação: Opções incluem "Água Corrente", "Pássaros" e "Vento Suave".
Controle de Som: Os usuários podem selecionar um som, ajustar o volume e definir um temporizador para quanto tempo o som deve tocar.
Visão Geral do Código
MainActivity:
O ponto de entrada principal para o aplicativo. Define a exibição para o SoundTherapyTheme que inclui o AppContent() Composable.

AppContent Composable:
Gerencia as diferentes missões com base na seleção do usuário. Ele alterna dinamicamente entre diferentes telas (BabySleepScreen, StudyFocusScreen, YogaMeditationScreen) com base na missão selecionada.

MissionSelectionScreen:
Exibe os botões de seleção de missão e aciona o callback onMissionSelected quando uma missão é escolhida.

BabySleepScreen, StudyFocusScreen, YogaMeditationScreen:
Cada uma dessas telas exibe um conjunto de sons apropriados para a sua missão, além da capacidade de controlar o volume e o temporizador.

SoundControlScreen:
Esta tela é responsável por exibir as opções de som selecionadas, permitindo ao usuário escolher um som, ajustar seu volume e definir um temporizador para ele. Também mostra o som atualmente selecionado.
