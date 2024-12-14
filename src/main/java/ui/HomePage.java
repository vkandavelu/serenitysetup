package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target WELCOME_BANNER = Target.the("Examplej Domghhfain")
            .located(By.xpath("/html/body/div/h1"));
}
