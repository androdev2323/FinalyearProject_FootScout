plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("com.google.devtools.ksp")

    id("com.google.dagger.hilt.android")
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrains.serial)
}



    android {
        namespace = "com.example.minip_footscout"
        compileSdk = 34

        defaultConfig {
            applicationId = "com.example.minip_footscout"
            minSdk = 30
            targetSdk = 34
            versionCode = 1
            versionName = "1.0"

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables {
                useSupportLibrary = true
            }
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
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = "1.5.1"
        }
        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
    }

    dependencies {

        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx)
        implementation(libs.androidx.activity.compose)
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.ui)
        implementation(libs.androidx.ui.graphics)
        implementation(libs.androidx.ui.tooling.preview)
        implementation(libs.androidx.material3)
        implementation(libs.coil.compose)
        implementation(libs.androidx.ui.text.google.fonts)
        
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
        androidTestImplementation(platform(libs.androidx.compose.bom))
        androidTestImplementation(libs.androidx.ui.test.junit4)
        debugImplementation(libs.androidx.ui.tooling)
        debugImplementation(libs.androidx.ui.test.manifest)

        implementation(libs.androidx.room.runtime)
        implementation(libs.hilt.android)
        ksp(libs.hilt.android.compiler)
        implementation(libs.androidx.hilt.navigation.compose)
        implementation(libs.hilt.android)
        ksp(libs.androidx.room.compiler)
        implementation(libs.retrofit)
        implementation(libs.gsonConverter)
        implementation(libs.serialization)
        implementation(libs.navigationcompose)


        implementation(libs.androidx.room.ktx)
    }
