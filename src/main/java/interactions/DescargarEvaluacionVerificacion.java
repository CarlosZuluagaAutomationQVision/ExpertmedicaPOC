package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.fluentlenium.core.annotation.Page;
import userinterface.RipsVerificarCondicionesHogaresPasoUserInterface;

public class DescargarEvaluacionVerificacion implements Interaction {

  @Page
  RipsVerificarCondicionesHogaresPasoUserInterface ripsVerificarCondicionesHogaresPasoUserInterface;

  private final String hogarPasoEvaluado;

  public DescargarEvaluacionVerificacion(String hogarPasoEvaluado) {
    this.hogarPasoEvaluado = hogarPasoEvaluado;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    for (int i = 0;
        i < ripsVerificarCondicionesHogaresPasoUserInterface.lstHogaresPasoEvaluados.size(); i++) {
      if (ripsVerificarCondicionesHogaresPasoUserInterface.lstHogaresPasoEvaluados.get(i).getText()
          .contains(hogarPasoEvaluado)) {
        actor.attemptsTo(Click.on(ripsVerificarCondicionesHogaresPasoUserInterface
            .retornarWebElementBtnDescargarEvaluacion(i + 1)));
      }
    }
  }

  public static DescargarEvaluacionVerificacion deHogaresPaso(String hogarPasoEvaluado) {
    return Tasks.instrumented(DescargarEvaluacionVerificacion.class, hogarPasoEvaluado);
  }
}
