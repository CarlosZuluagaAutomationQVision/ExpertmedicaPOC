package userinterface;


import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class RipsVerificarCondicionesHogaresPasoUserInterface extends PageObject {

  public static final Target CMB_HOGARES_PENDIENTES_POR_EVALUAR_MES = Target
      .the("Hogares Pendientes por Evaluar Durante Mes")
      .located(By.xpath("//span[contains(text(), '-- Seleccione --')]"));
  public static final Target TXT_HOGARES_PENDIENTES_POR_EVALUAR_MES = Target
      .the("Buscar Hogares Pendientes por Evaluar Durante Mes")
      .located(By.xpath("//div[@class='chosen-search']"));
  public static final Target LBL_MENSAJE_VISITA_DUPLICADA = Target
      .the("Mensaje evaluación visita generada hace menos de un año")
      .located(By.id("swal2-content"));
  public static final Target CMB_CANTIDAD_VISITAS_MOSTRAR = Target
      .the("Cantidad de visitas a mostrar")
      .located(By.name("TableEvaluacionesHogares_length"));
  public static final Target CMB_CANTIDAD_100 = Target
      .the("Cantidad de visitas a mostrar")
      .located(By.xpath("//*[@id='TableEvaluacionesHogares_length']/label/select/option[4]"));

  @FindBy(xpath = "//div[@class='dataTables_scroll']//tbody//td[4]")
  public List<WebElementFacade> lstHogaresPasoEvaluados;

  @FindBy(xpath = "//div[@class='toast-message']")
  public WebElementFacade lblDescargaCorrecta;

  public WebElementFacade retornarWebElementEstadoEvaluacion(int posicionHogarPaso) {
    return $("//div[@class='dataTables_scroll']//tbody//tr[" + posicionHogarPaso + "]//span");
  }

  public WebElementFacade retornarWebElementBtnDescargarEvaluacion(int posicionHogarPaso) {
    return $("//tbody//tr[" + posicionHogarPaso + "]//button[@title='Descargar Evaluación']");
  }

}
