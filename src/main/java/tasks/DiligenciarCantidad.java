package tasks;

import static userinterface.RipsEvaluacionesHogaresPasoUserInterface.BTN_ACEPTAR_GUARDAR_CANTIDAD_EMPLEADOS;
import static userinterface.RipsEvaluacionesHogaresPasoUserInterface.BTN_GUARDAR_CANTIDAD_EMPLEADOS;
import static userinterface.RipsEvaluacionesHogaresPasoUserInterface.TXT_CANTIDAD_EMPLEADOS;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

@AllArgsConstructor
public class DiligenciarCantidad implements Task {

  private final String cantidadEmpleados;

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(TXT_CANTIDAD_EMPLEADOS),
        Enter.theValue(cantidadEmpleados).into(TXT_CANTIDAD_EMPLEADOS),
        Click.on(BTN_GUARDAR_CANTIDAD_EMPLEADOS),
        Click.on(BTN_ACEPTAR_GUARDAR_CANTIDAD_EMPLEADOS));
  }

  public static DiligenciarCantidad deEmpleadosHogarPaso(String cantidadEmpleados) {
    return Tasks.instrumented(DiligenciarCantidad.class, cantidadEmpleados);
  }
}
