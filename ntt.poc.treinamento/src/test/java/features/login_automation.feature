Feature: Login Automation


  Scenario: Validar login sem sucesso
    Given eu acesso a pagina ultimate qa
    And  escolho a tela para realizar o teste: "LOGIN_AUTOMATION"
    When eu digito o email com formato incorreto: "hugo.com"
    Then valido que apareceu a mensagem de email incorreto "Please enter a valid email address"