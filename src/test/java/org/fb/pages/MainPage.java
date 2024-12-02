package org.fb.pages;


import org.junit.Assert;

public class MainPage extends BasePage {

    private String textoInicioFB = "//h2[@class='_8eso']";
    private String email = "email";
    private String pass = "pass";
    private String loginBoton = "//button[@name='login']";
    private String loginError = "//div[@class='_9ay7']";

    public void navigateToFacebook() {
        navigateTo("https://www.facebook.com/");
    }

    public void verificaPantallaSesion() {
        Assert.assertEquals(obtenerTexto(textoInicioFB, "xpath"), "Connect with friends and the world around you on Facebook.");
    }

    public void fillInUser(String user) {
        write(email, "id", user);
    }

    public void fillInPassword(String password) {
        write(pass, "id", password);
    }

    public void ClickOnLogin() {
        clickElement(loginBoton, "xpath");
    }

    public void verificaErrorSesion() {
        Assert.assertEquals(obtenerTexto(loginError, "xpath"), "The email you entered isn’t connected to an account. Find your account and log in.");
    }
}
