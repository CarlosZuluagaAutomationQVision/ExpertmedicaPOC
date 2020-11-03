package interactions;

import static utils.enums.EnumVariablesSesion.MENSAJE_DESCARGA_EVALUACION_VERIFICACION;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.fluentlenium.core.annotation.Page;
import userinterface.RipsVerificarCondicionesHogaresPasoUserInterface;

public class ObtenerMensajeDescarga implements Interaction {

  @Page
  RipsVerificarCondicionesHogaresPasoUserInterface ripsVerificarCondicionesHogaresPasoUserInterface;

  public static ObtenerMensajeDescarga deEvaluacion() {
    return Tasks.instrumented(ObtenerMensajeDescarga.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.remember(MENSAJE_DESCARGA_EVALUACION_VERIFICACION.getVariableSesion(),
        ripsVerificarCondicionesHogaresPasoUserInterface.lblDescargaCorrecta.getText());
  }

}
