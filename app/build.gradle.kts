plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    namespace = "pro.ksart.coinview"
    compileSdk = rootProject.extra["maxSdkVersion"] as Int

    defaultConfig {
        applicationId = "pro.ksart.coinview"
        minSdk = rootProject.extra["minSdkVersion"] as Int
        targetSdk = rootProject.extra["maxSdkVersion"] as Int
        versionCode = rootProject.extra["codeVersion"] as Int
        versionName = rootProject.extra["nameVersion"] as String

        manifestPlaceholders["appAuthRedirectScheme"] = "pro.ksart.coinview"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["composeVersion"] as String
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.20")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Compose
    val composeVersion: String by rootProject.extra
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.activity:activity-compose:1.6.1")
    // Compose dependencies
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0-alpha03")
    implementation("androidx.navigation:navigation-compose:2.6.0-alpha03")
    implementation("com.google.accompanist:accompanist-flowlayout:0.17.0")
    // Fragment
    val fragmentVersion: String by rootProject.extra
    implementation("androidx.fragment:fragment-ktx:$fragmentVersion")
    implementation("androidx.activity:activity-ktx:1.6.1")
    // Lifecycle KTX
    val lifecycleVersion: String by rootProject.extra
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    // Saved State module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleVersion")
    // Coroutines and Flow
    val coroutinesVersion: String by rootProject.extra
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    // Dagger Hilt
    val hiltVersion: String by rootProject.extra
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    // Retrofit
    val retrofitVersion: String by rootProject.extra
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion")
    // Okhttp
    val okhttpVersion = "5.0.0-alpha.3"
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")
    // Moshi
    val moshiVersion: String by rootProject.extra
    implementation("com.squareup.moshi:moshi:$moshiVersion")
    implementation("com.squareup.moshi:moshi-kotlin:$moshiVersion")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion")
    // RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    // DateTime
    implementation("com.jakewharton.threetenabp:threetenabp:1.3.1")
    // Coil
    val coilVersion = "1.4.0"
    implementation("io.coil-kt:coil-base:$coilVersion")
    implementation("io.coil-kt:coil:$coilVersion")
    // Paging3
    implementation("androidx.paging:paging-runtime-ktx:3.1.1")
    // Timber
    implementation("com.jakewharton.timber:timber:5.0.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
}
