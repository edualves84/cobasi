package Steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Post extends Base{
    private Base base;


    public Post(Base base) {
        this.base = base;
    }

    @Given("^que eu acesso a cobasi em portugues$")
    public void queEuAcessoACobasiEmPortugues() {
        base.driver.get(base.url);
    }

    @When("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String produto) throws InterruptedException {

        base.driver.switchTo().frame("social-push");

        By byFechaModalReceberOfertas = By.cssSelector("a#btClose");
        WebDriverWait wait = new WebDriverWait(base.driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byFechaModalReceberOfertas));
        base.driver.findElement(byFechaModalReceberOfertas).click();
        base.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        base.driver.switchTo().defaultContent();

        WebElement campoPesquisa = base.driver.findElement(By.name("q"));
        campoPesquisa.sendKeys(produto, Keys.ENTER);


    }

    @And("^e seleciono o produto \"([^\"]*)\"$")
    public void eSelecionoOProduto(String produto)  {

        WebElement elementoproduto = base.driver.findElement(By.linkText(produto));
        elementoproduto.click();

    }

    @Then("^entao exibe \"([^\"]*)\"$")
    public void entaoExibe(String produto )  {
        assertTrue(base.driver.getTitle(). contains(produto));


    }


    }

