package stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Setup {

  @Before
  public void configurarActor() {
    OnStage.setTheStage(new OnlineCast());
    theActorCalled("Usuario Expertmedica");
  }
}
