package questions;



        import net.serenitybdd.core.pages.ListOfWebElementFacades;
        import net.serenitybdd.screenplay.Question;
        import net.serenitybdd.screenplay.Actor;
        import net.serenitybdd.screenplay.targets.Target;
        import org.openqa.selenium.WebElement;

        import java.util.List;
        import java.util.stream.Collectors;

public class ReadTable implements Question<List<String>> {
    private final Target tableRows;

    public ReadTable(Target tableRows) {
        this.tableRows = tableRows;
    }

    public static ReadTable from(Target tableRows) {
        return new ReadTable(tableRows);
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        // Get all the rows in the table
        ListOfWebElementFacades rows = tableRows.resolveAllFor(actor);

        // Extract and return text from each row
        return rows.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
