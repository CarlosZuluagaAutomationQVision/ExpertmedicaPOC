#language: es

Característica: Probar correcto funcionamiento modulo loguin
  Yo como usuario de expertmedica, en el rol de asesor
  quiero iniciar sesion en las aplicaciones de SAMI
  para verificar las caracteristicas del rol.

  Escenario: Iniciar sesion dentro de las aplicaciones de Sami con usuario no registrado
    Cuando el usuario 'usuario incorrecto' ingreso a la aplicación de 'SAMI' de forma fallida
    Entonces visualiza el mensaje 'Usuario o contraseña incorrectos'

  Escenario: Iniciar sesion dentro de las aplicaciones de Sami con usuario registrado
    Cuando el usuario 'usuario prueba' ingreso a la aplicación de 'SAMI' de forma exitosa
    Entonces visualiza el mensaje 'SAMI'

