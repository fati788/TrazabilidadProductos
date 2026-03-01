# 📦 Sistema de Trazabilidad de Productos
## API REST con Spring Boot

---

## 📖 Descripción del Proyecto

Este proyecto consiste en el desarrollo de una API REST utilizando Spring Boot para gestionar la trazabilidad de productos a lo largo de su ciclo de vida.

El sistema permite:

- Registro y autenticación de usuarios mediante JWT.
- Gestión completa de productos.
- Gestión de lotes asociados a productos.
- Registro de eventos de trazabilidad (producción, transporte, control de calidad, entrega, etc.).
- Consulta del historial completo de un lote.

Simula un backend real utilizado en sectores como industria alimentaria, logística y agrotech.

---
## Enlace de app en mi github
https://github.com/fati788/TrazabilidadProductos.git

---
## 🔐 Seguridad

La aplicación implementa autenticación basada en JWT:

1. Registro de usuario
2. Login con credenciales
3. Generación de token JWT
4. Protección de todos los endpoints `/api/**`

El token debe enviarse en cada petición protegida:
## 📌 Endpoints Principales

### 🔑 Autenticación

| Método | Endpoint | Descripción |
|--------|----------|------------|
| POST | `/auth/register` | Registro de usuario |
| POST | `/auth/login` | Login y obtención de JWT |

---

### 📦 Productos

| Método | Endpoint | Descripción |
|--------|----------|------------|
| GET | `/api/productos` | Listar productos |
| POST | `/api/productos` | Crear producto |
| GET | `/api/productos/{id}` | Obtener detalle |
| PUT | `/api/productos/{id}` | Actualizar producto |
| DELETE | `/api/productos/{id}` | Eliminar producto |

---

### 🏷️ Lotes

| Método | Endpoint | Descripción |
|--------|----------|------------|
| GET | `/api/productos/{id}/lotes` | Listar lotes de un producto |
| POST | `/api/productos/{id}/lotes` | Crear lote |
| GET | `/api/lotes/{id}` | Obtener detalle |
| PATCH | `/api/lotes/{id}/estado` | Actualizar estado del lote |

---

### 📍 Eventos de Trazabilidad

| Método | Endpoint | Descripción |
|--------|----------|------------|
| POST | `/api/lotes/{id}/eventos` | Registrar evento |
| GET | `/api/lotes/{id}/eventos` | Obtener historial completo |
| GET | `/api/lotes/{id}/ruta` | Eventos ordenados cronológicamente |

---
### Despliegue en AWS
1. Enlace: https://us-east-1.console.aws.amazon.com/ec2-instance-connect/ssh/home?addressFamily=ipv4&connType=standard&instanceId=i-0ac11b9d43b3db2ae&osUser=ubuntu&region=us-east-1&sshPort=22
2. Comandos:
``` bash
podman start mariadb_practica
cd TrazabilidadProductos/build/libs/
java -jar TrazabilidadProductos2026-0.0.1-SNAPSHOT.jar
```
