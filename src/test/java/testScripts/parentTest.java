package testScripts;

import constants.setupConstants;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import stepDefinitions.todoListSteps;


public class parentTest {

    protected WebDriver driver = new ChromeDriver();
    protected todoListSteps _todoListSteps = new todoListSteps(driver);

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver.manage().window().setSize(setupConstants.resolution);
        driver.get(setupConstants.url);
    }

    @AfterEach
    public void tearDown(){
        driver.close();
    }
}
