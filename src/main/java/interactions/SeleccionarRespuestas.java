package interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterface.RipsEvaluacionesHogaresPasoUserInterface.BTN_CONFIRMACION;
import static utils.UtilidadesCsv.obtenerDatoContenidoCsv;
import static utils.enums.EnumVariablesSesion.FECHA_PRIMER_SEGUIMIENTO_EVALUACION;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import utils.enums.EnumNombresCsv;

public class SeleccionarRespuestas implements Interaction {

  private final String hogarPasoEvaluar;
  private static final String CODIGO_CRITERIO = "codigoCriterio";

  public SeleccionarRespuestas(String hogarPasoEvaluar) {
    this.hogarPasoEvaluar = hogarPasoEvaluar;
  }


  @Override
  public <T extends Actor> void performAs(T actor) {
    String codigoRespuesta;
    for (int i = 65; i <= 91; i++) {
      codigoRespuesta =
          obtenerDatoContenidoCsv(EnumNombresCsv.valueOf(hogarPasoEvaluar), CODIGO_CRITERIO,
              String.valueOf(i),
              "codigoRespuesta");
      actor.attemptsTo(Click.on("//input[@id='Respuesta" + codigoRespuesta + "_" + i + "']"));

      if ("CP".equalsIgnoreCase(codigoRespuesta) || "NC".equalsIgnoreCase(codigoRespuesta)
          || "CPR".equalsIgnoreCase(codigoRespuesta)) {
        actor.attemptsTo(DiligenciarNuevoItemEvaluacion
            .desdeCSV(hogarPasoEvaluar, String.valueOf(i),
                actor.recall(FECHA_PRIMER_SEGUIMIENTO_EVALUACION.getVariableSesion())));
        actor.remember(FECHA_PRIMER_SEGUIMIENTO_EVALUACION.getVariableSesion(),
            obtenerDatoContenidoCsv(EnumNombresCsv.valueOf(hogarPasoEvaluar), CODIGO_CRITERIO,
                String.valueOf(i),
                "primerSeguimiento"));
      } else {
        actor.attemptsTo(Click.on("//*[@id='observacion_" + i + "']"),
            Enter.theValue(
                obtenerDatoContenidoCsv(EnumNombresCsv.valueOf(hogarPasoEvaluar), CODIGO_CRITERIO,
                    String.valueOf(i),
                    "observacion")).into("//*[@id='observacion_" + i + "']")
                .thenHit(Keys.TAB), Click.on(BTN_CONFIRMACION));
      }
    }
  }

  public static SeleccionarRespuestas desdeCSV(String hogarPasoEvaluar) {
    return instrumented(SeleccionarRespuestas.class, hogarPasoEvaluar);
  }
}
