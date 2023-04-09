package testScripts;

import org.junit.jupiter.api.Test;
import constants.todoListConstants;

public class todoListTest extends parentTest{

    /**
     * Adds two new elements to the list and verifys if they were added properly
     */
    @Test
    public void addNewElementsToTheListAndVerify(){
        _todoListSteps.addTaskToList(todoListConstants.buySomeCheeseTask);
        _todoListSteps.addTaskToList(todoListConstants.feedTheCatTask);
        _todoListSteps.verifyItemInTodoList(_todoListSteps.getTodoListElementText(0), todoListConstants.buySomeCheeseTask);
        _todoListSteps.verifyItemInTodoList(_todoListSteps.getTodoListElementText(1), todoListConstants.feedTheCatTask);
        _todoListSteps.verifyNumberOfItemsInTodoList(_todoListSteps.getTodoList(), 2);
    }

    /**
     * Toggles an element on the list and verifys if it has been toggled properly
     */
    @Test
    public void checkElementsOnTheListAndVerify(){
        addNewElementsToTheListAndVerify();
        _todoListSteps.checkElementOnTheList(_todoListSteps.getTodoList(), 0);
        _todoListSteps.verifyIfElementIsToggled(_todoListSteps.getTodoListElementText(0));
    }
}
