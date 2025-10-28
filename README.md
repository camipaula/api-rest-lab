API REST de Envíos (Apache Camel)

Este proyecto implementa una API REST básica utilizando Apache Camel con el componente netty-http.
Permite registrar y consultar envíos mediante métodos GET y POST, y expone la documentación OpenAPI/Swagger.


REQUISITOS PREVIOS
------------------
Antes de comenzar, asegúrate de tener instalado:

- Java 17 o superior
- Apache Maven 3.8+
- Visual Studio Code o cualquier IDE compatible con Java

Verifica las versiones ejecutando en la terminal:
java -version
mvn -version


INSTALACIÓN
------------
1. Clona o descarga este repositorio en tu equipo:
   git clone https://github.com/tuusuario/api-rest-lab.git
   cd api-rest-lab

2. Compila el proyecto y descarga las dependencias:
   mvn clean package

3. Para ejecutar directamente desde Maven:
   mvn exec:java

4. O para ejecutar el archivo .jar generado:
   java -jar target/api-rest-lab-fat.jar

5. Una vez iniciado, la API estará disponible en:
   http://localhost:7760/api/envios


ENDPOINTS DISPONIBLES
---------------------
1. Listar todos los envíos
   Método: GET
   URL: http://localhost:7760/api/envios
   Ejemplo de respuesta:
   [
     {
       "id": "001",
       "destinatario": "Juan Pérez",
       "estado": "En tránsito"
     }
   ]

2. Obtener un envío por ID
   Método: GET
   URL: http://localhost:7760/api/envios/{id}
   Ejemplo:
   http://localhost:7760/api/envios/123
   Respuesta:
   {
     "id": "123",
     "destinatario": "Cliente X",
     "estado": "Entregado"
   }

3. Crear un nuevo envío
   Método: POST
   URL: http://localhost:7760/api/envios
   Headers:
   Content-Type: application/json
   Body:
   {
     "id": "123",
     "destinatario": "Mateo Pillajo",
     "direccion": "Quito, Av. Amazonas",
     "estado": "En tránsito"
   }
   Respuesta:
   {
     "mensaje": "Envío registrado correctamente"
   }

4. Ver documentación OpenAPI
   Método: GET
   URL: http://localhost:7760/api/api-doc


ESTRUCTURA DEL PROYECTO
-----------------------
api-rest-lab/
├── src/
│   ├── main/java/edu/udla/isw/App.java     (Clase principal con las rutas Camel)
│   └── test/java/...                       (Pruebas unitarias)
├── pom.xml                                 (Configuración de Maven y dependencias)
└── README.txt                              (Este archivo)


NOTAS
-----
- El servicio se ejecuta por defecto en el puerto 7760.
- Puedes cambiarlo modificando la línea en App.java:
  .port(7760)
- La API está construida con Apache Camel 4.7 y el componente netty-http.


CRÉDITOS
--------
Proyecto desarrollado por Camila Cabrera
Facultad de Ingeniería — Universidad de las Américas (UDLA)
