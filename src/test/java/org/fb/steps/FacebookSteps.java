package org.fb.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fb.pages.HomePage;
import org.fb.pages.MainPage;

public class FacebookSteps {
    MainPage mainPage = new MainPage();
    HomePage homePage = new HomePage();

    @Given("que el usuario abre el navegador web fb")
    public void queElUsuarioAbreElNavegadorWebFb() {
        mainPage.navigateToFacebook();
    }


    @Then("verifica que se muestra la pantalla de inicio de sesion")
    public void verificaQueSeMuestraLaPantallaDeInicioDeSesion() {
        mainPage.verificaPantallaSesion();
    }

    @When("el usuario ingresa usuario_erroneo {string} y contraseña_erronea {string}")
    public void elUsuarioIngresaUsuario_erroneoYContraseña_erronea(String user, String password) {
        mainPage.fillInUser(user);
        mainPage.fillInPassword(password);
        mainPage.ClickOnLogin();
    }

    @Then("debería mostrarse un mensaje de error de autenticacion")
    public void deberíaMostrarseUnMensajeDeErrorDeAutenticacion() {
        mainPage.verificaErrorSesion();
    }

    @When("el usuario ingresa usuario_correcto {string} y contraseña_correcta {string}")
    public void elUsuarioIngresaUsuario_correctoYContraseña_correcta(String user, String password) {
        mainPage.fillInUser(user);
        mainPage.fillInPassword(password);
        mainPage.ClickOnLogin();
    }

    @Then("el usuario deberia iniciar sesion correctamente")
    public void elUsuarioDeberiaIniciarSesionCorrectamente() {
        homePage.verificaInicioSesion();
    }

    @And("el usuario navega a la seccion de Notificaciones")
    public void elUsuarioNavegaALaSeccionDeNotificaciones() {
        homePage.ClickOnNotificacion();
    }

    @And("hace un scroll vertical")
    public void haceUnScrollVertical() {
        homePage.scrollByWeb();
    }

    @And("selecciona una notificacion aleatoria")
    public void seleccionaUnaNotificacionAleatoria() {
        homePage.ClickNoti();
    }

    @When("el usuario da Me gusta al post")
    public void elUsuarioDaMeGustaAlPost() {
        homePage.ClickMegusta();
    }

    @Then("el post deberia reflejar que recibio un Me gusta")
    public void elPostDeberiaReflejarQueRecibioUnMeGusta() {
        homePage.verificaMeGusta();
    }
}
