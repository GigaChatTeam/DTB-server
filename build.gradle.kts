val logbackVersion: String by project
val log4jVersion: String by project
val ktorVersion: String by project
val eventBusVersion: String by project

plugins {
    val kotlinVersion = "2.0.0" // TODO: explore the possibility of defining a version in a general context
    val ktorVersion = "2.3.12" // TODO: explore the possibility of defining a version in a general context

    kotlin("jvm") version kotlinVersion
    id("io.ktor.plugin") version ktorVersion
    id("org.jetbrains.kotlin.plugin.serialization") version kotlinVersion
}


group = "com.gigachat.product"
version = "0.0.1-dev"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    // Logging
    implementation(group = "ch.qos.logback", name = "logback-classic", version = logbackVersion)
    implementation(group = "org.apache.logging.log4j", name = "log4j-core", version = log4jVersion)
    implementation(group = "org.apache.logging.log4j", name = "log4j-slf4j-impl", version = log4jVersion)

    // KTor
    implementation(group = "io.ktor", name = "ktor-server-core-jvm", version = ktorVersion)
    implementation(group = "io.ktor", name = "ktor-server-netty-jvm", version = ktorVersion)
    implementation(group = "io.ktor", name = "ktor-server-config-yaml", version = ktorVersion)
    implementation(group = "io.ktor", name = "ktor-server-websockets-jvm", version = ktorVersion)
    implementation(group = "io.ktor", name = "ktor-serialization-kotlinx-json-jvm", version = ktorVersion)
    implementation(group = "io.ktor", name = "ktor-server-content-negotiation-jvm", version = ktorVersion)
    implementation(group = "io.ktor", name = "ktor-server-cors-jvm", version = ktorVersion)

    // EventBus
    implementation(group = "com.github.therealbush", name = "eventbus-kotlin", version = eventBusVersion)
}

kotlin {
    jvmToolchain(21)
}