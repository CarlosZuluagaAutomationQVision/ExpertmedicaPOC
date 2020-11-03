package utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumUsuarios {

  USUARIO_INCORRECTO("usuarioFalso123", "usuarioFalso123"),
  USUARIO_PRUEBA("Vulnerabilidad1@", "Apli.2020*");

  private final String usuario;
  private final String clave;
}
