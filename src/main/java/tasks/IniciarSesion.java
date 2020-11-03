package tasks;

import static userinterface.InicioSesionUserInterface.BTN_ENTRAR_RIPS;
import static userinterface.InicioSesionUserInterface.BTN_ENTRAR_SAMI;
import static userinterface.InicioSesionUserInterface.TXT_CONTRASENIA;
import static userinterface.InicioSesionUserInterface.TXT_USUARIO;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import utils.enums.EnumUrls;
import utils.enums.EnumUsuarios;

@AllArgsConstructor
public class IniciarSesion implements Task {

  private final String nombrePagina;
  private final String usuario;

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(TXT_USUARIO),
        Enter.theValue(EnumUsuarios.valueOf(usuario).getUsuario()).into(TXT_USUARIO),
        Click.on(TXT_CONTRASENIA),
        Enter.theValue(EnumUsuarios.valueOf(usuario).getClave()).into(TXT_CONTRASENIA),
        Check.whether(nombrePagina.equalsIgnoreCase(EnumUrls.SAMI.getNombrePagina())).andIfSo(
            Click.on(BTN_ENTRAR_SAMI)).otherwise(
            Check.whether(nombrePagina.equalsIgnoreCase(EnumUrls.RIPS.getNombrePagina()))
                .andIfSo(Click.on(BTN_ENTRAR_RIPS))));
  }

  public static IniciarSesion enLaPaginaDeExpertmedica(String nombrePagina,
      String usuario) {
    return Tasks
        .instrumented(IniciarSesion.class, nombrePagina, usuario.toUpperCase().replace(" ", "_"));
  }
}
