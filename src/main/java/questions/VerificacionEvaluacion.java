package questions;

import static utils.enums.EnumVariablesSesion.MENSAJE_DESCARGA_EVALUACION_VERIFICACION;

import interactions.DescargarEvaluacionVerificacion;
import interactions.ObtenerMensajeDescarga;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@AllArgsConstructor
public class VerificacionEvaluacion implements Question<String> {

  private final String hogarPasoEvaluado;


  public static VerificacionEvaluacion paraDescargar(String hogarPasoEvaluado) {
    return new VerificacionEvaluacion(hogarPasoEvaluado);
  }

  @Override
  public String answeredBy(Actor actor) {
    actor.attemptsTo(DescargarEvaluacionVerificacion.deHogaresPaso(hogarPasoEvaluado));
    actor.attemptsTo(ObtenerMensajeDescarga.deEvaluacion());
    return actor.recall(MENSAJE_DESCARGA_EVALUACION_VERIFICACION.getVariableSesion());
  }


}
