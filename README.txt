# Guía de Uso de la Aplicación de Control de Ventiladores

## Propósito

Esta aplicación Java permite controlar la velocidad de los ventiladores de un servidor de forma remota utilizando la herramienta `ipmitool`. La configuración del servidor y la velocidad deseada se especifican en un archivo `config.json`.

## Requisitos

Antes de usar la aplicación, asegúrate de tener lo siguiente instalado en el sistema desde donde la ejecutarás:

1.  **Java**: Necesario para ejecutar la aplicación.
2.  **Maven**: Necesario para compilar el proyecto y manejar las dependencias.
3.  **ipmitool**: La herramienta de línea de comandos que se utiliza para comunicarse con la interfaz IPMI del servidor.

## Configuración

La aplicación requiere un archivo de configuración en formato JSON. Debes crear este archivo y pasar su ruta como argumento al ejecutar la aplicación.

**Ejemplo de `config.json`:**

```json
{
  "user": "tu_usuario_ipmi",
  "password": "tu_contraseña_ipmi",
  "ip": "dirección_ip_del_servidor",
  "speed": 50
}
```

-   `user`: El nombre de usuario para la interfaz IPMI del servidor.
-   `password`: La contraseña para la interfaz IPMI.
-   `ip`: La dirección IP de la interfaz de gestión del servidor (BMC/IPMI).
-   `speed`: La velocidad deseada para los ventiladores, en porcentaje (un valor de 0 a 100).

## Compilación y Ejecución

Sigue estos pasos para compilar y ejecutar la aplicación:

1.  **Compilar el proyecto:**
    Abre una terminal en el directorio raíz del proyecto y ejecuta el siguiente comando de Maven para compilarlo y empaquetarlo en un archivo JAR.

    ```bash
    mvn package
    ```
    Esto creará un archivo `serverfansj-1.0-SNAPSHOT.jar` en el directorio `target`.

2.  **Ejecutar la aplicación:**
    Una vez compilado, puedes ejecutar la aplicación desde la terminal. Asegúrate de reemplazar `ruta/a/tu/config.json` con la ruta real a tu archivo de configuración.

    ```bash
    java -cp target/serverfansj-1.0-SNAPSHOT.jar com.ejemplo.serverfansj.App ruta/a/tu/config.json
    ```

La aplicación primero verificará si `ipmitool` está disponible, luego establecerá el modo de los ventiladores a manual y finalmente ajustará la velocidad al porcentaje que especificaste en el archivo de configuración.
