package questions;

import static userinterface.RipsVerificarCondicionesHogaresPasoUserInterface.CMB_CANTIDAD_100;
import static utils.enums.EnumVariablesSesion.ESTADO_EVALUACION_HOGAR_PASO;

import interactions.ObtenerEstadoEvaluacionVisita;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

@AllArgsConstructor
public class EstadoEvaluacionVisita implements Question<String> {

  private final String hogarPasoEvaluar;

  public static EstadoEvaluacionVisita delHogarPaso(String hogarPasoEvaluar) {
    return new EstadoEvaluacionVisita(hogarPasoEvaluar);
  }


  @Override
  public String answeredBy(Actor actor) {
    actor.attemptsTo(Click.on(CMB_CANTIDAD_100));
    actor.attemptsTo(ObtenerEstadoEvaluacionVisita.hogarPaso(hogarPasoEvaluar));
    return actor.recall(ESTADO_EVALUACION_HOGAR_PASO.getVariableSesion());
  }
}
