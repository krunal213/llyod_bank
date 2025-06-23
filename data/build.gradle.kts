plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)

    //hilt
    kotlin("kapt")

    //serialization
    alias(libs.plugins.kotlin.serialization)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}

dependencies {
    //retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //hilt
    implementation(libs.hilt.core)
    kapt(libs.hilt.compiler)

    //serialization
    implementation(libs.kotlinx.serialization.json)

    implementation(project(":domain"))
}

