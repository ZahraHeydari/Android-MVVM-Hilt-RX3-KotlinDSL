// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath (BuildPlugins.androidGradlePlugin)
        classpath (BuildPlugins.kotlinGradlePlugin)
        classpath(BuildPlugins.hiltDaggerGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}

tasks.register("clean").configure {
    delete("build")
}