plugins {
  `kotlin-dsl`
  `java-gradle-plugin`
  id("com.github.ben-manes.versions") version "0.17.0"
}

repositories {
  jcenter()
}

dependencies {
  implementation("com.fasterxml.jackson.core:jackson-core:2.9.3")
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.9.0")
  implementation("com.squareup.retrofit2:converter-jackson:2.3.0")
  implementation("com.squareup.retrofit2:retrofit:2.3.0")
}

gradlePlugin {
  plugins.invoke {
    // Don't get the extensions for NamedDomainObjectContainer here because we only have a NamedDomainObjectContainer
    // See https://github.com/gradle/kotlin-dsl/issues/459
    register("sharedLibrary") {
      id = "buildsrc.jenkins-rebaseline"
      implementationClass = "buildsrc.jenkins.baseline.JenkinsRebaselineToolsPlugin"
    }
  }
}
