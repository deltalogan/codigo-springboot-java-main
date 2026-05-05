package ar.com.smg.payroll.archunit;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_JODATIME;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "ar.com.smg.payroll", importOptions = ImportOption.DoNotIncludeTests.class)
public class CodingRulesTest {

        @ArchTest
        public static final ArchRule exceptions_should_respect_naming_convention = classes()
                        .that().resideInAPackage("..exception..")
                        .should().haveSimpleNameEndingWith("Exception");

        @ArchTest
        static ArchRule no_generic_exceptions = NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

        @ArchTest
        static ArchRule no_standard_streams = NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

        @ArchTest
        static ArchRule no_java_logging = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

        @ArchTest
        static ArchRule no_jodatime = NO_CLASSES_SHOULD_USE_JODATIME;

        @ArchTest
        static ArchRule classes_must_not_be_suffixed_with_impl = noClasses()
                        .should().haveSimpleNameEndingWith("Impl")
                        .because("Bad practice: Avoid 'Impl' suffix. Use meaningful names that reflect the role of the class, not its implementation status.");
        /**
         * Regla: Los controladores (RestController) DEBEN tener el sufijo "Controller"
         * Esto asegura una convención clara para identificar endpoints
         */
        @ArchTest
        public static final ArchRule controllers_should_be_named_with_controller_suffix = classes()
                        .that()
                        .haveSimpleNameEndingWith("Controller")
                        .should()
                        .resideInAPackage("..controller..")
                        .because("Controllers should reside in controller package and follow naming convention");

}