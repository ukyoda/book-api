plugins {
    kotlin("jvm")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(19)
}

dependencies {
    implementation(project(":common"))
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
}
