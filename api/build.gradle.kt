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
}
