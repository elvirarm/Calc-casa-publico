plugins {
    kotlin("jvm") version "2.0.10"
}

group = "prog2425.dam1.calcbasica"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}