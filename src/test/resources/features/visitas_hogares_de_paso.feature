#language: es

Característica: Programar Visita y Realizar evaluación
  Yo como usuario de expertmedica, en el rol de asesor
  quiero programar una visita a un hogar de paso
  para verificar las condiciones del lugar y registrarlo en la evaluación de verificación de condiciones.

  Escenario: Programar visita de Hogar de Paso y realizar evaluación de verificación de condiciones
    Dado el usuario 'usuario prueba' ingreso a la aplicación de 'SAMI' de forma exitosa
    Cuando programe una visita de 'hogares de paso' con las características
      | EPS                | Coosalud EPS                                  |
      | Departamento       | BOGOTA                                        |
      | Ciudad             | BOGOTA                                        |
      | Codigo Sede        | 210114720001                                  |
      | Contrato           | CONEVE_EPS_7_IPS_50849                        |
      | Fecha Visita       | 30/Oct/2020                                   |
      | Descripcion Visita | Visita hogar de paso funcionario Expertmedica |
    Y el usuario 'usuario prueba' ingrese a la aplicación de 'RIPS' de forma exitosa
    Y realice la verificación de condiciones para el hogar de paso 'ALBERGUE LUPITA' el cual cuenta con '15' empleados
    Entonces puede visualizar la visita del hogar de paso 'ALBERGUE LUPITA' en estado 'Completa'
    Y puede descargar la evaluación generada del hogar de paso 'ALBERGUE LUPITA' visualizando el mensaje 'Informe generado con éxito'

  Escenario: Controlar mensaje al intentar generar una evaluación de hogar de paso sin cantidad de empleados
    Dado el usuario 'usuario prueba' ingreso a la aplicación de 'SAMI' de forma exitosa
    Cuando programe una visita de 'hogares de paso' con las características
      | EPS                | Coosalud EPS                                  |
      | Departamento       | CORDOBA                                       |
      | Ciudad             | MONTERIA                                      |
      | Codigo Sede        | 900838602001                                  |
      | Contrato           | SCO2019ES1A00012395                           |
      | Fecha Visita       | 30/Oct/2020                                   |
      | Descripcion Visita | Visita hogar de paso funcionario Expertmedica |
    Y el usuario 'usuario prueba' ingrese a la aplicación de 'RIPS' de forma exitosa
    Y pretenda realizar la verificación de condiciones para el hogar de paso 'SABER VIVIR DE LA COSTA S.A' sin diligenciar la cantidad de empleados del establecimiento
    Entonces puede visualizar el mensaje 'Debe informar el número de trabajadores'

  Escenario: Controlar mensaje al intentar generar una evaluación de hogar de paso con evaluación de condiciones vigente
    Dado el usuario 'usuario prueba' ingrese a la aplicación de 'RIPS' de forma exitosa
    Cuando se tenga una visita programada para el hogar de paso 'HOGAR DE PASO SANTA TERESITA SAS' que tenga una evaluación de condiciones diligenciada inferior a un año
    Entonces puede visualizar el mensaje 'No ha pasado un año desde la última evaluación de este hogar de paso.'