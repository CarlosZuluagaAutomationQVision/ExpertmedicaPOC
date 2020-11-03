package utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumNombresCsv {

  ALBERGUE_LUPITA("albergue_lupita"),
  AMANECER_MEDICO_SA("amanecer_medico_sa"),
  CAD_VIDA_IPS_SAS("cad_vida_ips_sas"),
  DROGUERIA_LA_ESPERANZA_K_NORTE_DE_SANTANDER("drogueria_la_esperanza_k_norte_de_santander"),
  HOGAR_PASO_BETHESDA_SEDE_2("hogar paso bethesda sede 2"),
  HOGAR_SALUD_MARIANA_SAS("hogar_salud_mariana_sas"),
  INVERSIONES_Y_SOLUCIONES_KHAL_SAS("inversiones_y_soliciones_khal_sas"),
  SALUD_EN_SU_DOMICILIO("salud_en_su_domicilio"),
  SAN_JUAN_HOME_CARE_SAS("san_juan_home_care_sas");

  private final String nombre;
}
