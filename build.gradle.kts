plugins {
    base
    alias(libs.plugins.kotlin.serialization) apply false
}

group = "org.nixos.gradle2nix"
version = property("VERSION") ?: "unspecified"

subprojects {
    group = rootProject.group
    version = rootProject.version

    tasks.withType<Jar> {
        isPreserveFileTimestamps = false
        isReproducibleFileOrder = true
    }
}

tasks {
    wrapper {
        gradleVersion = libs.versions.gradle.get()
        distributionType = Wrapper.DistributionType.ALL
    }
}
