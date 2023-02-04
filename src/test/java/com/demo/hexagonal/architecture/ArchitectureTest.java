package com.demo.hexagonal.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
class ArchitectureTest {

    JavaClasses classpath = new ClassFileImporter().importPackages("com.demo.hexagonal");

    @Test
    void useCases_shouldBeInProperPackage_andBeInterfaces() {
        ArchRule rule = classes().that().haveSimpleNameEndingWith("UseCase")
                .should().resideInAnyPackage("..application.usecase..")
                .andShould().beInterfaces();
        rule.check(classpath);
    }


}
