plugins {
    id("java")
    id("maven-publish")
}

group = "com.tecknobit"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.clojars.org")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.json:json:20230227")
    implementation("com.github.N7ghtm4r3:APIManager:2.2.1")
    implementation("net.clojars.suuft:libretranslate-java:1.0.5")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "com.tecknobit.mantis"
                artifactId = "Mantis"
                version = "1.0.0"
                from(components["java"])
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}