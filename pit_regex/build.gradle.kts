plugins {
	java
	id("org.springframework.boot") version "3.0.6"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "br.edu.cruzeirodosul.ads.pit.wesleyvlk"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web:3.0.4")
	compileOnly("org.projectlombok:lombok:1.18.26")
	annotationProcessor("org.projectlombok:lombok:1.18.26")
	developmentOnly("org.springframework.boot:spring-boot-devtools:3.0.4")
	testImplementation("org.springframework.boot:spring-boot-starter-test:3.0.4")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
