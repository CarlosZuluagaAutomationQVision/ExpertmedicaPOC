package tasks;

import static userinterface.RipsUserInterface.LNK_LISTAR_EVALUACIONES_HOGARES_PASO;
import static userinterface.RipsUserInterface.MNU_AUDITORIA_CALIDAD;
import static userinterface.RipsUserInterface.MNU_HOGARES_DE_PASO;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class AccederListas implements Task {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(MNU_AUDITORIA_CALIDAD));
    actor.attemptsTo(Click.on(MNU_HOGARES_DE_PASO));
    actor.attemptsTo(Click.on(LNK_LISTAR_EVALUACIONES_HOGARES_PASO));
  }

  public static AccederListas evaluacionesHogaresPaso() {
    return Tasks.instrumented(AccederListas.class);
  }

}
