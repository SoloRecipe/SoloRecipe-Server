package com.sr.solorecipe

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SoloRecipeServerApplication

fun main(args: Array<String>) {
    runApplication<SoloRecipeServerApplication>(*args)
}
