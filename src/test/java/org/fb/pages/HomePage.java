package org.fb.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {

    JavascriptExecutor js = (JavascriptExecutor) Driver.driver;

    private String textoInicioSesion = "//span[contains(text(),'te damos la bienvenida a Facebook.')]";
    private String notificaciones = "//a[contains(@aria-label, 'Notificaciones')]";
    private String clicNoti = "(//div)[77]";
    private String meGustaBoton = "//div[@class='x1n2onr6 x1ja2u2z x1jx94hy x1qpq9i9 xdney7k xu5ydu1 xt3gfkd x9f619 xh8yej3 x6ikm8r x10wlt62']//div//div[@class='html-div xdj266r x11i5rnm xat24cr x1mh8g0r xexx8yu x4uap5 x18d9i69 xkhd6sd']//div[@class='html-div xdj266r x11i5rnm xat24cr x1mh8g0r xexx8yu x4uap5 x18d9i69 xkhd6sd']//div[@class='html-div xdj266r x11i5rnm xat24cr x1mh8g0r xexx8yu x4uap5 x18d9i69 xkhd6sd']//div//div[@class='xabvvm4 xeyy32k x1ia1hqs x1a2w583 x6ikm8r x10wlt62']//div//div//div//div[@aria-label='Me gusta']//div[@class='x9f619 x1ja2u2z x78zum5 x1n2onr6 x1r8uery x1iyjqo2 xs83m0k xeuugli xl56j7k x6s0dn4 xozqiw3 x1q0g3np xn6708d x1ye3gou xexx8yu xcud41i x139jcc6 x4cne27 xifccgj xn3w4p2 xuxw1ft']";

    private String textoMeGusta = "div[class='x1n2onr6 x1ja2u2z x1jx94hy x1qpq9i9 xdney7k xu5ydu1 xt3gfkd x9f619 xh8yej3 x6ikm8r x10wlt62'] div div[class='html-div xdj266r x11i5rnm xat24cr x1mh8g0r xexx8yu x4uap5 x18d9i69 xkhd6sd'] div[class='html-div xdj266r x11i5rnm xat24cr x1mh8g0r xexx8yu x4uap5 x18d9i69 xkhd6sd'] div[class='html-div xdj266r x11i5rnm xat24cr x1mh8g0r xexx8yu x4uap5 x18d9i69 xkhd6sd'] div div[class='xabvvm4 xeyy32k x1ia1hqs x1a2w583 x6ikm8r x10wlt62'] div div div div[class='x1n2onr6'] div[class='x6s0dn4 xi81zsa x78zum5 x6prxxf x13a6bvl xvq8zen xdj266r xat24cr xkhd6sd x4uap5 x80vd3b x1q0q8m5 xso031l x16n37ib xq8finb x1y1aw1k x10b6aqq'] div[class='x6s0dn4 x78zum5 x1iyjqo2 x6ikm8r x10wlt62'] div span[class='x4k7w5x x1h91t0o x1h9r5lt x1jfb8zj xv2umb2 x1beo9mf xaigb6o x12ejxvf x3igimt xarpa2k xedcshv x1lytzrv x1t2pt76 x7ja8zs x1qrby5j'] div[role='button'] span[class='xt0b8zv x1jx94hy xrbpyxo xl423tq'] span span[class='x1e558r4']";

    public void verificaInicioSesion() {
        Assert.assertTrue(obtenerTexto(textoInicioSesion, "xpath").contains("te damos la bienvenida a Facebook"));
    }

    public void ClickOnNotificacion() {
        waitForSeconds(5);
        clickElement(notificaciones, "xpath");
    }

    public void scrollByWeb() {
        waitForSeconds(5);
        WebElement scrollElement = Driver.getDriver().findElement(By.cssSelector("div.x9f619.x1s85apg.xds687c.xg01cxk.xexx8yu.x18d9i69.x1e558r4.x150jy0e.x47corl.x10l6tqk.x13vifvy.x1n4smgl.x1d8287x.x19991ni.xwji4o3.x1kky2od"));
        Actions actions = new Actions(Driver.getDriver());

// Mover hacia abajo dentro del elemento
        actions.moveToElement(scrollElement)
                .clickAndHold()
                .moveByOffset(0, 250)
                .release()
                .perform();
    }

    public void ClickNoti() {
        waitForSeconds(5);
        clickElement(clicNoti, "xpath");
    }

    public void ClickMegusta() {
        clickElement(meGustaBoton, "xpath");
    }

    public void verificaMeGusta() {
        Assert.assertTrue(obtenerTexto(textoMeGusta, "xpath").contains("Tú"));
    }

}
