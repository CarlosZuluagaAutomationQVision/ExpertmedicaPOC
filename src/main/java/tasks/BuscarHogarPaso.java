package tasks;

import interactions.ObtenerEstadoEvaluacionVisita;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

@AllArgsConstructor
public class BuscarHogarPaso implements Task {

  private final String hogarPasoEvaluar;

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(ObtenerEstadoEvaluacionVisita.hogarPaso(hogarPasoEvaluar));
  }

  public static BuscarHogarPaso porNombre(String hogarPasoEvaluar, String estadoVisita) {
    return Tasks.instrumented(BuscarHogarPaso.class, hogarPasoEvaluar, estadoVisita);
  }


}
