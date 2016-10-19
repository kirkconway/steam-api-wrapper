package com.discobeard.steam.api.wrapper.response.dota2.getheroes

import com.fasterxml.jackson.annotation.JsonProperty

class Hero {
    String name
    int id

    @JsonProperty(value = "localized_name")
    String localizedName
}
