package interactions;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterface.SamiCronogramaUserInterface.CAL_FECHA_VISITA_ANIOS;
import static userinterface.SamiCronogramaUserInterface.CAL_FECHA_VISITA_MESES;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

@AllArgsConstructor
public class SeleccionarFechaCalendario implements Interaction {

  private final String fechaVisita;

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(CAL_FECHA_VISITA_MESES));
    actor.attemptsTo(Click.on(CAL_FECHA_VISITA_ANIOS));
    actor.attemptsTo(Click
        .on("//div[@class='datepicker-years']//span[contains(text(), '" + obtenerDatoFecha(
            fechaVisita, "año") + "')]"));
    actor.attemptsTo(Click
        .on("//div[@class='datepicker-months']//span[contains(text(), '" + obtenerDatoFecha(
            fechaVisita, "mes") + "')]"));
    actor.attemptsTo(Click
        .on("//div[@class='datepicker-days']//tr//td[@class='day' and contains(text(), '"
            + obtenerDatoFecha(fechaVisita, "día") + "')]"));
  }

  public String obtenerDatoFecha(String fechaVisita, String datoObtener) {
    String[] datoRetornar = fechaVisita.split("/", 3);
    if ("día".equalsIgnoreCase(datoObtener)) {
      return datoRetornar[0];
    }
    return ("mes".equalsIgnoreCase(datoObtener)) ?
        datoRetornar[1] : datoRetornar[2];
  }

  public static SeleccionarFechaCalendario conFecha(String fechaVisita) {
    return instrumented(SeleccionarFechaCalendario.class, fechaVisita);
  }

}
