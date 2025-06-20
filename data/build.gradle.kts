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
    namespace = "com.app.data"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildFeatures {
        buildConfig = true
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            //debug server url
            buildConfigField("String", "BASE_URL", "\"https://ghibliapi.vercel.app/\"")
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
    //retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    //serialization
    implementation(libs.kotlinx.serialization.json)

    implementation(project(":common"))
}

hilt {
    enableAggregatingTask = false
}