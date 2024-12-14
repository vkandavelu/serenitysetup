package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateToHomePage implements Task {

    private final String url;

    public NavigateToHomePage(String url) {
        this.url = url;
    }

    @Override
    @Step("{0} navigates to the homepage")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }

    public static NavigateToHomePage at(String url) {
        return new NavigateToHomePage(url);
    }
}
