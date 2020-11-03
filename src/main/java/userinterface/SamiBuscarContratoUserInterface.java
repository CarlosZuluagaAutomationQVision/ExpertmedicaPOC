package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class SamiBuscarContratoUserInterface {

  public static final Target CMB_EPS = Target.the("Seleccionar EPS Contrato")
      .located(By.id("select2-SelectPopupEps-container"));
  public static final Target CMB_DEPARTAMENTO = Target.the("Seleccionar Departamento Contrato")
      .located(By.id("select2-SelectPopupDepartamento-container"));
  public static final Target CMB_CIUDAD = Target.the("Seleccionar Ciudad Contrato")
      .located(By.id("select2-SelectPopupCiudad-container"));
  public static final Target TXT_SEDE = Target.the("Campo Busqueda Sede").located(By.id("txtSede"));
  public static final Target CMB_SELECCIONAR_SEDE = Target.the("Seleccionar Sede Contrato")
      .located(By.id("select2-SelectPopupIpsSede-container"));
  public static final Target CMB_CONTRATOS = Target.the("Seleccionar Contrato")
      .located(By.id("select2-SelectPopupContrato-container"));
  public static final Target TXT_DIGITAR_INFORMACION = Target
      .the("Diligenciar Informacion Contrato")
      .located(By.xpath("//input[@class='select2-search__field']"));
  public static final Target BTN_ASIGNAR_CONTRATO = Target.the("Boton Asignar Contrato")
      .located(By.id("btnPopupAsignarContrato"));

  private SamiBuscarContratoUserInterface(){}
}
