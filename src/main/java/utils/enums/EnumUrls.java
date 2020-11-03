package utils.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumUrls {
  SAMI("SAMI", "https://samipruebas.aplisalud.com:8789/"),
  RIPS("RIPS", "https://pruebasportalsami.aplisalud.com:8788/");

  private final String nombrePagina;
  private final String url;
  private static final Map<String, String> mapUrl = Collections.unmodifiableMap(inicializarMap());

  public static String obtenerUrl(String nombrePagina) {
    if (mapUrl.containsKey(nombrePagina)) {
      return mapUrl.get(nombrePagina);
    }
    return null;
  }

  private static Map<String, String> inicializarMap() {
    Map<String, String> mapUrl = new HashMap<>();
    for (utils.enums.EnumUrls urls : utils.enums.EnumUrls.values()) {
      mapUrl.put(urls.nombrePagina, urls.url);
    }
    return mapUrl;
  }
}
