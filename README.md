ForoHub API 🚀

Bienvenido a la documentación de la API de ForoHub. Este proyecto proporciona una plataforma para gestionar temas de discusión mediante una API RESTful, asegurada con autenticación JWT para control de acceso.

Funcionalidades ✨
Listar Todos los Tópicos 📜: Endpoint para obtener todos los tópicos disponibles.
Listar Tópicos con Paginación 📄: Endpoint para obtener tópicos paginados.
Obtener Tópico por ID 🔍: Endpoint para obtener detalles de un tópico específico.
Crear Tópico ✍️: Endpoint para crear un nuevo tópico (requiere rol de administrador).
Actualizar Tópico 🛠️: Endpoint para actualizar un tópico existente (requiere rol de administrador).
Eliminar Tópico 🗑️: Endpoint para eliminar un tópico existente (requiere rol de administrador).
Obtener Nombre de Usuario 👤: Endpoint para obtener el nombre de usuario actualmente autenticado.
Autenticación 🔐
La API utiliza JWT (JSON Web Token) para la autenticación. Los usuarios deben autenticarse usando un token JWT válido para acceder a las funcionalidades protegidas.

Roles y Autorización 🎛️
USER: Permite acceso a operaciones básicas como listar y obtener tópicos.
ADMIN: Permite acceso completo, incluyendo creación, actualización y eliminación de tópicos.
Endpoints Disponibles 📡
GET /api/topicos: Obtener todos los tópicos.
GET /api/topicos/paginado: Obtener tópicos paginados.
GET /api/topicos/{id}: Obtener detalles de un tópico por su ID.
POST /api/topicos: Crear un nuevo tópico.
PUT /api/topicos/{id}: Actualizar un tópico existente.
DELETE /api/topicos/{id}: Eliminar un tópico existente.
GET /api/topicos/username: Obtener el nombre de usuario actual.
Ejemplos de Uso 📘
Obtener todos los Tópicos
http
Copiar código
GET /api/topicos HTTP/1.1
Host: localhost:8080
Authorization: Bearer your_jwt_token
Crear un Nuevo Tópico
http
Copiar código
POST /api/topicos HTTP/1.1
Host: localhost:8080
Authorization: Bearer your_jwt_token
Content-Type: application/json

{
  "titulo": "Nuevo Tópico",
  "contenido": "Contenido del nuevo tópico"
}
Configuración ⚙️
Asegúrate de tener configurados los siguientes parámetros en tu entorno:

jwt.secret: Secret para firmar los tokens JWT.
jwt.expiration: Tiempo de expiración del token JWT en milisegundos.
Construido Con 🛠️
Spring Boot - Framework para aplicaciones Java.
Spring Security - Para la seguridad y autenticación.
JWT - JSON Web Tokens para la autenticación segura.
Maven - Manejador de dependencias.
MySQL - Base de datos relacional.
Contribución 🤝
¡Las contribuciones son bienvenidas! Si tienes ideas para mejorar este proyecto, por favor abre un issue para discutir los cambios propuestos.

Licencia 📜
Este proyecto está bajo la Licencia MIT - mira el archivo LICENSE para detalles.
