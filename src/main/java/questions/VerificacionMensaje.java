package questions;

import static userinterface.RipsVerificarCondicionesHogaresPasoUserInterface.LBL_MENSAJE_VISITA_DUPLICADA;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificacionMensaje implements Question<String> {


  public static VerificacionMensaje evaluacionHogarPasoDuplicada() {
    return new VerificacionMensaje();
  }

  @Override
  public String answeredBy(Actor actor) {
    return LBL_MENSAJE_VISITA_DUPLICADA.resolveFor(actor).getText();
  }
}
