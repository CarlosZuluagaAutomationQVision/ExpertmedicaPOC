package userinterface;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class SamiUserInterface {

  public static final Target LBL_AUDITORIA_CALIDAD = Target.the("Auditoría de Calidad")
      .located(By.xpath("//span[contains(text(), 'Auditoría de Calidad')]"));
  public static final Target LNK_CRONOGRAMA = Target.the("Cronograma")
      .located(By.xpath("/html/body/aside/nav/ul/li[1]/ul/li[4]/a"));
  public static final Target LBL_SAMI = Target.the("Label Sami")
      .located(By.xpath("//span[@class='nav-label' and contains(text(), 'SAMI')]"));

  private SamiUserInterface(){}
}
