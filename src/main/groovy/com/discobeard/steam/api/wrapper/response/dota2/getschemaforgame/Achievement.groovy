package com.discobeard.steam.api.wrapper.response.dota2.getschemaforgame

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Achievement {
    String name
    short defaultvalue
    String displayName
    short hidden
    String description
    String icon
    String icongray
}
