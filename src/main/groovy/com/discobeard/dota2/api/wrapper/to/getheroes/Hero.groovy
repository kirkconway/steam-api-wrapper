package com.discobeard.dota2.api.wrapper.to.getheroes

import com.fasterxml.jackson.annotation.JsonProperty

class Hero {
    String name
    int id
    @JsonProperty(value = "localized_name")
    String localizedName
}
