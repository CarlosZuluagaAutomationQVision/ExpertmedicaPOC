package interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterface.RipsEvaluacionesHogaresPasoUserInterface.BTN_CONFIRMACION;
import static userinterface.RipsEvaluacionesHogaresPasoUserInterface.BTN_GUARDAR_SEGUIMIENTO_NUEVO_ITEM;
import static userinterface.RipsEvaluacionesHogaresPasoUserInterface.CAL_PRIMER_SEGUIMIENTO_NUEVO_ITEM;
import static userinterface.RipsEvaluacionesHogaresPasoUserInterface.TXT_ACTIVIDAD_NUEVO_ITEM;
import static userinterface.RipsEvaluacionesHogaresPasoUserInterface.TXT_OBSERVACIONES_NUEVO_ITEM;
import static userinterface.RipsEvaluacionesHogaresPasoUserInterface.TXT_RESPONSABLE_NUEVO_ITEM;
import static utils.UtilidadesCsv.obtenerDatoContenidoCsv;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import utils.enums.EnumNombresCsv;

public class DiligenciarNuevoItemEvaluacion implements Interaction {

  private final String hogarPasoEvaluar;
  private final String valorCodigoCriterio;
  private final String fechaPrimerSeguimientoDiligenciada;
  private static final String CODIGO_CRITERIO = "codigoCriterio";

  public DiligenciarNuevoItemEvaluacion(String hogarPasoEvaluar, String valorCodigoCriterio,
      String fechaPrimerSeguimientoDiligenciada) {
    this.hogarPasoEvaluar = hogarPasoEvaluar;
    this.valorCodigoCriterio = valorCodigoCriterio;
    this.fechaPrimerSeguimientoDiligenciada = fechaPrimerSeguimientoDiligenciada;
  }


  @Override
  public <T extends Actor> void performAs(T actor) {
    utils.Esperas.esperarHasta(2, "segundos");
    actor.attemptsTo(Click.on(TXT_RESPONSABLE_NUEVO_ITEM), Enter.theValue(
        obtenerDatoContenidoCsv(EnumNombresCsv.valueOf(hogarPasoEvaluar), CODIGO_CRITERIO,
            valorCodigoCriterio,
            "responsable")).into(TXT_RESPONSABLE_NUEVO_ITEM));
    actor.attemptsTo(Click.on(TXT_OBSERVACIONES_NUEVO_ITEM), Enter.theValue(
        obtenerDatoContenidoCsv(EnumNombresCsv.valueOf(hogarPasoEvaluar), CODIGO_CRITERIO,
            valorCodigoCriterio,
            "observaciones")).into(TXT_OBSERVACIONES_NUEVO_ITEM));
    actor.attemptsTo(Click.on(TXT_ACTIVIDAD_NUEVO_ITEM), Enter.theValue(
        obtenerDatoContenidoCsv(EnumNombresCsv.valueOf(hogarPasoEvaluar), CODIGO_CRITERIO,
            valorCodigoCriterio,
            "actividad")).into(TXT_ACTIVIDAD_NUEVO_ITEM));
    if (fechaPrimerSeguimientoDiligenciada == null || !fechaPrimerSeguimientoDiligenciada
        .equalsIgnoreCase(
            obtenerDatoContenidoCsv(EnumNombresCsv.valueOf(hogarPasoEvaluar), CODIGO_CRITERIO,
                valorCodigoCriterio, "primerSeguimiento"))) {
      actor.attemptsTo(Click.on(CAL_PRIMER_SEGUIMIENTO_NUEVO_ITEM),
          SeleccionarFechaCalendario.conFecha(
              obtenerDatoContenidoCsv(EnumNombresCsv.valueOf(hogarPasoEvaluar), CODIGO_CRITERIO,
                  valorCodigoCriterio,
                  "primerSeguimiento")));
    }
    actor.attemptsTo(Click.on(BTN_GUARDAR_SEGUIMIENTO_NUEVO_ITEM));
    utils.Esperas.esperarHasta(2, "segundos");
    actor.attemptsTo(Click.on(BTN_CONFIRMACION));
  }

  public static DiligenciarNuevoItemEvaluacion desdeCSV(String hogarPasoEvaluar,
      String valorCodigoCriterio, String fechaPrimerSeguimientoDiligenciada) {
    return instrumented(DiligenciarNuevoItemEvaluacion.class, hogarPasoEvaluar,
        valorCodigoCriterio, fechaPrimerSeguimientoDiligenciada);
  }
}
