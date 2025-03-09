package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppCardDeliveryTest {

    @Test
    void shouldSendForm(){
        Selenide.open("http://localhost:9999");
        $$("form").last().click();
        $("[type='text']").setValue("Краснодар");
        LocalDate date = LocalDate.now();
        date = date.plusDays(2);
        $("[type='tel']").setValue(date.toString());
        $("[name='name']").setValue("Мазур Артемий");
        $("[name='phone']").setValue("+78005553535");
        $("label[data-test-id='agreement']").click();
        $("[type='button").click();
        $(Selectors.withText("Успешно")).should(Condition.visible, Duration.ofSeconds(15));

    }

}
