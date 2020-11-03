package stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import questions.ObtenerMensajeValidacion;
import tasks.Abrir;
import tasks.IniciarSesion;

public class InicioSesionStepDefinition {

  @Dado("el usuario {string} ingreso/ingrese a la aplicación de {string} de forma exitosa/fallida")
  public void iniciarSesionExpertmedica(String usuario, String nombrePagina) {
    theActorInTheSpotlight().attemptsTo(Abrir.pagina(nombrePagina));
    theActorInTheSpotlight()
        .attemptsTo(IniciarSesion.enLaPaginaDeExpertmedica(nombrePagina, usuario));
  }

  @Entonces("visualiza el mensaje {string}")
  public void validarMensajeLoguin(String mensajeEsperado) {
    theActorInTheSpotlight().should(
        seeThat(ObtenerMensajeValidacion.despuesDeHacerLoguin(mensajeEsperado),
            equalToIgnoringCase(mensajeEsperado)));
  }

}
