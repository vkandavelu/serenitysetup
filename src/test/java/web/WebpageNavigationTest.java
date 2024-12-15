package web;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tasks.NavigateToHomePage;
import questions.IsElementVisible;
import ui.HomePage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SerenityRunner.class)  // Use SerenityRunner to run the test with Serenity BDD
public class WebpageNavigationTest {

    Actor john = Actor.named("John");  // Declare the actor
    WebDriver driver;

    @Before
    public void setup() {
        // Automatically download and set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Initialize the Screenplay actor system
        driver = new ChromeDriver();
        john.can(BrowseTheWeb.with(driver));
        OnStage.setTheStage(new OnlineCast());
    }

    @Test
    public void shouldSeeTheWelcomeBannerOnHomePage() {
        // Arrange: John navigates to the home page
        givenThat(john).wasAbleTo(NavigateToHomePage.at("https://example.com"));

        // Assert: John should see the welcome banner
        System.out.println("Element visibility: " + HomePage.WELCOME_BANNER.resolveFor(john).isVisible());
        then(john).should(seeThat(IsElementVisible.on(HomePage.WELCOME_BANNER), is(true)));

        then(john).attemptsTo(Click.on(HomePage.CLICK_MOREINFOLINNK));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
