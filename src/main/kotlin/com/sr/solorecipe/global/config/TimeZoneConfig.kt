package com.sr.solorecipe.global.config

import org.springframework.stereotype.Component
import java.util.*

@Component
class TimeZoneConfig {
    init { TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul")) }
}