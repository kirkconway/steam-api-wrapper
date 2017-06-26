package com.discobeard.steam.api.wrapper.response.dota2.getheroes

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Hero {
    String name
    int id

    @JsonProperty(value = "localized_name")
    String localizedName
}
