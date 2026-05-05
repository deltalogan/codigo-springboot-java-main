# Configuración de Datasource

## 🎯 Estrategia General

Este proyecto utiliza **dos estrategias diferentes** según el entorno:

### 1. **Entorno de TEST** 🧪
- **Datasource**: H2 embebido (en memoria)
- **Configuración**: `application-test.yml`
- **Bean**: Definido en `PersistenceConfig.dataSource()`
- **Activación**: Automática cuando Spring Boot detecta `@SpringBootTest`
- **Archivos SQL**:
  - `src/test/resources/schema.sql` → Esquema de BD
  - `src/test/resources/data.sql` → Datos iniciales

### 2. **Entorno de PRODUCCIÓN** 🚀
- **Datasource**: Externo (configurable via variables de entorno)
- **Configuración**: `application.yml`
- **Variables requeridas**:
  ```bash
  DB_URL=jdbc:mysql://localhost:3306/mydb
  DB_DRIVER_CLASS=com.mysql.cj.jdbc.Driver
  DB_USER=root
  DB_PASSWORD=secret
  DB_PLATFORM=mysql
  ```
- **Bean de Datasource**: **Autoconfigured** por Spring Boot (NO definido explícitamente)

---

## ⚠️ PUNTOS CRÍTICOS

### ¿Por qué NO activar el bean H2 en producción?

En `PersistenceConfig.java`:
```java
@Bean
@Profile("test")  // ← CLAVE: Solo en tests
public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()...H2...;
}
```

**Razones:**
1. **Seguridad**: H2 embebido en producción = BD en memoria = Pérdida de datos cuando se reinicia
2. **Performance**: BD en memoria vs DB productiva = órdenes de magnitud de diferencia
3. **Claridad**: Desarrolladores solo ven H2 en tests, datasource externo en producción

---

## 🔧 Cómo Ejecutar

### Tests automáticos (Maven compile)
```bash
mvn clean test
# Automáticamente:
# 1. Carga application-test.yml
# 2. Activa perfil "test"
# 3. Crea bean H2 en PersistenceConfig
# 4. Ejecuta schema.sql y data.sql
```

### Ejecución local para desarrollo
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--DB_URL=jdbc:mysql://localhost/devdb --DB_USER=root --DB_PASSWORD=pass"
# O mejor: crear .env con las variables
```

### Compilación a producción
```bash
mvn clean package -P prod
# Ignora application-test.yml
# Lee variables desde environment
```

---

## 📋 Checklist para Desarrolladores

- [ ] ¿Cambié `application.yml`? Verifica que solo contenga propiedades para PRODUCCIÓN
- [ ] ¿Necesito datos de test? Agrégalos a `src/test/resources/data.sql`
- [ ] ¿Cambié el schema de BD? Actualiza `src/test/resources/schema.sql`
- [ ] ¿Ejecuté `mvn test`? Debe pasar con H2 automáticamente
- [ ] ¿Deployé a producción? Verifica que las variables de entorno están configuradas

---

## 🚨 Problemas Comunes

### ❌ Error: "No datasource bean"
**Causa**: El perfil "test" no está activo en tests
**Solución**: Verifica que tu clase test use `@SpringBootTest`

### ❌ Error: "Propiedades de BD ignoradas en application.yml"
**Causa**: Bean H2 está activado en producción (sin @Profile)
**Solución**: Verifica que `dataSource()` en `PersistenceConfig` tenga `@Profile("test")`

### ❌ Error: "Schema/Data SQL no ejecutado"
**Causa**: Rutas incorrectas en `application-test.yml`
**Solución**: 
```yaml
sql:
  init:
    mode: always  # ← Debe estar en application-test.yml
```

---

## 📚 Referencias

- [Spring Profiles](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.profiles)
- [H2 Database](https://www.h2database.com/html/main.html)
- [MyBatis Spring Boot](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
