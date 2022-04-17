// give a name to the build
rootProject.name = "EventCustomerCounter"
// specify that app contains project called app
// we can add more projects with another include(name) lines
include("app")


plugins {
    id("com.gradle.enterprise") version("3.9")
}

// we need to agree with terms of service to publish build scans
gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
         publishAlways()
    }
}
