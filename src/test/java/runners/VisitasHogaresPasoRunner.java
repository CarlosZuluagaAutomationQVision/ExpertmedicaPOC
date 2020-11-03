package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/visitas_hogares_de_paso.feature",
    glue = "stepdefinitions")

public class VisitasHogaresPasoRunner {}
