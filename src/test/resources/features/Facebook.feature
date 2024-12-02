@Facebook
Feature: Autenticación y navegación en Facebook

  @Esceneario01
  Scenario: Iniciar sesión y gestionar notificaciones
    Given que el usuario abre el navegador web fb
    Then verifica que se muestra la pantalla de inicio de sesion
    When  el usuario ingresa usuario_erroneo "pruebas@gmail.com" y contraseña_erronea "123456789"
    Then debería mostrarse un mensaje de error de autenticacion
    When  el usuario ingresa usuario_correcto "997562980" y contraseña_correcta "usuarioseek123"
    Then el usuario deberia iniciar sesion correctamente
    And el usuario navega a la seccion de Notificaciones
    And hace un scroll vertical
    And selecciona una notificacion aleatoria
    When el usuario da Me gusta al post
    Then el post deberia reflejar que recibio un Me gusta

