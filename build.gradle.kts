import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.10"
    id ("jacoco")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation (kotlin("stdlib"))
    testImplementation ("junit:junit:4.13.2")
}



tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}