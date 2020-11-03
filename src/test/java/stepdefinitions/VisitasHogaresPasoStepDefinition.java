package stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static userinterface.RipsEvaluacionesHogaresPasoUserInterface.BTN_GUARDAR_CANTIDAD_EMPLEADOS;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import java.util.Map;
import net.serenitybdd.screenplay.actions.Click;
import questions.EstadoEvaluacionVisita;
import questions.VerificacionEvaluacion;
import questions.VerificacionMensaje;
import tasks.AccederListas;
import tasks.AsignarContratoCronograma;
import tasks.AsignarVisita;
import tasks.DiligenciarCantidad;
import tasks.DiligenciarFormulario;
import tasks.IngresarModulo;
import tasks.SeleccionarHogarPaso;

public class VisitasHogaresPasoStepDefinition {

  @Cuando("programe una visita de {string} con las características")
  public void programarVisita(String tipoVisita,
      Map<String, String> mapCaracteristicasContratoVisita) {
    theActorInTheSpotlight().attemptsTo(IngresarModulo.cronograma());
    theActorInTheSpotlight()
        .attemptsTo(AsignarContratoCronograma.conParametros(mapCaracteristicasContratoVisita));
    theActorInTheSpotlight()
        .attemptsTo(AsignarVisita.delTipo(tipoVisita, mapCaracteristicasContratoVisita));
  }

  @Cuando("realice la verificación de condiciones para el hogar de paso {string} el cual cuenta con {string} empleados")
  public void realizarVerificacionCondicionesHogarPaso(String hogarPasoEvaluar,
      String cantidadEmpleados) {
    theActorInTheSpotlight().attemptsTo(AccederListas.evaluacionesHogaresPaso());
    theActorInTheSpotlight().attemptsTo(SeleccionarHogarPaso.pendientePorEvaluar(hogarPasoEvaluar));
    theActorInTheSpotlight()
        .attemptsTo(DiligenciarCantidad.deEmpleadosHogarPaso(cantidadEmpleados));
    theActorInTheSpotlight()
        .attemptsTo(DiligenciarFormulario.deEvaluacionHogarPaso(
            hogarPasoEvaluar.replaceAll(" ", "_").replace("-", "").replace("(", "")
                .replace(")", "").replace(".", "")));
  }

  @Cuando("pretenda realizar la verificación de condiciones para el hogar de paso {string} sin diligenciar la cantidad de empleados del establecimiento")
  public void realizarVerificacionCondicionesHogarPaso(String hogarPasoEvaluar) {
    theActorInTheSpotlight().attemptsTo(AccederListas.evaluacionesHogaresPaso());
    theActorInTheSpotlight().attemptsTo(SeleccionarHogarPaso.pendientePorEvaluar(hogarPasoEvaluar));
    theActorInTheSpotlight().attemptsTo(Click.on(BTN_GUARDAR_CANTIDAD_EMPLEADOS));
  }

  @Entonces("puede visualizar la visita del hogar de paso {string} en estado {string}")
  public void validarEstadoVisita(String hogarPasoEvaluado, String estadoEsperado) {
    theActorInTheSpotlight().should(
        seeThat(EstadoEvaluacionVisita.delHogarPaso(hogarPasoEvaluado),
            equalToIgnoringCase(estadoEsperado)));
  }

  @Entonces("puede descargar la evaluación generada del hogar de paso {string} visualizando el mensaje {string}")
  public void generarResultadoEvaluacionVisita(String hogarPasoEvaluado, String msjValidacion) {
    theActorInTheSpotlight().should(
        seeThat(VerificacionEvaluacion.paraDescargar(hogarPasoEvaluado),
            equalToIgnoringCase(msjValidacion)));
  }

  @Cuando("se tenga una visita programada para el hogar de paso {string} que tenga una evaluación de condiciones diligenciada inferior a un año")
  public void seleccionarVisitaProgramadaRepetida(String nombreHogarPaso) {
    theActorInTheSpotlight().attemptsTo(AccederListas.evaluacionesHogaresPaso());
    theActorInTheSpotlight().attemptsTo(SeleccionarHogarPaso.pendientePorEvaluar(nombreHogarPaso));
  }

  @Entonces("puede visualizar el mensaje {string}")
  public void evaluarMensajeInformativo(String mensajeEsperado) {
    theActorInTheSpotlight().should(
        seeThat(VerificacionMensaje.evaluacionHogarPasoDuplicada(),
            equalToIgnoringCase(mensajeEsperado)));
  }

}
