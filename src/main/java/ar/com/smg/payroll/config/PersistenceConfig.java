package ar.com.smg.payroll.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuración de Persistencia con MyBatis + Spring Boot.
 * <p>
 * Estrategia de DataSource según perfil:
 * - Perfil "test"     → H2 embebido (automático en tests)
 * - Perfil "pre", "qa", "prod", etc. → Datasource externo (Sybase) configurado en application.yml
 * <p>
 * Esta clase respeta la arquitectura hexagonal definida en el proyecto.
 */
@Configuration
@MapperScan({
        "ar.com.smg.payroll",                          // Mappers del módulo Employee (original)
        "ar.com.smg.smmp.hl7.persistence.mapper.ds1"  // Mappers HL7 SMMP (agregado en migración)
})
@EnableTransactionManagement
public class PersistenceConfig {

    /**
     * DataSource embebido H2 SOLO para entorno de Tests.
     * <p>
     * Se activa automáticamente cuando se usa @SpringBootTest + perfil "test".
     * En producción nunca se crea este bean (gracias al @Profile("test")).
     */
    @Bean
    @Profile("test")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("schema.sql")   // Crea la tabla EMPLOYEES
                .addScript("data.sql")     // Inserta datos de prueba
                .build();
    }

    /**
     * Crea el SqlSessionFactory de MyBatis.
     * <p>
     * Recibe el DataSource que corresponda según el perfil activo:
     * - Tests → H2 embebido
     * - Otros perfiles → Datasource Sybase configurado en application-*.yml
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }

    /**
     * Gestor de transacciones JDBC.
     * Necesario para @Transactional en los servicios.
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * Template principal para ejecutar sentencias MyBatis.
     * Se inyecta en los Mappers (EmployeeMapper, Hl7Mapper, etc.).
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}