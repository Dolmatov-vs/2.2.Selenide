
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
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
        $("[data-test-id=name] input").setValue("Иванов Иван");
        $("[data-test-id=phone] input").setValue("+79281234567");
        $("[data-test-id=agreement]").click();
        $$(".form button").find(text("Забронировать")).click();
        $(withText("Успешно!")).waitUntil(visible, 15000);
        $("[data-test-id=notification]").shouldHave(text("Встреча успешно забронирована на"));
        $("[data-test-id=notification]").shouldHave(text(currentDate));
    }

    @Test
    void shouldWithoutCity(){
        $("[class='input__control'][type=tel][maxlength='10']").sendKeys(selectAll, del);
        $("[class='input__control'][type=tel][maxlength='10']").setValue(currentDate);
        $("[data-test-id=name] input").setValue("Иванов Иван");
        $("[data-test-id=phone] input").setValue("+79281234567");
        $("[data-test-id=agreement]").click();
        $$(".form button").find(text("Забронировать")).click();
        $(".input_invalid[data-test-id=city]").shouldHave(text("Поле обязательно для заполнения"));
        $(".input_invalid[data-test-id=city]").shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
        $(withText("Успешно!")).waitUntil(hidden, 15000);
    }
    @Test
    void shouldWithoutDate(){
        $("[data-test-id=city] input").setValue("Санкт-Петербург");
        $("[class='input__control'][type=tel][maxlength='10']").sendKeys(selectAll, del);
        $("[data-test-id=name] input").setValue("Иванов Иван");
        $("[data-test-id=phone] input").setValue("+79281234567");
        $("[data-test-id=agreement]").click();
        $$(".form button").find(text("Забронировать")).click();
        $(".calendar-input__custom-control").shouldHave(text("Неверно введена дата"));
        $(".calendar-input__custom-control").shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
        $(withText("Успешно!")).waitUntil(hidden, 15000);
    }

    @Test
    void shouldWithoutName(){
        $("[data-test-id=city] input").setValue("Санкт-Петербург");
        $("[class='input__control'][type=tel][maxlength='10']").sendKeys(selectAll, del);
        $("[class='input__control'][type=tel][maxlength='10']").setValue(currentDate);
        $("[data-test-id=phone] input").setValue("+79281234567");
        $("[data-test-id=agreement]").click();
        $$(".form button").find(text("Забронировать")).click();
        $("[data-test-id=name]").shouldHave(text("Поле обязательно для заполнения"));
        $("[data-test-id=name]").shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
        $(withText("Успешно!")).waitUntil(hidden, 15000);
    }

    @Test
    void shouldWithoutTel(){
        $("[data-test-id=city] input").setValue("Санкт-Петербург");
        $("[class='input__control'][type=tel][maxlength='10']").sendKeys(selectAll, del);
        $("[class='input__control'][type=tel][maxlength='10']").setValue(currentDate);
        $("[data-test-id=name] input").setValue("Иванов Иван");
        $("[data-test-id=agreement]").click();
        $$(".form button").find(text("Забронировать")).click();
        $("[data-test-id=phone]").shouldHave(text("Поле обязательно для заполнения"));
        $("[data-test-id=phone]").shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
        $(withText("Успешно!")).waitUntil(hidden, 15000);
    }

    @Test
    void shouldWithoutCheckbox(){
        $("[data-test-id=city] input").setValue("Санкт-Петербург");
        $("[class='input__control'][type=tel][maxlength='10']").sendKeys(selectAll, del);
        $("[class='input__control'][type=tel][maxlength='10']").setValue(currentDate);
        $("[data-test-id=name] input").setValue("Иванов Иван");
        $("[data-test-id=phone] input").setValue("+79281234567");
        $$(".form button").find(text("Забронировать")).click();
        $("[data-test-id=agreement]").shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
        $(withText("Успешно!")).waitUntil(hidden, 15000);
    }
}
