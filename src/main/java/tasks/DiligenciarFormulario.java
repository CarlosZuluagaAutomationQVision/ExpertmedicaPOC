package tasks;

import static userinterface.RipsEvaluacionesHogaresPasoUserInterface.BTN_CONFIRMACION;
import static userinterface.RipsEvaluacionesHogaresPasoUserInterface.BTN_TERMINAR_EVALUACION_VERIFICACION_CONDICIONES_HOGARES_PASO;

import interactions.SeleccionarRespuestas;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

@AllArgsConstructor
public class DiligenciarFormulario implements Task {

  private final String hogarPasoEvaluar;

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(SeleccionarRespuestas.desdeCSV(hogarPasoEvaluar));
    actor.attemptsTo(Click.on(BTN_TERMINAR_EVALUACION_VERIFICACION_CONDICIONES_HOGARES_PASO));
    actor.attemptsTo(Click.on(BTN_CONFIRMACION));
  }

  public static DiligenciarFormulario deEvaluacionHogarPaso(String hogarPasoEvaluar) {
    return Tasks.instrumented(DiligenciarFormulario.class, hogarPasoEvaluar);
  }
}
