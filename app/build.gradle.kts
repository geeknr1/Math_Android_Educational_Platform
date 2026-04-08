plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.license_project_2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.license_project_2"
        minSdk = 28
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

//    viewBinding{enable = true}
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.firebase.database)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
//    implementation(libs.anton46.stepsview)
//    implementation("com.github.kofigyan:StateProgressBar:69b4192777"){
//        exclude(group = "com.android.support", module = "support-v4")
//    }

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

}