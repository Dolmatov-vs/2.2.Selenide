package ru.netology;

//public class AutoCompletionTest {
//
//    @Test
//    void shouldSuccessfulMeetingReservationTest() {
//        open("http://localhost:9999");
//        $("[data-test-id=city] input").sendKeys("с", "п");
//        $$(".menu-item__control").find(text("Санкт-Петербург")).click();
//        $(".icon_name_calendar").click();
//
//        String dayStr = $(".calendar__day_state_today").getText();
//        Integer dayInt = new Integer(dayStr);
//        dayInt = dayInt + 7;
//        dayStr = Integer.toString(dayInt);
//        $$(".calendar__day").find(text(dayStr)).click();
//
//        $("[data-test-id=name] input").setValue("Иванов Иван");
//        $("[data-test-id=phone] input").setValue("+79281234567");
//        $("[data-test-id=agreement]").click();
//        $$(".form button").find(text("Забронировать")).click();
//        $(withText("Успешно!")).waitUntil(visible, 15000);
//        $("[data-test-id=notification]").shouldHave(text("Встреча успешно забронирована на"));
//        $("[data-test-id=notification]").shouldHave(text(currentDate));
//    }
//}
