package StepsDefinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepsLogin {
    WebDriver driver = null;

    @Given("Me encuentro en la pagina de Login")
    public void estoy_pagina_Login() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/login");
    }

    @When("Ingreso mis credenciales correctamente")
    public void ingreso_credenciales_correctamente() throws InterruptedException {
        wait(2000);
        driver.findElement(By.name("email")).sendKeys("pruebita@gmail.com");
        driver.findElement(By.name("password")).sendKeys("clave123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("Visualizo la pagina principal")
    public void Visualizo_pagina_principal() {
        // Esperamos que salga la  página principal
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(., 'Logged in as Johao')]")));

        // Verifica la presencia del texto
        WebElement loggedInElement = driver.findElement(By.xpath("//a[contains(., 'Logged in as')]"));
        Assert.assertTrue("La página principal no se está visualizando", loggedInElement.isDisplayed());
    }

    @When("Ingreso mis credenciales incorrectamente")
    public void ingreso_credenciales_incorrectamente() throws InterruptedException {
        wait(2000);
        driver.findElement(By.name("email")).sendKeys("user@example.com");
        driver.findElement(By.name("password")).sendKeys("errorPassword");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("Visualizo un mensaje de error")
    public void visualizo_mensaje_error() {
        //Esperamos que salga el mensaje
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Your email or password is incorrect!')]")));

        // Verifica la presencia del mensaje
        WebElement errorMessage = driver.findElement(By.xpath("//p[contains(text(), 'Your email or password is incorrect!')]"));
        Assert.assertTrue("El mensaje de error de logueo no está presente", errorMessage.isDisplayed());
    }


}
