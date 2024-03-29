﻿plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt") version "1.9.10"
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.runningapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.runningapp"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    tasks.withType<org.jetbrains.kotlin.gradle.internal.KaptWithoutKotlincTask>()
        .configureEach {
            kaptProcessJvmArgs.add("-Xmx512m")
        }
}
kapt {
    correctErrorTypes = true
    useBuildCache = false
}
dependencies {


    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.dagger:dagger:2.48")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.fragment:fragment-ktx:1.6.1")

    // Material Design
//    implementation ("com.google.android.material:material:1.3.0-alpha01")

    // Architectural Components
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

    // Room
    implementation("androidx.room:room-runtime:2.5.2")
    kapt("androidx.room:room-compiler:2.5.2")
    implementation("androidx.room:room-ktx:2.5.2")


    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // Coroutine Lifecycle Scopes
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")

    // Navigation Components
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.0")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.11.0")
    kapt("com.github.bumptech.glide:compiler:4.11.0")

    // Google Maps Location Services
    implementation("com.google.android.gms:play-services-location:17.0.0")
    implementation("com.google.android.gms:play-services-maps:17.0.0")

    // Dagger Core


    // Activity KTX for viewModels()
    implementation("androidx.activity:activity-ktx:1.1.0")
    //ovo je novi
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    //kraj novog

//    implementation("com.google.dagger:dagger:2.48")
//    kapt("com.google.dagger:dagger-compiler:2.48")

    // Dagger Android
//    api("com.google.dagger:dagger-android:2.28.3")
//    api("com.google.dagger:dagger-android-support:2.28.3")
//    kapt("com.google.dagger:dagger-android-processor:2.23.2")

    //Hilt
//    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01")
//    kapt("androidx.hilt:hilt-compiler:1.0.0-alpha01")


//    // Easy Permissions
    implementation("pub.devrel:easypermissions:3.0.0")
//
//    // Timber

    implementation("com.jakewharton.timber:timber:5.0.1")
//    // MPAndroidChart
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")

//    implementation ("android.arch.lifecycle:extensions:1.1.1")
}
