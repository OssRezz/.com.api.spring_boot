# Api Spring Boot

- Proyecto desarrollado con el IDE Spring Tool Suite

- JDK de Java Version 8

- Base de datos MySQL

## Para usar esta api seguir los siguientes pasos:

- En la carpeta src/main/java/resources encontramos el archivo application.properties. En esta vamos a modificar

1.  la dirección de nuestra bases de datos, el puerto y el nombre de nuestra base de datos en el parámetro `spring.datasource.url`, en mi caso es:
    `spring.datasource.url=jdbc:mysql://localhost:3306/employees_db`

2.  Cambiamos el usuario de nuestro servidor de baso de datos `spring.datasource.username=root`

3.  Agregamos la password de nuestra base de datos `spring.datasource.password=`

## Consumir endpoints

1. Todos los empleados `localhost:8080/api/employees` method GET

<br>

2. Ingresar un empleado `localhost:8080/api/employees` method POST y desde postman agregamos la siguiente información en `raw` de tipo `JSON`

```
{
    "name": "James",
    "last_name": "Hortua Sanchez",
    "age": "32",
    "date_of_admission": "1996-06-15"
}
```

- Los parámetros, name, last_name, age y date of admission son requeridos, el comment puede ser null y estado por defecto sera 0

<br>

3. Actualizar un empleado `localhost:8080/api/employees` method PUT y desde postman agregamos la siguiente información en `raw` de tipo `JSON`

```
{
    "id":38,
    "name": "James",
    "last_name": "Hortua",
    "age": "32",
    "date_of_admission": "1996-06-15",
    "comment": "Comentario",
    "status": "0"
}
```

- Los parámetros, name, last_name, age y date of admission son requeridos, el comment puede ser null y estado solo puede ser valores como 0 o 1

- La aplicación tiene una validación de si el id existe.

<br>

4. Para eliminar un empleado `localhost:8080/api/employees/id` method PUT, enviamos el id por la URL. La aplicación tiene una validación de si el id existe.

<br>

5. Todos los empleados dados de baja (con estado 0) `localhost:8080/api/employees/employees/inactive` method GET.
