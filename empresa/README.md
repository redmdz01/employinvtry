# Bienvenido a Kruger Corp
Kruger Corporation requiere una aplicación para llevar un registro del inventario del estado de vacunación de los empleados.

# Introducccion Api Vacunación
Existirán 2 roles: Administrador y Empleado

1. Como Administrador requiere registrar, editar, listar y eliminar a los empleados.
Criterios de aceptación:
a. Registrar la información del empleado:
○ Cédula.
○ Nombres.
○ Apellidos.
○ Correo electrónico.

b. Validaciones de estos 4 campos:
○ Todos los campos son requeridos.
○ Cédula válida. (Incluir un valor numérico y único de 10 dígitos)
○ Correo electrónico válido.
○ Nombres y apellidos no deben contener números o caracteres especiales.

c. Al dar de alta un empleado se debe generar un usuario y contraseña para el mismo.
(Inicialmente, se creará como usuario la identificacion, y una contraseña aleatoria).

2. Como Empleado requiere ingresar al sistema para visualizar y actualizar mi información.
Criterios de aceptación:

a. Completar la siguiente información:
● Fecha de nacimiento.
● Dirección de domicilio.
● Teléfono móvil.
● Estado de vacunación: Vacunado= 'S' / No Vacunado ='N'.
● Si el empleado está en estado vacunado, se debe pedir la siguiente información
requerida:
○ Tipo de vacuna: Sputnik, AstraZeneca, Pfizer y Jhonson&Jhonson
○ Fecha de vacunación.
○ Número de dosis.

3. Como Administrador se requiere filtrar el listado de los empleados por los siguientes criterios.
Criterios de aceptación:
a. Filtrar por estado de vacunación.
b. Filtrar por tipo de vacuna.
c. Filtrar por rango de fecha de vacunación.

## Requerimientos

-Version de Java: [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 

-Generado con Maven
-Spring boot 2.7.0
-Visual Studio Code: 1.68.1
-Postgreslq V10 , PGadmin 4 V6.8
-thunder Client: pruebas de servicios REST

### Dependencias SB Initializer:
-Spring Web
-PostgreSql Driver
-Spring Data JPA

Seguridad endpoints, roles:
-spring-boot-starter-security
-spring-cloud-starter-oauth2'

### compilar el proyecto

Ejecutar Run de la clase principal "EmpresaApplication.jar"
Se ejecutara en el puerto :8080.


### Registrar empleados
Endpoint

POST /api/empleado/crear-empleados

Ejemplo body

```json
{
    "apellido":"Mendez",
    "correo":"mmendez@gmail.com",
    "nombre":"Mayra",
    "cedula":"0102232303"
}
```
| Parámetro   | Descripción                                               |
| ----------- | --------------------------------------------------------- |
|empleado     | objeto tipo EmpleadoEntity, los 4 campos son obligatorios,|
|             | el resto pueden ir nulo para este servicio.               |

### listar empleados
Ejemplo empleados

GET  /api/empleado/lista-empleados

### eliminar empleados
DELETE /api/empleado/eliminar-empleados/0102232303

| Parámetro   | Descripción                                               |
| ----------- | --------------------------------------------------------- |
|cedula       | cedula tipo String, del empleado en cuestion              |


si no existen datos muestra mensaje de registro inexistente.

### Insertar datos de vacunas

POST /api/empleado/crear-vacunas
body
{
    "tipo":"Sputnik"
}

## Listar datos de vacunas 
GET /api/empleado/lista-vacunas
[
  {
    "tipo": "Sputnik"
  },
  {
    "tipo": "AstraZeneca"
  }
]

### registro de vacunacion
PUT /api/empleado/modificar-empleados/0102232302

en este caso forma parte de la modifiacion del empleado donde, si la letra de vacunacion es igual a "S", inserta un segundo objeto en la tabla carnet (cedula, fecha de vacuna, tipo y dosis), caso contrario solo modifica el empleado datos como: vacunado, fecha de nacimiento, direccion, telefono movil.



Endpoint

```text
GET /readings/read/<smartMeterId>
```

Parameters

