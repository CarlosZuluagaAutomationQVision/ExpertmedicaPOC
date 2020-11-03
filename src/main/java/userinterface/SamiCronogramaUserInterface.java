package userinterface;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class SamiCronogramaUserInterface {

  public static final Target LNK_NUEVO_CRONOGRAMA = Target.the("Agregar Nuevo Cronograma")
      .located(By.xpath(".//*[@class='fa fa-plus icon-title']"));
  public static final Target BTN_ACEPTAR_RECOMENDACION_CRONOGRAMA = Target
      .the("Boton Aceptar Recomendación Nuevo Cronograma")
      .located(By.xpath("//button[@class='confirm']"));
  public static final Target BTN_BUSCAR_CONTRATO = Target.the("Boton Buscar Contrato")
      .located(By.id("btnSearchContratoBuscar"));
  public static final Target TXT_BUSCAR_TIPO_VISITA = Target.the("Campo Busqueda Tipo Visita")
      .located(By.xpath("//div//input[@class='form-control input-sm']"));
  public static final Target CHK_ASIGNAR_VISITA = Target.the("Seleccionar Asignar Visita")
      .located(By.xpath("//i[@class='fa']"));
  public static final Target CBX_FECHA_PROGRAMADA = Target.the("Desplegar Calendario")
      .located(By.xpath("//input[@class='form-control datetimepicker ValidarFechasActa']"));
  public static final Target CAL_FECHA_VISITA_MESES = Target.the("Meses Calendario Fechas")
      .located(By.xpath("//div[@class='datepicker-days']//tr//th[@class='datepicker-switch']"));
  public static final Target CAL_FECHA_VISITA_ANIOS = Target.the("Años Calendario Fechas")
      .located(By.xpath("//div[@class='datepicker-months']//tr//th[@class='datepicker-switch']"));
  public static final Target TXT_DESCRIPCION = Target.the("Descripción Visita")
      .located(By.id("Descripcion_190"));
  public static final Target BTN_GUARDAR_VISITA = Target.the("Boton Guardar Visita")
      .located(By.id("btnIngresar"));
  public static final Target BTN_ACEPTAR_REGISTRO_CORRECTO = Target.the("Boton Aceptar Resgistro Visita")
      .located(By.xpath("//button[@class='confirm']"));

  private SamiCronogramaUserInterface(){}
}
