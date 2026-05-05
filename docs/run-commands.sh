#!/bin/bash
# Script de referencia para ejecutar comandos comunes
# Copia los comandos que necesites según tu caso

# =============================================================================
# 1. EJECUTAR TESTS (H2 embebido - Perfil 'test')
# =============================================================================
# Opción A: Maven por defecto (automáticamente activa perfil 'test')
mvn clean test

# Opción B: Especificar explícitamente el perfil (redundante pero explícito)
mvn clean test -Dspring-boot.test.database.replace=any

# =============================================================================
# 2. DESARROLLO LOCAL (BD real requerida)
# =============================================================================
# Primero, configura las variables de entorno (Linux/Mac)
export DB_URL="jdbc:mysql://localhost:3306/mydb_dev"
export DB_DRIVER_CLASS="com.mysql.cj.jdbc.Driver"
export DB_USER="root"
export DB_PASSWORD="dev123"
export DB_PLATFORM="mysql"

# Luego ejecuta con perfil 'local'
mvn spring-boot:run -Dspring-boot.run.profiles=local

# O si prefieres en Windows (PowerShell):
$env:DB_URL="jdbc:mysql://localhost:3306/mydb_dev"
$env:DB_DRIVER_CLASS="com.mysql.cj.jdbc.Driver"
$env:DB_USER="root"
$env:DB_PASSWORD="dev123"
$env:DB_PLATFORM="mysql"
mvn spring-boot:run -Dspring-boot.run.profiles=local

# =============================================================================
# 3. BUILD Y DEPLOY PRODUCCIÓN
# =============================================================================
# Build sin tests (opcional)
mvn clean package -DskipTests

# Build con tests
mvn clean package

# Deploy (ejemplo, ajustar según tu CI/CD)
# Esta parte va en tu CI/CD pipeline
# Las variables de entorno vendrán de tu platform (Docker, K8s, etc.)
java -jar target/app.jar

# =============================================================================
# 4. VERIFICAR CUÁL DATASOURCE ESTÁ ACTIVO
# =============================================================================
# Si ejecutas en modo DEBUG, verás en los logs:
# [INFO] Datasource setup: Using H2 Embedded Database
# O
# [INFO] Datasource setup: Using External Datasource from properties

# También puedes verificar el perfil activo:
mvn spring-boot:run -Dspring-boot.run.profiles=debug
# Busca en logs: "The following profiles are active: [test]"

# =============================================================================
# 5. SOLUCIONAR PROBLEMAS COMUNES
# =============================================================================

# Problema: Tests fallan porque no encuentran BD
# Solución: Verifica que application-test.yml existe y contiene la config correcta
# Verifica que schema.sql y data.sql están en src/test/resources/

# Problema: Desarrollo local falla por BD
# Solución: Verifica que MySQL está corriendo
#          Verifica que DB_URL, DB_USER, DB_PASSWORD están configurados
#          Revisa los logs: "HikariPool-1 - Connection is not available"

# Problema: Tests usan BD external en lugar de H2
# Solución: El perfil test no está activo. Verifica:
#          - ¿Tu clase test uso @SpringBootTest?
#          - ¿Heredas de SpringBootTestCase si lo necesitas?
#          - Ejecuta: mvn clean test -X (debug) y busca "profile test"

echo "✅ Comandos de referencia listos. Selecciona el que necesites."
