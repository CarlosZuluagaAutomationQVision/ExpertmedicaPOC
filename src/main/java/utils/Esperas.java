package utils;

import com.google.common.base.Function;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public final class Esperas {

  private static Wait<Integer> wait;
  private static final String MILISEGUNDOS = "millisegundos";
  private static final String SEGUNDOS = "segundos";

  private Esperas() {}

  public static void definirTiempos(int tiempoEspera, String unidadMedidaEspera) {
    Integer i = 0;
    if (unidadMedidaEspera.equalsIgnoreCase(MILISEGUNDOS)) {
      wait =
          new FluentWait<>(i)
              .withTimeout(Duration.ofMillis(tiempoEspera))
              .pollingEvery(Duration.ofMillis(tiempoEspera));
    } else if (unidadMedidaEspera.equalsIgnoreCase(SEGUNDOS)) {
      wait =
          new FluentWait<>(i)
              .withTimeout(Duration.ofSeconds(tiempoEspera))
              .pollingEvery(Duration.ofSeconds(tiempoEspera));
    }
  }

  public static void esperarHasta(int tiempoEspera, String unidadMedida) {
    try {
      definirTiempos(tiempoEspera, unidadMedida);
      wait.until(new IntegerBooleanFunction());
    } catch (TimeoutException e) {
      Logger.info(utils.Esperas.class.getName(), "TimeoutException in" + e);
    }
  }

  private static class IntegerBooleanFunction implements Function<Integer, Boolean> {

    public Boolean apply(Integer i) {
      return false;
    }
  }
}
