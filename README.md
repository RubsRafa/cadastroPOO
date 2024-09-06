# Projeto de Cadastro em Modo Texto
Este projeto em Java é um sistema de cadastro simples que permite gerenciar entidades de Pessoas Físicas e Pessoas Jurídicas. As funcionalidades incluem a adição, modificação, exclusão, exibição e persistência de dados de pessoas. O projeto é baseado em uma interface de linha de comando (CLI).

O [relatório de práticas](https://github.com/user-attachments/files/16911007/projeto1mundo3.odp) foi confeccionado em formato PDF e produzido em conjunto com o desenvolvimento do projeto.

### Funcionalidades
O sistema permite realizar as seguintes operações:

- Incluir - Adiciona uma nova pessoa (Física ou Jurídica) ao sistema.
- Alterar - Modifica os dados de uma pessoa existente.
- Excluir - Remove uma pessoa pelo seu ID.
- Exibir pelo ID - Mostra os dados de uma pessoa específica pelo seu ID.
- Exibir todos - Exibe todas as pessoas cadastradas.
- Salvar dados - Persiste os dados de Pessoas Físicas e Jurídicas em arquivos binários.
- Recuperar dados - Recupera os dados salvos a partir de arquivos binários.
- Sair - Finaliza a execução do programa.

### Como executar o projeto
#### Pré-requisitos
- Java 17 ou superior instalado.
- Um ambiente de desenvolvimento como NetBeans ou Eclipse, ou o terminal para execução.

#### Passos para execução
1. Clone este repositório:

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
```

2. Compile o projeto:

```bash
javac src/cadastropoo/CadastroPOO.java
```
3. Execute o projeto:

```bash
java src/cadastropoo/CadastroPOO
```

### Estrutura do projeto
O projeto contém as seguintes classes principais:

- CadastroPOO: Classe principal que contém o método main e controla a interação com o usuário.
- PessoaFisicaRepo e PessoaJuridicaRepo: Repositórios que gerenciam as listas de pessoas físicas e jurídicas.
- PessoaFisica e PessoaJuridica: Classes que representam os objetos cadastráveis (Pessoas Físicas e Jurídicas).

### Operações detalhadas
#### Incluir
O usuário pode incluir uma nova pessoa, seja Física ou Jurídica, informando dados como ID, nome, CPF/CNPJ e idade (para pessoas físicas).

#### Alterar
Permite ao usuário modificar os dados de uma pessoa existente, utilizando o ID para localizá-la.

#### Excluir
Remove uma pessoa do sistema com base no ID fornecido.

#### Exibir
Exibe os dados de uma pessoa ou de todas as pessoas cadastradas no sistema.

#### Salvar e Recuperar
O usuário pode salvar os dados em arquivos binários e, posteriormente, recuperá-los para continuar a operação.

### Exceções tratadas
- IOException: Tratada nas operações de salvar e recuperar arquivos.
- InputMismatchException: Tratada para garantir a entrada correta de dados.

### Tecnologias utilizadas
- Java 17 ou superior
- Ambiente de desenvolvimento NetBeans (opcional)
