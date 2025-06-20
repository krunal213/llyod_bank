plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)

    //hilt
    alias(libs.plugins.hilt)
    kotlin("kapt")

    //serialization
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.app.domain"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    //hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    //serialization
    implementation(libs.kotlinx.serialization.json)

    implementation(project(":data"))
}

hilt {
    enableAggregatingTask = false
}