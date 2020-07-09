
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.chord;

public class CardOrderTest {

    LocalDatePlusFourDay currentDatePlusFourDay = new LocalDatePlusFourDay();
    public String currentDate = currentDatePlusFourDay.localDate();
    public String selectAll = chord(Keys.CONTROL, "a");
    public Keys del = Keys.DELETE;


    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldSuccessfulMeetingReservationTest() {
        $("[data-test-id=city] input").setValue("Санкт-Петербург");
        $("[class='input__control'][type=tel][maxlength='10']").sendKeys(selectAll, del);
        $("[class='input__control'][type=tel][maxlength='10']").setValue(currentDate);
        $("[class='input__control'][type=text][name=name]").setValue("Иванов Иван");
        $("[data-test-id=phone] input").setValue("+79281234567");
        $("[data-test-id=agreement]").click();
        $$(".form button").find(text("Забронировать")).click();
        $(withText("Успешно!")).waitUntil(visible, 15000);
        $(byText("Встреча успешно забронирована на "+currentDate)).waitUntil(visible, 15000);


    }
}
