plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.gms.google.services)

}

android {



    viewBinding {
        enable = true
    }
    namespace = "com.example.a227_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.a227_app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.core:core:1.12.0") // Compatible with compileSdk 34
    implementation("androidx.core:core-ktx:1.12.0") // Compatible with compileSdk 34
    implementation("androidx.activity:activity:1.7.2") // Latest compatible version
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database.ktx)
    implementation ("com.google.firebase:firebase-auth:21.3.0")
    implementation ("com.airbnb.android:lottie:6.0.0")
    implementation(libs.play.services.maps)
    implementation(libs.androidx.gridlayout)
    implementation ("com.google.android.material:material:1.9.0")
    implementation(libs.play.services.location)
    implementation ("com.google.android.gms:play-services-maps:18.0.2")
    implementation ("com.google.android.gms:play-services-location:21.0.1")
    implementation ("com.squareup.okhttp3:okhttp:4.10.0")
    implementation ("androidx.browser:browser:1.4.0")



}