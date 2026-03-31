
Olimpíada de Questões - Refatoração SOLID
Este projeto foi refatorado para deixar de ser uma "Classe Única" e passar a seguir princípios de SOLID, focando na separação de responsabilidades.

1. Separação de Responsabilidades (SRP)
A lógica que antes ficava toda na classe App foi distribuída em Serviços Especialistas:
ParticipanteService: Único responsável por gerenciar a lista e o cadastro de participantes.
ProvaService: Centraliza a criação de provas e o vínculo das questões.
ExecucaoService: Orquestra o fluxo de aplicação da prova, coleta de respostas e geração de tentativas.
-----------------------------------------------------------------------------------------------------------------------------

2. Coesão Aumentada
Lógica de Tabuleiro: O método imprimirTabuleiro() foi movido para dentro da classe Questao. Se a questão tem um FEN (tabuleiro de xadrez), ela mesma sabe como se desenhar.
Cálculo de Nota: A lógica de contar acertos foi movida para a classe Tentativa, que agora possui o método calcularNota().
Adiçao para printar na tela quando acertasse a Questao

-------------------------------------------------------------------------------------------------------------------------------------------------
3. Robustez no Fluxo
Early Return: Aplicado em validações (ex: nomes vazios ou IDs inválidos) para evitar o aninhamento excessivo de if/else.
Proteção de Entrada: Tratamento no Scanner para evitar erros caso o usuário pressione "Enter" sem digitar nada (proteção contra StringIndexOutOfBoundsException).
---------------------------------------------------------------------------------------------------------------------------------------------


Conceitos utilizados do SOLID
SRP (Single Responsibility Principle): A classe App agora apenas orquestra o menu. A lógica de negócio foi movida para ParticipanteService, ProvaService e ExecucaoService.

DIP (Dependency Inversion Principle): Os serviços recebem suas dependências (como o Scanner) via construtor, facilitando testes e manutenção.
-------------------------------------------------------------------------------
Observaçoes parciais 
/// Foi necessário alterar a versão do JDK para 23 no arquivo pom.xml para que o projeto funcionasse corretamente na máquina local.
