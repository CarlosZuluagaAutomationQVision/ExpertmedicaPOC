package tasks;

import static userinterface.RipsEvaluacionesHogaresPasoUserInterface.BTN_NUEVO_EVALUACIO_HOGAR_PASO;
import static userinterface.RipsVerificarCondicionesHogaresPasoUserInterface.CMB_HOGARES_PENDIENTES_POR_EVALUAR_MES;
import static userinterface.RipsVerificarCondicionesHogaresPasoUserInterface.TXT_HOGARES_PENDIENTES_POR_EVALUAR_MES;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

@AllArgsConstructor
public class SeleccionarHogarPaso implements Task {

  private final String hogarPasoEvaluar;

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(BTN_NUEVO_EVALUACIO_HOGAR_PASO),
        Click.on(CMB_HOGARES_PENDIENTES_POR_EVALUAR_MES),
        Click.on(TXT_HOGARES_PENDIENTES_POR_EVALUAR_MES),
        Click
            .on("//ul[@class='chosen-results']//li[contains(text(), '" + hogarPasoEvaluar + "')]"));
  }


  public static SeleccionarHogarPaso pendientePorEvaluar(String hogarPasoEvaluar) {
    return Tasks.instrumented(SeleccionarHogarPaso.class, hogarPasoEvaluar);
  }

}
