val junitJupiterVersion = "5.7.0"


plugins {
   kotlin("jvm") version "1.4.20"
}

java {
   sourceCompatibility = JavaVersion.VERSION_15
   targetCompatibility = JavaVersion.VERSION_15
}

repositories {
   mavenCentral()
   jcenter()
}

dependencies {
   implementation(kotlin("stdlib"))

   testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
   testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}

tasks {
   withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
      kotlinOptions {
         jvmTarget = "15"
      }
   }

   withType<Test> {
      useJUnitPlatform()
   }

   withType<Wrapper> {
      gradleVersion = "6.7.1"
   }

}
