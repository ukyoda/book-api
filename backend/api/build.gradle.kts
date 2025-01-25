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
	implementation("com.auth0:java-jwt:4.4.0")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
}
