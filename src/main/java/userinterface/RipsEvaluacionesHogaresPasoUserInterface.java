package userinterface;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class RipsEvaluacionesHogaresPasoUserInterface {

  public static final Target BTN_NUEVO_EVALUACIO_HOGAR_PASO = Target
      .the("Boton Nueva Evaluaciones Hogar Paso").located(By.id("addbutton"));
  public static final Target TXT_CANTIDAD_EMPLEADOS = Target
      .the("Cantidad Empleados").located(By.id("nTrabajadores"));
  public static final Target BTN_GUARDAR_CANTIDAD_EMPLEADOS = Target
      .the("Boton Guardar Cantidad Empleados").located(By.id("GuardarHP"));
  public static final Target BTN_ACEPTAR_GUARDAR_CANTIDAD_EMPLEADOS = Target
      .the("Boton Aceptar Guardar Cantidad Empleados")
      .located(By.xpath("//button[@class='swal2-confirm swal2-styled']"));
  public static final Target TXT_RESPONSABLE_NUEVO_ITEM = Target
      .the("Responsable Nuevo Item Proceso Evaluacion Hogares Paso")
      .located(By.id("txtResponsable"));
  public static final Target TXT_OBSERVACIONES_NUEVO_ITEM = Target
      .the("Observaciones Nuevo Item Proceso Evaluacion Hogares Paso")
      .located(By.id("txtObservaciones"));
  public static final Target TXT_ACTIVIDAD_NUEVO_ITEM = Target
      .the("Actividad Nuevo Item Proceso Evaluacion Hogares Paso")
      .located(By.id("txtActividad"));
  public static final Target CAL_PRIMER_SEGUIMIENTO_NUEVO_ITEM = Target
      .the("Fecha Primer Seguimiento Nuevo Item Proceso Evaluacion Hogares Paso")
      .located(By.id("txtFecha"));
  public static final Target BTN_GUARDAR_SEGUIMIENTO_NUEVO_ITEM = Target
      .the("Boton Guardar Seguimiento Nuevo Item Proceso Evaluacion Hogares Paso")
      .located(By.id("modalGuardarPM"));
  public static final Target BTN_CONFIRMACION = Target
      .the("Boton Confirmacion Guardar Seguimiento Nuevo Item Proceso Evaluacion Hogares Paso")
      .located(By.xpath("//button[@class='swal2-confirm swal2-styled']"));
  public static final Target BTN_TERMINAR_EVALUACION_VERIFICACION_CONDICIONES_HOGARES_PASO = Target
      .the("Boton Terminar Evaluacion").located(By.id("btnTerminar"));

  private RipsEvaluacionesHogaresPasoUserInterface(){}
}
