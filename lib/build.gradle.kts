plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    `maven-publish`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies{
    implementation(libs.junit)
}

publishing{
    publications{
        register("release", MavenPublication::class){
            groupId = "com.whiskersapps.sniffer.kt"
            artifactId = "whiskersapps-sniffer-kt"
            version = "1.1.0"
            from(components["java"])
        }
    }
}

