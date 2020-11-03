package tasks;

import static userinterface.SamiCronogramaUserInterface.BTN_ACEPTAR_RECOMENDACION_CRONOGRAMA;
import static userinterface.SamiCronogramaUserInterface.LNK_NUEVO_CRONOGRAMA;
import static userinterface.SamiUserInterface.LBL_AUDITORIA_CALIDAD;
import static userinterface.SamiUserInterface.LNK_CRONOGRAMA;
import static utils.Esperas.esperarHasta;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class IngresarModulo implements Task {


  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(LBL_AUDITORIA_CALIDAD), Click.on(LNK_CRONOGRAMA),
        Click.on(LNK_NUEVO_CRONOGRAMA), Click.on(BTN_ACEPTAR_RECOMENDACION_CRONOGRAMA));
    esperarHasta(2, "segundos");
  }


  public static IngresarModulo cronograma() {
    return Tasks.instrumented(IngresarModulo.class);
  }

}
