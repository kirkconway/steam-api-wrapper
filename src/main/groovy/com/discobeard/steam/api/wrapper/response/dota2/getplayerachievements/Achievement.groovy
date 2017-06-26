package com.discobeard.steam.api.wrapper.response.dota2.getplayerachievements

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Achievement {
    String apiname
    short achieved
    String name
    String description
}
