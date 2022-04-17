import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import com.adarshr.gradle.testlogger.theme.ThemeType



version = "1.0-SNAPSHOT"
description = """

    This is Event Counter application, which might be useful to manage count of event customers.
    Project name: ${project.name}
"""


plugins{
//    // basic java plugin
//    java
//    // java Gradle Core plugin used to build applications
//    `java-library`
//    // Community testing plugin for better more customizable test output
    application
    id("com.adarshr.test-logger") version "3.2.0"
}



// set main class name for the project
application {
    mainClass.set("EventCustomerCounter.App")
}


java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    withJavadocJar()
    withSourcesJar()
}



repositories{
    mavenCentral()
}


// we can customize test output here
tasks {
    testlogger {
        setTheme("standard")
        showExceptions = true
        showStackTraces = true
        showFullStackTraces = false
        showCauses = true
        slowThreshold = 2000
        showSummary = true
        showSimpleNames = false
        showPassed = true
        showSkipped = true
        showFailed = true
        showStandardStreams = false
        showPassedStandardStreams = true
        showSkippedStandardStreams = true
        showFailedStandardStreams = true
    }
}


/*
// This is another approach how to get information regarding the passed, failed or skipped tests on clean build
// it is working, but it is not customizable as using testing plugin

tasks {
    test {
        // specify which output information we want to see from testing
        testLogging.events = setOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
    }
}
*/



// set application dependencies
// TestNG in our case for testing
dependencies{
    testImplementation("org.testng:testng:7.5")
}



// provide source path for main and test folders
sourceSets {
    main {
        java {
            srcDir("main")

        }
    }
    test {
        java {
            srcDir(("test"))
        }
    }
}


// testing task
tasks.test{

    println("Running Tests")
    useTestNG()
}



tasks.register<Javadoc>("createJavadocs") {
    println("Creating Javadocs...")
    source(sourceSets["main"].allSource)
}

