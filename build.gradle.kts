plugins {
    kotlin("jvm") version "2.0.20"
    application
}

application {
    mainClass.set("de.wyag.MainKt")
}

group = "de.wyag"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.argument.parser.clikt)
    implementation(libs.org.ini4j)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}