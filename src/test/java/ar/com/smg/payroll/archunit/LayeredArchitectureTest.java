package ar.com.smg.payroll.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

/**
 * Test de Arquitectura para verificar la estructura en capas del sistema.
 * <p>
 * Este test implementa validaciones de arquitectura b&aacute;sicas usando ArchUnit.
 * Puedes eliminar reglas que no apliquen a tu estructura o agregar nuevas
 * seg&uacute;n evolucione tu proyecto.
 */
@AnalyzeClasses(packages = "ar.com.smg.payroll", importOptions = ImportOption.DoNotIncludeTests.class)
public class LayeredArchitectureTest {

    private static final String DOMAIN = "Domain";
    private static final String ADAPTERS = "Adapters";
    private static final String APPLICATION = "Application";
    private static final String CONFIG = "Config";
    private static final String PERSISTENCE = "Persistence";
    private static final String CONTROLLER = "Controller";

    @ArchTest
    public static final ArchRule layer_dependencies_are_respected = Architectures.layeredArchitecture()
            .consideringAllDependencies()
            .layer(CONFIG).definedBy("..config..")
            .layer(DOMAIN).definedBy("..domain..")
            .layer(ADAPTERS).definedBy("..adapter..")
            .layer(APPLICATION).definedBy("..application..")
            .layer(PERSISTENCE).definedBy("..persistence..")
            .layer(CONTROLLER).definedBy("..controller..")
            
            .whereLayer(CONTROLLER).mayNotBeAccessedByAnyLayer()
            .whereLayer(APPLICATION).mayOnlyBeAccessedByLayers(ADAPTERS, CONTROLLER)
            // .whereLayer(ADAPTERS).mayOnlyBeAccessedByLayers(CONFIG)
            .whereLayer(PERSISTENCE).mayOnlyBeAccessedByLayers(APPLICATION, ADAPTERS)
            .whereLayer(DOMAIN).mayOnlyBeAccessedByLayers(APPLICATION, ADAPTERS, CONFIG, PERSISTENCE, CONTROLLER)
            .allowEmptyShould(true);

}
