package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.Keys.BACK_SPACE;
import static org.openqa.selenium.Keys.CONTROL;

public class AppCardDeliveryTest {

    @Test
    void shouldSendForm(){
        Selenide.open("http://localhost:9999");
        $("[type='text']").setValue("Краснодар");

        LocalDate meetingDate = LocalDate.now().plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dateForInput = meetingDate.format(formatter);
        SelenideElement dateInput = $("[data-test-id='date'] input.input__control");
        dateInput.doubleClick();
        dateInput.sendKeys(BACK_SPACE);
        dateInput.setValue(dateForInput);
        dateInput.shouldHave(Condition.value(dateForInput));

        $("[name='name']").setValue("Мазур Артемий");

        $("[name='phone']").setValue("+78005553535");

        $("label[data-test-id='agreement']").click();

        $(Selectors.withText("Забронировать")).click();

        $(Selectors.withText("Успешно!"))
                .shouldHave(exactText("Успешно!"), Duration.ofSeconds(15))
                .shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

}
