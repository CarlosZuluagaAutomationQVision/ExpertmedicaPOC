package tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userinterface.SamiCronogramaUserInterface.BTN_ACEPTAR_REGISTRO_CORRECTO;
import static userinterface.SamiCronogramaUserInterface.BTN_GUARDAR_VISITA;
import static userinterface.SamiCronogramaUserInterface.CBX_FECHA_PROGRAMADA;
import static userinterface.SamiCronogramaUserInterface.CHK_ASIGNAR_VISITA;
import static userinterface.SamiCronogramaUserInterface.TXT_BUSCAR_TIPO_VISITA;
import static userinterface.SamiCronogramaUserInterface.TXT_DESCRIPCION;
import static utils.Esperas.esperarHasta;

import interactions.SeleccionarFechaCalendario;
import java.util.Map;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

@AllArgsConstructor
public class AsignarVisita implements Task {

  private final String tipoVisita;
  private final Map<String, String> mapCaracteristicasContratoVisita;

  @Override
  public <T extends Actor> void performAs(T actor) {
    esperarHasta(2, "segundos");
    actor.attemptsTo(Click.on(TXT_BUSCAR_TIPO_VISITA),
        Enter.theValue(tipoVisita).into(TXT_BUSCAR_TIPO_VISITA),
        Click.on(CHK_ASIGNAR_VISITA), Click.on(CBX_FECHA_PROGRAMADA),
        SeleccionarFechaCalendario.conFecha(mapCaracteristicasContratoVisita.get("Fecha Visita")),
        Click.on(TXT_DESCRIPCION),
        Enter.theValue(mapCaracteristicasContratoVisita.get("Descripcion Visita"))
            .into(TXT_DESCRIPCION),
        Click.on(BTN_GUARDAR_VISITA),
        WaitUntil.the(BTN_ACEPTAR_REGISTRO_CORRECTO, isVisible()).forNoMoreThan(60).seconds(),
        Click.on(BTN_ACEPTAR_REGISTRO_CORRECTO));
  }

  public static AsignarVisita delTipo(String tipoVisita,
      Map<String, String> mapCaracteristicasContratoVisita) {
    return Tasks.instrumented(AsignarVisita.class, tipoVisita, mapCaracteristicasContratoVisita);
  }

}
