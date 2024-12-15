import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    SelenideElement squareA = $("#column-a");
    SelenideElement squareB = $("#column-b");

    @Test
    void moveElementWithActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        squareA.shouldHave(text("A"));
        squareB.shouldHave(text("B"));
        actions().clickAndHold(squareA).moveToElement(squareB).release().build().perform();
        squareA.shouldHave(text("B"));
        squareB.shouldHave(text("A"));
    }

    @Test
    void moveElementWithDragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        squareA.shouldHave(text("A"));
        squareB.shouldHave(text("B"));
        squareA.dragAndDrop(DragAndDropOptions.to("#column-b"));
        squareA.shouldHave(text("B"));
        squareB.shouldHave(text("A"));
    }

}
