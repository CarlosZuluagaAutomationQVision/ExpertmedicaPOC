package interactions;

import static utils.enums.EnumVariablesSesion.ESTADO_EVALUACION_HOGAR_PASO;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.fluentlenium.core.annotation.Page;
import userinterface.RipsVerificarCondicionesHogaresPasoUserInterface;

public class ObtenerEstadoEvaluacionVisita implements Interaction {

  @Page
  RipsVerificarCondicionesHogaresPasoUserInterface ripsVerificarCondicionesHogaresPasoUserInterface;

  private final String hogarPasoEvaluar;

  public ObtenerEstadoEvaluacionVisita(String hogarPasoEvaluar) {
    this.hogarPasoEvaluar = hogarPasoEvaluar;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    for (int i = 0;
        i < ripsVerificarCondicionesHogaresPasoUserInterface.lstHogaresPasoEvaluados.size(); i++) {
      if (ripsVerificarCondicionesHogaresPasoUserInterface.lstHogaresPasoEvaluados.get(i).getText()
          .contains(hogarPasoEvaluar)) {
        actor.remember(ESTADO_EVALUACION_HOGAR_PASO.getVariableSesion(),
            obtenerTextoEstadoEvaluacion(i + 1));
        break;
      }
    }
  }

  public String obtenerTextoEstadoEvaluacion(int posicionHogarPaso) {
    return ripsVerificarCondicionesHogaresPasoUserInterface
        .retornarWebElementEstadoEvaluacion(posicionHogarPaso).getText();
  }

  public static ObtenerEstadoEvaluacionVisita hogarPaso(String hogarPasoEvaluar) {
    return Tasks.instrumented(ObtenerEstadoEvaluacionVisita.class, hogarPasoEvaluar);
  }
}
