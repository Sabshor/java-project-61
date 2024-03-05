plugins {
    application
    id("java")
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application {
    mainClass = "hexlet.code.App"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.14.0")
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}
