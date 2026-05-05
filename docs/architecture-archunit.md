# Arquitectura Validada por ArchUnit

## Descripción General

El proyecto implementa validaciones automáticas de arquitectura mediante **ArchUnit**, una librería de testing que permite verificar reglas arquitectónicas y de codificación en tiempo de compilación. Esta documentación describe los patrones y restricciones definidas en los tests de arquitetrura.

## Estructura de Capas

El proyecto sigue una arquitectura en **capas hexagonales (Hexagonal Architecture)** con las siguientes capas:

```
┌─────────────────────────────────────────────┐
│          CONTROLLER Layer                    │
│    (API Rest Endpoints - HTTP)               │
└─────────────────────────────────────────────┘
                     ↓
┌─────────────────────────────────────────────┐
│        APPLICATION Layer                     │
│    (Business Logic & Use Cases)              │
└─────────────────────────────────────────────┘
           ↙              ↖
┌──────────────────┐  ┌─────────────────────┐
│ ADAPTER Layer    │  │ PERSISTENCE Layer   │
│                  │  │ (Data Access)       │
└──────────────────┘  └─────────────────────┘
           ↘              ↙
┌─────────────────────────────────────────────┐
│       DOMAIN Layer                           │
│    (Entidades & Value Objects)               │
└─────────────────────────────────────────────┘
           ↕
┌─────────────────────────────────────────────┐
│        CONFIG Layer                          │
│    (Spring Configuration & Beans)            │
└─────────────────────────────────────────────┘
```

## Descripción de Capas

### 1. **CONTROLLER Layer** (`..controller..`)
- **Responsabilidad**: Exponer endpoints REST y manejar solicitudes HTTP
- **Características**:
  - Controladores anotados con `@RestController`
  - Deben tener el sufijo `Controller` en su nombre
  - No pueden ser accedidos por ninguna otra capa (punto de entrada)
  - Comunican con la capa de Application

**Ejemplo**: `EmployeeController.java`

### 2. **APPLICATION Layer** (`..application..`)
- **Responsabilidad**: Implementar la lógica de negocio y casos de uso
- **Características**:
  - Services que orquestan la lógica empresarial
  - Solo pueden ser accedidos por:
    - CONTROLLER (lectores de solicitudes)
    - ADAPTERS (integraciones externas)
  - Comunican con Domain y Persistence

**Ejemplo**: `EmployeeService.java`

### 3. **ADAPTER Layer** (`..adapter..`)
- **Responsabilidad**: Implementar adaptadores para integraciones externas
- **Características**:
  - Adaptadores para APIs externas, sistemas terceros
  - Solo pueden ser accedidos por CONFIG
  - Comunican con Domain y Persistence

### 4. **PERSISTENCE Layer** (`..persistence..`)
- **Responsabilidad**: Acceso a datos y persistencia
- **Características**:
  - Repositorios y mappers
  - Solo pueden ser accedidos por:
    - APPLICATION
    - ADAPTERS
  - Comunican con Domain
  - Mapean entidades de dominio a DTOs

**Ejemplo**: `EmployeeMapper.java`

### 5. **DOMAIN Layer** (`..domain..`)
- **Responsabilidad**: Definir entidades de negocio y reglas de dominio
- **Características**:
  - No tiene dependencias externas (excepto librerías estándar)
  - Puede ser accedido por cualquier capa
  - Contiene lógica pura de dominio
  - Es el corazón del sistema

**Ejemplo**: `Employee.java`

### 6. **CONFIG Layer** (`..config..`)
- **Responsabilidad**: Configuración de Spring y beans
- **Características**:
  - Clases anotadas con `@Configuration`
  - Define beans de aplicación
  - Puede acceder a todas las capas para su configuración
  - Punto de inyección de dependencias

**Ejemplo**: `PersistenceConfig.java`

## Reglas de Codificación

Las siguientes reglas de codificación se validan automáticamente:

### Convenciones de Nombres

| Tipo de Clase | Sufijo | Localización | Validación |
|---|---|---|---|
| Excepciones | `-Exception` | `..exception..` | Obligatorio |
| Controladores | `-Controller` | `..controller..` | Obligatorio |
| Implementaciones | ~`-Impl`~ | Cualquiera | **Prohibido** ✗ |

**Ejemplo correcto**:
```java
// ✓ Correcto
public class EmployeeNotFoundException extends Exception { }
public class EmployeeController { }

// ✗ Incorrecto
public class EmployeeNotFoundExc extends Exception { }
public class EmployeeServ { }
public class EmployeeServiceImpl { }
```

### Restricciones Técnicas

Las siguientes prácticas están **prohibidas** en todo el proyecto:

1. **Lanzar excepciones genéricas**
   ```java
   // ✗ Prohibido
   throw new Exception("Algo salió mal");
   throw new RuntimeException("Error");
   
   // ✓ Correcto
   throw new EmployeeNotFoundException("Employee not found");
   ```

2. **Acceder a streams estándar (System.out/err)**
   ```java
   // ✗ Prohibido
   System.out.println("Debug message");
   System.err.println("Error message");
   
   // ✓ Correcto
   log.debug("Debug message");
   log.error("Error message");
   ```

3. **Usar java.util.logging**
   ```java
   // ✗ Prohibido
   Logger logger = Logger.getLogger(MyClass.class.getName());
   
   // ✓ Correcto
   @Slf4j
   public class MyClass {
       log.info("Info message");
   }
   ```

4. **Usar Joda Time**
   ```java
   // ✗ Prohibido
   DateTime dateTime = new DateTime();
   
   // ✓ Correcto
   LocalDateTime dateTime = LocalDateTime.now();
   ZonedDateTime zonedDateTime = ZonedDateTime.now();
   ```

## Dependencias Entre Capas

### Matriz de Dependencias Permitidas

|  | Controller | Application | Adapter | Persistence | Domain | Config |
|---|---|---|---|---|---|---|
| **Controller** | - | ✓ | ✗ | ✗ | ✓ | ✗ |
| **Application** | ✗ | - | ✗ | ✓ | ✓ | ✗ |
| **Adapter** | ✗ | ✗ | - | ✓ | ✓ | ✗ |
| **Persistence** | ✗ | ✗ | ✗ | - | ✓ | ✗ |
| **Domain** | ✓ | ✓ | ✓ | ✓ | - | ✓ |
| **Config** | ✓ | ✓ | ✓ | ✓ | ✓ | - |

**Leyenda**: ✓ = Permitido | ✗ = Prohibido

### Reglas Detalladas

1. **Controller**
   - ✓ Puede depender de: Application, Domain
   - ✗ No puede ser accedido por ninguna capa
   - Rol: Punto de entrada de solicitudes HTTP

2. **Application**
   - ✓ Puede depender de: Persistence, Domain
   - ✓ Puede ser accedido por: Controller, Adapter
   - Rol: Orquestación de lógica de negocio

3. **Adapter**
   - ✓ Puede depender de: Persistence, Domain
   - ✓ Puede acceder a: Application, Persistence
   - Rol: Integraciones externas

4. **Persistence**
   - ✓ Puede depender de: Domain
   - ✓ Puede ser accedido por: Application, Adapter
   - Rol: Acceso a datos

5. **Domain**
   - ✓ Puede depender de: nada (excepto librerías estándar)
   - ✓ Puede ser accedido por: todas las capas
   - Rol: Entidades puras del negocio

6. **Config**
   - ✓ Puede depender de: todas las capas
   - ✓ Puede acceder a: todas las capas
   - Rol: Configuración y wireup de beans

## Ejemplo de Flujo de Datos

Flujo típico de una solicitud HTTP:

```
Cliente HTTP
    ↓
┌─────────────────────────────────┐
│  EmployeeController             │  ← Recibe solicitud
│  - @GetMapping("/employees/{id}")
└─────────────────────────────────┘
    ↓
┌─────────────────────────────────┐
│  EmployeeService                │  ← Aplica lógica de negocio
│  - getEmployeeById(id)          │
└─────────────────────────────────┘
    ↓
┌─────────────────────────────────┐
│  EmployeeMapper                 │  ← Mapea datos
│  - queryEmployeeById(id)        │
└─────────────────────────────────┘
    ↓
┌─────────────────────────────────┐
│  Database                       │  ← Persiste datos
│  - SELECT FROM employees...     │
└─────────────────────────────────┘
    ↓
┌─────────────────────────────────┐
│  Employee (Domain)              │  ← Entidad de dominio
│  - id, name, email, etc.        │
└─────────────────────────────────┘
    ↓
Response JSON
    ↓
Cliente HTTP
```

## Ejecución de Tests de Arquitectura

Para ejecutar los tests de ArchUnit:

```bash
# Ejecutar todos los tests de arquitectura
./mvnw test -Dtest=*ArchUnit*

# Ejecutar solo reglas de codificación
./mvnw test -Dtest=CodingRulesTest

# Ejecutar solo validación de capas
./mvnw test -Dtest=LayeredArchitectureTest

# Ejecutar todos los tests
./mvnw test
```

## Beneficios de esta Arquitectura

1. **Mantenibilidad**: Estructura clara y predecible
2. **Testabilidad**: Capas desacopladas facilitan unit tests
3. **Escalabilidad**: Fácil agregar nuevas funcionalidades
4. **Reusabilidad**: Domain y Application reutilizables
5. **Flexibilidad**: Fácil cambiar adaptadores y persistencia
6. **Seguridad de tipos**: ArchUnit detecta violaciones en compilación

## Referencias

- [ArchUnit Official Documentation](https://www.archunit.org/)
- [Hexagonal Architecture Pattern](https://en.wikipedia.org/wiki/Hexagonal_architecture_(software))
- [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [Spring Boot Best Practices](https://spring.io/projects/spring-boot)

## Conclusión

Esta arquitectura valida automáticamente mediante ArchUnit asegura que el proyecto mantenga un diseño limpio, escalable y fácil de mantener. Las reglas son verificadas en cada compilación, garantizando la integridad arquitectónica a lo largo de todo el ciclo de desarrollo.
