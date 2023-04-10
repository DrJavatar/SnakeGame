plugins {
    id("java")
    id("org.openjfx.javafxplugin") version "0.0.13"
    application
}

group = "com.game"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("com.game.application.SnakeApp")
}

javafx {
    modules("javafx.controls", "javafx.fxml")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}