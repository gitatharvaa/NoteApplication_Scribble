// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.24" apply false //1.8.21,1.8.10*
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id("androidx.room") version "2.6.1" apply false
    //id("org.jetbrains.kotlin.kapt") version "1.8.21" apply false //j18-17
    //ksp
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
}
buildscript {
//    extra["kotlin_version"] = "1.8.21"// or the latest version(4.10)
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.24")//1.8.21
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.44")
        // other classpath dependencies
    }
}
