
# Aplicativo de Notas - para fins de estudo

### A aplicação consiste nas seguintes telas:
- Tela de Splash;
- Tela de Login;
- Tela de Home;
- Tela do Editor de nota;

### Requisitos:

#### Tela de Splash
- [] Mostrar ícone do logo da aplicação no centro da tela (dimensões 120dp x 150dp);
- [] A cor de fundo: “#202124”
- [] Mostrar o texto “Tela de Splash” logo abaixo do logo e deve ser Branco(#FFF) e 21sp de tamanho;
- [] Deve ser a primeira tela a ser chamada quando a aplicação é inicializada;
- [] Remover a Actionbar nesta tela;
- [] Permanecer na tela por 1,5 segundos até abrir a tela de Login;

#### Tela de Login
- [] A cor de fundo: “#202124”;
- [] Um ícone do logo da aplicação no topo (dimensões 120dp x 150dp);
- [] Mostrar os campos de entrada de textos para digitar o nome e senha do usuário (com subtítulo);
- [] Os textos devem: branco(#FFF) e com o tamanho de 21sp;
- [] Mostrar um botão para logar na aplicação;
- [] A tela não pode ser visível para outra aplicações;
- [] Deve sair da aplicação quando o usuário voltar a tela;
- [] Ao clicar no botão de logar:
    - [] Verificar se as informações de nome e senha do usuário são válidos (não são vazios);
    - [] Mostrar a mensagem “Nome e senha dos usuário não pode está vazias!” caso não sejam.
    - [] Verificar se a opção de Wi-Fi está habilitada;
    - [] Mostrar a mensagem “Opção de Wi-Fi está desabilitado!” caso não esteja;
    - [] Ir para a tela de Home quando as informações do usuário são autorizada;
    - [] Verificar se o nome é “admin” e a senha é “1234” (isso pode está hard code);
    - [] Mostrar a mensagem “Usuário não autorizado!”
    - [] Ao abrir a tela de Login verificar se há um usuário logado e abrir a tela de Home;

#### Tela de Home
- [] Quando o usuário voltar nesta deve sair da aplicação;
- [] A cor de fundo: “#202124”;
- [] Mostrar um texto no centro “Sem notas!”;
- [] Os textos devem: branco(#FFF) e com o tamanho de 21sp;
- [] Mostrar um botão para criar uma nova nota;
- [] Ao clicar no botão de criar nova nota deve abrir a tela do editor de notas vazia;

#### Tela do Editor de Notas
- [] Cor de Background e app bar: #202124
- [] UI:
    - [] Tem que ter um título e descrição da nota;
    - [] Para nova nota deve mostra o hint; 
    - [] Titulo da Nota, #FFF, 26sp;
    - [] Descrição da Nota, #FFF, 21sp;



