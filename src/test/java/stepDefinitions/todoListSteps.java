package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import constants.todoListConstants;

import java.util.List;

public class todoListSteps {

    private final WebDriver _driver;

    public todoListSteps(WebDriver driver){
        this._driver = driver;
    }


    //---ACTIONS
    public void addTaskToList(final String task){
        WebElement input = _driver.findElement(By.cssSelector(todoListConstants.inputCssClass));
        input.sendKeys(task);
        input.sendKeys(Keys.ENTER);
    }

    public void checkElementOnTheList(List<WebElement> listOfElements, int index){
        listOfElements.get(index).findElement(By.className(todoListConstants.todoListElementToggleClassSelector)).click();
    }

    //---ASSERTIONS
    public void verifyItemInTodoList(final String actualString, final String expectedString){
        Assert.assertEquals(expectedString, actualString);
    }

    public void verifyNumberOfItemsInTodoList(List<WebElement> listOfElements, int expectedNumberOfElements){
        Assert.assertEquals(listOfElements.size(), expectedNumberOfElements);
    }

    public void verifyIfElementIsToggled(String element){
        try {
            int index = returnIndexOfElementByName(element);
            if (index > -1) {
                WebElement listItem = _driver.findElements(By.cssSelector(todoListConstants.todoListLiCssSelector)).get(index);
                String actualClass = listItem.getAttribute(todoListConstants.classAttributeString);
                verifyClassAttribute(todoListConstants.completedString, actualClass);
            }
        } catch (ArrayIndexOutOfBoundsException  e) {
            failTest("Failed to verify element name of list item: " + e.getMessage());
        }
    }

    //---HELPERS
    public String getTodoListElementText(int index){
        return _driver.findElements(By.cssSelector(todoListConstants.todoListElementClassSelector)).get(index).getText();
    }

    public List<WebElement> getTodoList(){
        return _driver.findElements(By.cssSelector(todoListConstants.todoListElementClassSelector));
    }
    private void verifyClassAttribute(final String expectedClass, final String actualClass) {
        Assert.assertEquals(expectedClass, actualClass);
    }

    private void failTest(String message) {
        Assert.fail(message);
    }

    private int returnIndexOfElementByName(String name){
        List<WebElement> liElements = _driver.findElements(By.cssSelector(todoListConstants.todoListLiCssSelector));
        int matchingIndex = -1;
        for (int i = 0; i < liElements.size(); i++) {
            if (liElements.get(i).getText().contains(name)) {
                matchingIndex = i;
                return matchingIndex;
            }
        }
        return matchingIndex;
    }
}

