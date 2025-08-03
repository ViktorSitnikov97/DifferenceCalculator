
plugins {
    id("org.sonarqube") version "6.2.0.5505"
    application
    jacoco
    id("checkstyle")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application {
    mainClass = "hexlet.code.App"
}

repositories {
    mavenCentral()
}

sonar {
    properties {
        property("sonar.projectKey", "ViktorSitnikov97_DataValidator")
        property("sonar.organization", "viktorsitnikov97")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

dependencies {
    implementation("info.picocli:picocli:4.7.5")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.16.0")
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.16.0")
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.14.2")
    implementation("org.apache.commons:commons-lang3:3.14.0")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
tasks.jacocoTestReport { reports { xml.required.set(true) } }