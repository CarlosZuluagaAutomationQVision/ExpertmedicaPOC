package userinterface;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class RipsUserInterface {

  public static final Target MNU_AUDITORIA_CALIDAD = Target.the("Modulo Calidad RIPS")
      .located(By.xpath("//span[@class='nav-label' and contains(text(), 'Calidad')]"));
  public static final Target MNU_HOGARES_DE_PASO = Target.the("Modulo Hogares de Paso")
      .located(
          By.xpath("//*[@id='side-menu']//li//ul//li//a[contains(text(), 'Hogares de paso')]"));
  public static final Target LNK_LISTAR_EVALUACIONES_HOGARES_PASO = Target
      .the("AccederListas Evaluaciones de Hogares de Paso")
      .located(By.xpath("//*[@id='side-menu']/li[4]/ul/li[1]/ul/li/a"));

  private RipsUserInterface(){}
}
