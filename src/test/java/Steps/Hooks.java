package Steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks extends Base{

    private Base base;

    public Hooks(Base base) {


        this.base = base;
    }
    @Before
    public void iniciar(){

        System.setProperty("webdriver.chrome.driver", "drivers/chrome/90/chromedriver.exe");
        base.driver = new ChromeDriver();
        base.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        base.driver.manage().window().maximize();
        base.driver.manage().window().setSize(new Dimension(1456, 876));
    }
    @After
    public void finalizar(){
        base.driver.quit();

    }
}
