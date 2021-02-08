import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("org.springframework.boot") version "2.4.2"
    id("com.avast.gradle.docker-compose") version "0.14.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.jetbrains.kotlin.jvm") version "1.4.30"
    id("org.jetbrains.kotlin.plugin.spring") version "1.4.30"
    id("org.jetbrains.kotlin.plugin.noarg") version "1.4.30"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.30"
    id("org.jlleitschuh.gradle.ktlint-idea") version "9.4.1"
    id("org.jetbrains.dokka") version "0.11.0-dev-59"
    id("idea")
    id("eclipse")
}

group "org.example"
version "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

sourceSets {
    create("integrationTest") {
        withConvention(KotlinSourceSet::class) {
            kotlin.srcDir("src/integrationTest/kotlin")
            resources.srcDir("src/integrationTest/resources")
            compileClasspath += sourceSets["main"].output + sourceSets["test"].output
            runtimeClasspath += output + compileClasspath + sourceSets["test"].runtimeClasspath
        }
    }
}

//noArg {
//    annotation()
//}

dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib"
}
