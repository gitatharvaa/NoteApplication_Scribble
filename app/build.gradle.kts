plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    //kapt to ksp
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.scribble"
            //"example.scribble"
        //
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.scribble"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

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
        sourceCompatibility = JavaVersion.VERSION_1_8 //compiledebugjavawithjavac
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    // Use Java toolchain
    //
    kotlinOptions {
        jvmTarget = "1.8" //kaptGenerate...
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"//"1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.1")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui:1.6.8")//cv
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.material:material:1.6.8")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.8")//cv
    implementation("androidx.compose.material3:material3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.1")

    //dex depend
    implementation("androidx.multidex:multidex:2.0.1")



    //Hilt-dagger extension below 2 lines
//    implementation("com.google.dagger:hilt-android:2.44")
//    annotationProcessor("com.google.dagger:hilt-android-compiler:2.44")
//    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
//    annotationProcessor("androidx.hilt:hilt-compiler:1.2.0")
    //hilt github
    implementation ("com.google.dagger:hilt-android:2.44")
    ksp("com.google.dagger:hilt-compiler:2.44")



    //Room
    implementation ("androidx.room:room-runtime:2.6.1")
    annotationProcessor ("androidx.room:room-compiler:2.6.1")
//    testImplementation("junit:junit:4.13.2")


    // To use Kotlin annotation processing tool (kapt) MUST HAVE!
    ksp("androidx.room:room-compiler:2.6.1") //kapt(---""----)
    implementation("androidx.room:room-ktx:2.6.1")


    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")


    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.6.8")//cv
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.8")//cv
   // debugImplementation("androidx.compose.ui:ui-test-manifest:1.6.8")
}

//Annotation processing
ksp {
    arg("dagger.hilt.disableModulesHaveInstallInCheck", "true")
}



