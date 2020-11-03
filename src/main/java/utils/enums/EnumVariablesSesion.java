package utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumVariablesSesion {

  ESTADO_EVALUACION_HOGAR_PASO("Estado Evaluación Hogar de Paso"),
  FECHA_PRIMER_SEGUIMIENTO_EVALUACION("Fecha Diligenciada Primer Seguimiento Evaluacion Hogar Paso"),
  MENSAJE_DESCARGA_EVALUACION_VERIFICACION("Mensaje de descarga de evaluación de Verificación");

  private final String variableSesion;

}
