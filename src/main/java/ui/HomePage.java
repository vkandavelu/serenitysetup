package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target WELCOME_BANNER = Target.the("Example Domains")
            .located(By.xpath("/html/body/div/h1"));

    public static final Target CLICK_MOREINFOLINNK = Target.the("Example Domains")
            .located(By.xpath("//html/body/div/p[2]/a"));
}
