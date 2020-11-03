package tasks;

import static userinterface.SamiBuscarContratoUserInterface.BTN_ASIGNAR_CONTRATO;
import static userinterface.SamiBuscarContratoUserInterface.CMB_CIUDAD;
import static userinterface.SamiBuscarContratoUserInterface.CMB_CONTRATOS;
import static userinterface.SamiBuscarContratoUserInterface.CMB_DEPARTAMENTO;
import static userinterface.SamiBuscarContratoUserInterface.CMB_EPS;
import static userinterface.SamiBuscarContratoUserInterface.CMB_SELECCIONAR_SEDE;
import static userinterface.SamiBuscarContratoUserInterface.TXT_DIGITAR_INFORMACION;
import static userinterface.SamiBuscarContratoUserInterface.TXT_SEDE;
import static userinterface.SamiCronogramaUserInterface.BTN_BUSCAR_CONTRATO;
import static utils.Esperas.esperarHasta;

import java.util.Map;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

@AllArgsConstructor
public class AsignarContratoCronograma implements Task {

  Map<String, String> mapCaracteristicasContrato;
  private static final String SEGUNDOS = "segundos";

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(BTN_BUSCAR_CONTRATO));
    esperarHasta(2, SEGUNDOS);
    actor.attemptsTo(Click.on(CMB_EPS),
        Enter.theValue(mapCaracteristicasContrato.get("EPS")).into(TXT_DIGITAR_INFORMACION)
            .thenHit(Keys.ENTER), Click.on(CMB_DEPARTAMENTO),
        Enter.theValue(mapCaracteristicasContrato.get("Departamento")).into(TXT_DIGITAR_INFORMACION)
            .thenHit(Keys.ENTER));
    esperarHasta(5, SEGUNDOS);
    actor.attemptsTo(Click.on(CMB_CIUDAD),
        Enter.theValue(mapCaracteristicasContrato.get("Ciudad")).into(TXT_DIGITAR_INFORMACION)
            .thenHit(Keys.ENTER), Click.on(TXT_SEDE),
        Enter.theValue(mapCaracteristicasContrato.get("Codigo Sede")).into(TXT_SEDE)
            .thenHit(Keys.ENTER));
    esperarHasta(5, SEGUNDOS);
    actor.attemptsTo(Click.on(CMB_SELECCIONAR_SEDE),
        Enter.theValue(mapCaracteristicasContrato.get("Codigo Sede")).into(TXT_DIGITAR_INFORMACION)
            .thenHit(Keys.ENTER));
    esperarHasta(3, SEGUNDOS);
    actor.attemptsTo(Click.on(CMB_CONTRATOS),
        Enter.theValue(mapCaracteristicasContrato.get("Contrato")).into(TXT_DIGITAR_INFORMACION)
            .thenHit(Keys.ENTER), Click.on(BTN_ASIGNAR_CONTRATO));
  }

  public static AsignarContratoCronograma conParametros(
      Map<String, String> mapCaracteristicasContrato) {
    return Tasks.instrumented(AsignarContratoCronograma.class, mapCaracteristicasContrato);
  }
}
