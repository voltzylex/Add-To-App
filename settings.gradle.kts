pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven {
            // Path to the Flutter module's locally built AAR repository
            url = uri("/Users/giteshdang/Documents/FlutterDev/Projects/my_flutter/build/host/outputs/repo")
            metadataSources {
                mavenPom()
            }
        }
        maven {
            // Flutter's official Maven repository for required dependencies
            url = uri("https://storage.googleapis.com/download.flutter.io")
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    // Change FAIL_ON_PROJECT_REPOS to PREFER_SETTINGS if Gradle fails to resolve dependencies
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            // Local repository for Flutter module
            url = uri("/Users/giteshdang/AndroidStudioProjects/NativeAndroid/my_flutter/build/host/outputs/repo")
        }
        maven {
            // Flutter's hosted dependencies
            url = uri("https://storage.googleapis.com/download.flutter.io")
        }
    }
}

// Set the project name
rootProject.name = "NativeAndroid"

// Include the main app module
include(":app")
include(":mylibrary")
