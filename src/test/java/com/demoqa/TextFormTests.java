package com.demoqa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextFormTests extends TestBase {
    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue("Captain");
        $("#lastName").setValue("America");
        $("#userEmail").setValue("dodo@pizza.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8900123456");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2023");
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("5th Avenue");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Captain"), text("America"),
                text("dodo@pizza.com"), text("Male"), text("8900123456"), text("30 May,2023"),
                text("8900123456"), text("Maths"), text("Sports"), text("1.png"), text("5th Avenue"),
                text("NCR Delhi"));
    }
}
