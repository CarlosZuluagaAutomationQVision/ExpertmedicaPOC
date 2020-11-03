package tasks;

import static utils.enums.EnumUrls.obtenerUrl;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

@AllArgsConstructor
public class Abrir implements Task {

  private final String nombrePagina;

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Open.url(obtenerUrl(nombrePagina)));
  }

  public static Abrir pagina(String nombrePagina) {
    return Tasks.instrumented(Abrir.class, nombrePagina);
  }

}
