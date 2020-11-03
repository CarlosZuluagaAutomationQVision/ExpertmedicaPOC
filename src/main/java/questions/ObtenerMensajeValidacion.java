package questions;

import static userinterface.InicioSesionUserInterface.LBL_MENSAJE_ERROR_LOGUIN;
import static userinterface.SamiUserInterface.LBL_SAMI;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@AllArgsConstructor
public class ObtenerMensajeValidacion implements Question<String> {

  private final String mensajeEsperado;

  public static ObtenerMensajeValidacion despuesDeHacerLoguin(String mensajeEsperado) {
    return new ObtenerMensajeValidacion(mensajeEsperado);
  }

  @Override
  public String answeredBy(Actor actor) {
    return "Sami".equalsIgnoreCase(mensajeEsperado) ?
        LBL_SAMI.resolveFor(actor).getText() :
        LBL_MENSAJE_ERROR_LOGUIN.resolveFor(actor).getText();
  }
}
