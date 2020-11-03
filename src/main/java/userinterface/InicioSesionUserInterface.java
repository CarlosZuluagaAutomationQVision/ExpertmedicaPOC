package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class InicioSesionUserInterface {

  public static final Target TXT_USUARIO = Target.the("Ingresar Usuario")
      .located(By.id("Username"));
  public static final Target TXT_CONTRASENIA = Target.the("Ingresar Contraseña")
      .located(By.id("Password"));
  public static final Target BTN_ENTRAR_SAMI = Target.the("Boton Entrar SAMI")
      .located(By.xpath("//input[@class='btn btn-primary btn-block']"));
  public static final Target BTN_ENTRAR_RIPS = Target.the("Boton Entrar RIPS")
      .located(By.id("loginbutton"));
  public static final Target LBL_MENSAJE_ERROR_LOGUIN = Target.the("Mensaje error de loguin")
      .located(By.xpath("//p[@style='display: block;']"));

  private InicioSesionUserInterface(){}
}
