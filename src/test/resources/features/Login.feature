@Login
Feature: Login

  Background: Usuario navegando atraves da home
    Given Desejo acessar a url "http://automationpractice.com/index.php"
    Then Tenho acesso a tela inicial do sistema

   Scenario: Realizar Login com Sucesso
   Given Cadastro um Cliente
   When Acesso a tela de Login
   	And Preencho o Login Valido
   	And Preencho a Senha Valida
   	And Aciono o botao Sign In
   Then O sistema valida os dados e apresenta a mensagem "Welcome to your account. Here you can manage all of your personal information and orders."
   
   Scenario: Realizar Login Invalido
   When Acesso a tela de Login
   	And Preencho o Login Invalido "emailInvalido@emailInvalido.com"
   	And Preencho a Senha Invalida "11223344"
   	And Aciono o botao Sign In
   Then O sistema valida os dados e apresenta a mensagem "Authentication failed."
   
   Scenario: Realizar Login Em Branco
   When Acesso a tela de Login
   	And Aciono o botao Sign In
   Then O sistema valida os dados e apresenta a mensagem "An email address required."
