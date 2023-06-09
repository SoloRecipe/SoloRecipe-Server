package com.sr.solorecipe

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import java.util.*
import javax.annotation.PostConstruct

@SpringBootApplication
@ConfigurationPropertiesScan
class SoloRecipeServerApplication

fun main(args: Array<String>) {
    runApplication<SoloRecipeServerApplication>(*args)
}
