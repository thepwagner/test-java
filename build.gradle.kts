plugins {
  `maven-publish`
  kotlin("jvm") version "1.3.72"
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib-jdk8"))
}

publishing {
  publications {
    create<MavenPublication>("maven") {
      groupId = "com.github.thepwagner"
      artifactId = "test-java"
      version = "1.0"

      from(components["java"])
    }
  }

  repositories {
    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/thepwagner/test-java")
      credentials {
        username = "thepwagner"
        password = System.getenv("GITHUB_TOKEN")
      }
    }
  }
}
