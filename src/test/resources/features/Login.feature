Feature: Login Feature
  Scenario: Login Exitoso
    Given Me encuentro en la pagina de Login
    When Ingreso mis credenciales correctamente
    Then Visualizo la pagina principal

  Scenario: Unsuccessful Login with Incorrect Credentials
    Given Me encuentro en la pagina de Login
    When Ingreso mis credenciales incorrectamente
    Then Visualizo un mensaje de error
